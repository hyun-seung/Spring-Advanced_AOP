package hello.advanced;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app") // 주의
public class AdavancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdavancedApplication.class, args);
	}

}
