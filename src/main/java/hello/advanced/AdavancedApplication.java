package hello.advanced;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import hello.advanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.advanced.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.advanced.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.advanced.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import hello.advanced.proxy.config.v5_autoproxy.AutoProxyConfig;
import hello.advanced.proxy.config.v6_aop.AopConfig;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app") // 주의
public class AdavancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdavancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
