package top.lconcise.design_demo.performance_counter;

import top.lconcise.design_demo.performance_counter.controller.MetricsCollector;
import top.lconcise.design_demo.performance_counter.domain.vo.RequestInfo;
import top.lconcise.design_demo.performance_counter.report.ConsoleReporter;
import top.lconcise.design_demo.performance_counter.report.EmailReporter;
import top.lconcise.design_demo.performance_counter.storage.MetricsStorage;
import top.lconcise.design_demo.performance_counter.storage.RedisMetricsStorage;

/**
 * @author: liusj
 * @date: 2022/3/8
 */
public class Demo {

    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("wangzheng@xzg.com");
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
