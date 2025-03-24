package hello.advanced.trace.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        log.info("start");
        String result1 = target.callA();
        log.info("result={}", result1);

        log.info("start");
        String result2 = target.callA();
        log.info("result={}", result2);

    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("hello.advanced.trace.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCalllA = classHello.getMethod("callA");
        Object result1 = methodCalllA.invoke(target);
        log.info("result1={}", result1);

        Method methodCalllB = classHello.getMethod("callB");
        Object result2 = methodCalllB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    void reflection2() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("hello.advanced.trace.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCalllA = classHello.getMethod("callA");
        dynamicCall(methodCalllA, target);

        Method methodCalllB = classHello.getMethod("callB");
        dynamicCall(methodCalllB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
