package cn.gcjlearn.sp07hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
// 以上三个可以替换为：SpringCloudApplication
@SpringCloudApplication
public class Sp07HystrixApplication {
	//创建 RestTemplate 实例，并存入 spring 容器
	@Bean
	//@LoadBalanced 负载均衡注解，会对 RestTemplate 实例进行封装，创建动态代理对象，并切入（AOP）负载均衡代码，把请求分散分发到集群中的服务器
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		/*
			ConnectionTimeout
			ReadTimeout
			OkToRetryOnAllOperations=true
			对连接超时、读取超时都进行重试
			MaxAutoRetriesNextServer
			更换实例的次数
			MaxAutoRetries
			当前实例重试次数，尝试失败会更换下一个实例
		 */


		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);

	}

	public static void main(String[] args) {
		SpringApplication.run(Sp07HystrixApplication.class, args);
	}

}
