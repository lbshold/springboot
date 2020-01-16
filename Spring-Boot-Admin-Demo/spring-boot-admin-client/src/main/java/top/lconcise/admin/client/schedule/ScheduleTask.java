package top.lconcise.admin.client.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by liusj on 2020/1/16
 */
@Configuration
@EnableScheduling
public class ScheduleTask {

    private static final  Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);

    @Scheduled(initialDelay = 2000,fixedDelay = 3000)
    public void task(){
        LOGGER.error("========ERROR==========");
        LOGGER.warn("========WARN==========");
        LOGGER.info("========INFO==========");
        LOGGER.debug("========DEBUG==========");
    }
}
