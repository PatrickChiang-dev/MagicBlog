package indi.jcl.magicblog.interceptor;

import indi.jcl.magicblog.util.JsonUtil;
import indi.jcl.magicblog.util.date.DateStyle;
import indi.jcl.magicblog.util.date.DateUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志拦截器
 * Created by jcl on 2016/12/01.
 */
public class LogInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    private long threshold = 3000;//告警日志阈值

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = methodInvocation.proceed();//执行
        long end = System.currentTimeMillis();
        Method method = methodInvocation.getMethod();
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("------------------------------------------------LogInterceptor start------------------------------------------------").append("\r\n");
        logInfo.append("time:" + DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_SSS)).append("\r\n");//请求时间
        logInfo.append("method:" + className + "." + methodName).append("\r\n");//包.类名.方法名
        logInfo.append("params:"+JsonUtil.getJsonString(methodInvocation.getArguments())).append("\r\n");//入参
        logInfo.append("result:" + result).append("\r\n");//返回结果
        long cost = end - begin;
        logInfo.append("cost:" + cost + "ms").append("\r\n");//耗时
        logInfo.append("-------------------------------------------------LogInterceptor end-------------------------------------------------").append("\r\n");
        if (cost > threshold) {
            logger.warn(logInfo.toString());
        } else {
            logger.info(logInfo.toString());
        }
        return result;
    }
}
