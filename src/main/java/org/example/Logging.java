package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Аспект для логирования вызовов методов, их параметров, возвращаемых значений
 * и исключений. Использует библиотеку SLF4J для логирования.
 */

@Aspect
public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    /**
     * Аспект, который перехватывает выполнение всех методов в пакетах и подпакетах
     * `org.example`. Логирует вызов метода, его параметры, возвращаемое значение,
     * а также возможные исключения, которые могут возникнуть в ходе выполнения метода.
     *
     * @param joinPoint объект типа ProceedingJoinPoint, представляющий метод,
     *                  который был вызван, а также содержащий информацию о параметрах и других деталях.
     * @return возвращаемое значение метода, если оно существует.
     * @throws Throwable если метод выбросил исключение, оно будет переброшено дальше.
     */
    @Around("execution(* org.example..*(..))")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] methodArgs = joinPoint.getArgs();

        // Логирование вызова метода с параметрами
        logger.info("method call: " + methodName + " with parameters: " + java.util.Arrays.toString(methodArgs));

        Object result = null;
        try {
            // Выполнение метода
            result = joinPoint.proceed();

            // Логирование возвращаемого значения
            logger.info("method " + methodName + " result: " + result);
        } catch (Throwable ex) {
            // Логирование исключения
            logger.error("method " + methodName + " threw exception: " + ex);
            throw ex; // Перебрасываем исключение дальше
        }

        return result;
    }

}
