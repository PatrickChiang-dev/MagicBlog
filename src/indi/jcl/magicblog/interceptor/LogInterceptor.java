package indi.jcl.magicblog.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Administrator on 2016/11/21.
 */
public class LogInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result =  methodInvocation.proceed();
        long end = System.currentTimeMillis();
        logger.info("耗时："+(end-begin)+"ms");
        return result;
    }
}
