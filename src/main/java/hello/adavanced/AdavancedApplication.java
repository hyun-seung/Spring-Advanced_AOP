package hello.adavanced;

import hello.adavanced.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app") // 주의
public class AdavancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdavancedApplication.class, args);
	}

}
