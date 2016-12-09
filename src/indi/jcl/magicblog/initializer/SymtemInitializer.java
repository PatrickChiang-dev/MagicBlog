package indi.jcl.magicblog.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 系统初始化器
 * Created by Magic Long on 2016/12/2.
 */
@Component
public class SymtemInitializer implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SymtemInitializer.class);


    @Override
    public void afterPropertiesSet() throws Exception {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("------------------------------------------------SymtemInitializer start------------------------------------------------").append("\r\n");

        logInfo.append("------------------------------------------------SymtemInitializer end--------------------------------------------------").append("\r\n");
        logger.info(logInfo.toString());
    }


}
