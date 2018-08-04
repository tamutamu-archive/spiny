package com.gioov.spiny.common.runner;//package com.gioov.spiny.common.runner;

import com.gioov.spiny.common.property.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author godcheese@outlook.com
 * @date 2018/2/22 16:19
 */
@Component
@Order()
public class ApplicationStartupRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupRunner.class);


//    @Autowired
//    private  ;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private AppProperties appProperties;

    @Override
    public void run(String... strings) throws Exception {
//        System.out.println(String.format("===================%s===================", "程序启动成功！"));

        serverProperties.getServlet().setApplicationDisplayName(appProperties.getName());

    }
}
