package cn.gcjlearn.excel;

import cn.gcjlearn.common.Excel;
import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.StringUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author ：GongCJ
 * @date ：Created in 08-09-2019 11:17
 * @description：excel处理工具
 * @modified By：
 * @version: v1.0
 */
public class ExcelUtils {
	private ExcelUtils() {
	}

	/**
	 * 封装注解名称对应set方法信息，可重复
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Entry<K, V> {
		private K titleName;
		private V method;


		Entry(K titleName, V method) {
			this.titleName = titleName;
			this.method = method;
		}

		K getKey() {
			return this.titleName;
		}

		V getValue() {
			return this.method;
		}

	}

	/**
	 * 类型转换类
	 */
	public static class ConvertType{
		private Method method = null;
		private Object data = null;

		public void convertType(String typeName,String value) throws IllegalAccessException, InvocationTargetException{
			switch (method.getParameterTypes()[0].getSimpleName()) {
				case "Integer":
					doConvertType(new Integer(value));
					break;
				case "String":
					doConvertType(value);
					break;
				default:
					throw new IllegalArgumentException("没有找到指定的类型，请实现ExcelUtils.ConvertType类，并且重写convertType方法。");
			}
		}
		final protected  <T> void doConvertType(T value) throws InvocationTargetException, IllegalAccessException {
			this.method.invoke(data,value);
		}
	}



	/**
	 * 存储field对应的get及set方法
	 */
	private Map<String, ExcelUtils.Entry<String, Method>> fieldGetMethods = new LinkedHashMap<>();
	private Map<String, ExcelUtils.Entry<String, Method>> fieldSetMethods = new LinkedHashMap<>();

	/**
	 * 存放需要转换为Excel的数据
	 */
	private List toExcelListInfo;

	/**
	 * Pojo字节码对象
	 */
	private Class cla = null;

	/**
	 * 创建一个workbook及sheet
	 */
	private HSSFWorkbook workbook = null;
	private HSSFSheet sheet = null;
	/**
	 * set方法：method
	 * 目标数据：targetData
	 * 数据：value
	 */
	private Method setMethod = null;
	private Object targetData = null;
	private String value = null;

	/**
	 * @param cla  数据的字节码对象
	 * @param list 数据集合
	 */
	public static <T> ExcelUtils toExcel(Class<T> cla, List<T> list) {
		ExcelUtils excelUtils = new ExcelUtils();
		excelUtils.cla = cla;
		excelUtils.toExcelListInfo = list;
		excelUtils.workbook = new HSSFWorkbook();
		excelUtils.sheet = excelUtils.workbook.createSheet("sheet1");
		excelUtils.doFieldGetAndSetMethod();
		return excelUtils;
	}

	public static <T> ExcelUtils toEntry(Class<T> cla) {
		ExcelUtils excelUtils = new ExcelUtils();
		excelUtils.cla = cla;
		excelUtils.doFieldGetAndSetMethod();
		return excelUtils;
	}

