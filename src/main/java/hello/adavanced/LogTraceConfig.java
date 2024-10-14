package hello.adavanced;

import hello.adavanced.trace.logTrace.FieldLogTrace;
import hello.adavanced.trace.logTrace.LogTrace;
import hello.adavanced.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
