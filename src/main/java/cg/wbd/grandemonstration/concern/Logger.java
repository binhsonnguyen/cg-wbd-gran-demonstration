package cg.wbd.grandemonstration.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @AfterThrowing(
            pointcut = "execution(public * cg.wbd.grandemonstration.service..*.*(..))", throwing = "e")
    public void error(Exception e) {
        System.out.println("[CMS] ERROR!" + e.getMessage());
    }

}
