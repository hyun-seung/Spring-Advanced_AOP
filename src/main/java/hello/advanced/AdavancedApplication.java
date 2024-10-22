package hello.advanced;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import hello.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app.v1") // 주의
public class AdavancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdavancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
