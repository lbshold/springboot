package SpringBootAsync.controller;

import SpringBootAsync.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by liusj on 2019/8/6
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @GetMapping("/async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        testService.asyncMethod();

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{}ms", end - start);
    }

    @GetMapping("/sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");

        testService.syncMethod();

        logger.info("同步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{}ms", end - start);
    }

    @GetMapping("/async2")
    public String testAsync2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        Future<String> stringFuture = testService.asyncMethod2();
        logger.info("异步方法返回值：" + stringFuture.get());

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{}ms", end - start);

        return stringFuture.get();
    }

    @GetMapping("/async3")
    public String testAsync3() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始2");

        Future<String> stringFuture = testService.asyncMethod2();
        logger.info("异步方法返回值：" + stringFuture.get(0, TimeUnit.SECONDS));

        logger.info("异步方法结束2");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{}ms", end - start);

        return stringFuture.get(0, TimeUnit.SECONDS);
    }
}
