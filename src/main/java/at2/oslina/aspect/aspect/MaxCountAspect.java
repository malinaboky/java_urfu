package at2.oslina.aspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.nio.channels.AcceptPendingException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
@Slf4j
public class MaxCountAspect {
    private final Map<String, Integer> requestPool = new ConcurrentHashMap<>();

    @Before("execution(* at2.oslina.aspect.controller.IndexController.*(..))" +
            " && @annotation(maxCount)")
    public void counter(JoinPoint joinPoint, MaxCount maxCount) {
        int oldValue = requestPool.getOrDefault(joinPoint.getSignature().getName(), 0);
        if (oldValue >= maxCount.max())
            throw new IllegalArgumentException(
                    "Вы обратились " + (oldValue + 1) + " раз, муксимум " + maxCount.max());
        requestPool.put(joinPoint.getSignature().getName(), oldValue + 1);
    }
}