	/**
	 * 获取含有Excel标签对应属性名称及get/set方法对象;
	 */
	private void doFieldGetAndSetMethod() {

		/*
		 * 获取对象中的所有属性
		 */
		Field[] fields = cla.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Excel.class)) {
				/*
				 * 获取含有Excel标签对应属性名称及get/set方法对象;
				 */
				fieldToGetMethod(field);
			}
		}
	}

	/**
	 * @param field 属性名称
	 */
	private void fieldToGetMethod(Field field) {
		String getMethods = convertPrefix("get", field.getName());
		String setMethods = convertPrefix("set", field.getName());

		/*
		 * 获取Excel注解中的信息
		 */
		Excel excel = field.getAnnotation(Excel.class);
		try {

			/*
			 * 获取get方法，参数类型为：当前属性类型
			 */
			Method getMethod = cla.getDeclaredMethod(getMethods);


			/*
			 * 获取set方法，参数类型为：当前属性类型
			 */
			setMethod = cla.getDeclaredMethod(setMethods, field.getType());

			/*
			 * 判断titleName是否为空，为空时使用field名称输出
			 * 将titleName和方法封装到ExcelUtils.Entry中，并且存入map集合中
			 */
			fieldGetMethods.put(field.getName(),
					new ExcelUtils.Entry<>("".equals(excel.titleName()) ? field.getName() : excel.titleName(), getMethod));
			fieldSetMethods.put(field.getName(),
					new ExcelUtils.Entry<>("".equals(excel.titleName()) ? field.getName() : excel.titleName(), setMethod));


		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param prefix 拼接的前缀
	 * @param field  属性名称
	 * @return 返回prefix+Field
	 */
	private String convertPrefix(String prefix, String field) {
		return prefix + field.substring(0, 1).toUpperCase() + field.substring(1);
	}

	/**
	 * 将数据转为Excel
	 */
	private void processingDataToExcel() {
		/*
		 * 定义行列信息
		 */
		HSSFRow row = null;
		HSSFCell cell = null;
		int rowIndex = 0;
		int cellIndex = 0;

		/*
		 * 处理titleName信息
		 */
		row = sheet.createRow(0);
		for (ExcelUtils.Entry<String, Method> entry : fieldGetMethods.values()) {
			row.createCell(cellIndex).setCellValue(entry.getKey());
			cellIndex++;
		}

		/*
		 * 处理需要输出到excel中的数据
		 */
		rowIndex = 1;
		for (Object dataInfo : toExcelListInfo) {
			cellIndex = 0;
			row = sheet.createRow(rowIndex++);
			for (ExcelUtils.Entry<String, Method> entry : fieldGetMethods.values()) {
				try {
					row.createCell(cellIndex).setCellValue(entry.getValue().invoke(dataInfo).toString());
					cellIndex++;

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 设置类型转换器
	 */
	private ConvertType convertType = null;
	/**
	 * 将Excel转为Pojo对象
	 */
	private List processingExcelToData() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		LinkedList<String> titleNames = new LinkedList<>();
		/*
			计算总行数
		 */
		int rowCount = this.sheet.getLastRowNum() - sheet.getFirstRowNum();
		List entry = new ArrayList(rowCount + 1);
		int cellCount = 0;
		HSSFRow row = null;

		/**
		 * 遍历title信息
		 */
		row = this.sheet.getRow(this.sheet.getFirstRowNum());
		cellCount = row.getLastCellNum() - row.getFirstCellNum();
		for (int i = 0; i < cellCount; i++) {
			titleNames.add(i,row.getCell(i).getStringCellValue());
		}

		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			this.targetData = cla.getDeclaredConstructor().newInstance();
			row = this.sheet.getRow(rowIndex);
			for (int i = 0; i < titleNames.size(); i++) {
				this.setMethod = this.fieldSetMethods.get(titleNames.get(i)).method;
				this.value = row.getCell(i).getStringCellValue();
				convertType(this.convertType);
			}
			entry.add(rowIndex - 1, this.targetData);
		}

		return entry;
	}

	/**
	 * 数据转换为set方法中的类型
	 */
	public void convertType(ConvertType convertType) throws IllegalAccessException, InvocationTargetException {

		convertType.method = this.setMethod;
		convertType.data = this.targetData;
		convertType.convertType(this.setMethod.getParameterTypes()[0].getSimpleName(),this.value);
	}

	/**
	 * @param fineName   文件路径
	 * @param sheetIndex 数据所在的sheet位置
	 * @return 返回一个pojo对象
	 */
	public List parseExcel(String fineName, Integer sheetIndex) {
		ConvertType convertType = new ConvertType();
		return this.parseExcel(fineName,sheetIndex,convertType);
	}
	public List parseExcel(InputStream inputStream, Integer sheetIndex) {
		ConvertType convertType = new ConvertType();
		return this.parseExcel(inputStream,sheetIndex,convertType);
	}
	public List parseExcel(String fineName, Integer sheetIndex,ConvertType convertType) {
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(fineName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.parseExcel(inputStream,sheetIndex,convertType);
	}
	public List parseExcel(InputStream inputStream, Integer sheetIndex,ConvertType convertType) {
		List list = null;
		try {
			workbook = new HSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(sheetIndex);
			this.convertType = convertType;
			list = processingExcelToData();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 生成excel文件
	 */
	public void buildExcelFile(String fileName) {
		processingDataToExcel();
		OutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(fileName + ".xls"));
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 浏览器下载excel
	 *
	 * @param response 传递一个response响应
	 * @throws Exception
	 */
	public void buildExcelDocument(String filename, HttpServletResponse response) throws IOException {
		processingDataToExcel();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename + ".xls", "utf-8"));
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

}
