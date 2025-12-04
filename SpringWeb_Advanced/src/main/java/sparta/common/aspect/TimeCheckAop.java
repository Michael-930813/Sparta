package sparta.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeCheckAop {
// - Properties

// - Methods
    // - What : UserService Methods
    // - When : Method Around
    // - How : Active executionTime Method
    @Around("execution(* sparta.user.service.UserService.*(..))")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws  Throwable {
        // - Before Start Method
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();
        // - After Start Method
        long end = System.currentTimeMillis();
        log.info("[AOP] {} 실행됨 in {}ms", joinPoint.getSignature(), end - start);

        return result;
    }
}
