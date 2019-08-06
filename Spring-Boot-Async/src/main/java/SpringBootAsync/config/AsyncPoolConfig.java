package SpringBootAsync.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by liusj on 2019/8/6
 */
@Configuration
public class AsyncPoolConfig {

    public ThreadPoolTaskScheduler asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(200);
        executor.setQueueCapacity(25);
        executor.setKeepAliveSeconds(200);
        executor.setThreadNamePrefix("asyncThread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

//        executor.setRejectedExecutionHandler(new Threadpoo);
    }
}
