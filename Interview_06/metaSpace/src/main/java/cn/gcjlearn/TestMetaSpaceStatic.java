package cn.gcjlearn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class TestMetaSpaceStatic {
	
	//ctrl f11 run as 
	//-XX:MetaspaceSize=16m -XX:MaxMetaspaceSize=16m 
	//OutOfMemoryError: Metaspace
		//-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m
	public static ArrayList<Object> list=new ArrayList<>();
	public static void main(String[] args) throws Throwable{
		int i=0;
		while (true)
		{
			i++;
			 System.out.println("i="+i);
			loadClassByFile(i);
			Thread.currentThread().sleep(100);
			//if (i==10)
			//{
			//	break;
			//}
		}
	}
    private static void loadClassByFile(int i) throws Exception{
        String studentString = "package org.myself.pojo;"
        		+ "public class Test"
        		+ "{"
        		+ "private String studentId;"
        		+ "public String getStudentId()"
        		+ "{"
        		+ "return this.studentId;"
        		+ "}"
        		
        		+ "public void setStudentId(String studentId)"
        		+ "{"
        		+ "this.studentId = studentId;"
        		+ "}"
        		+ "}";
       String baseDir=  System.getProperty("user.dir") + "/src2/"+i+"/java/org/myself/pojo";      
       File baseDirectory=new File(baseDir);
       if (baseDirectory.exists()==false){
    	   baseDirectory.mkdirs();
       }
       
       
       String fileName = baseDir+"/Test.java";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(studentString);
        fileWriter.flush();
        fileWriter.close();
 
 
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(fileName);
        String classDir = System.getProperty("user.dir")+"/classes/"+i + "/target/";
        File directory=new File(classDir);
	    if (directory.exists()==false){
	    	directory.mkdirs();
	    }
        
        //options就是指定编译输入目录，与我们命令行写javac -d C://是一样的
 
        List<String> options = new ArrayList<String>();
        options.add("-d");
        options.add(classDir);
        JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,options,null,javaFileObjects);
        task.call();
        manager.close();
        
		 MyClassLoader01 classLoader = new MyClassLoader01(classDir);
		 //此类不要和当前类放相同目录结构中
		 String pkgCls="org.myself.pojo.Test";
	     Class<?> testClass = classLoader.loadClass(pkgCls);
	     Object object = testClass.newInstance();
	    
	     System.out.println(object);
	     System.out.println(object.getClass().hashCode());
	     list.add(object);
	     list.add(object.getClass());
    }

}
