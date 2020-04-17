package com.summit.operationbackupsql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liusj on 2020/4/16
 */
@EnableScheduling
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static final String formatSql = "mysqldump -h%s -p%s -u%s -p%s %s > %s";

    /**
     * 定时备份sql.
     */
//    @Scheduled(initialDelay = 2000, fixedDelay = 5000)
    @Scheduled(cron = "0 0 9 * * ?") // 每天早晨10点
    public void scheduleBackupSql() {

        String sql = String.format(formatSql, "127.0.0.1", "3306", "root", "Summit2017", "operation", "E:\\operation_backup\\operation_backup_");

        StringBuilder sqlStr = new StringBuilder(sql);
        sqlStr.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).append(".sql");

        logger.info(sqlStr.toString());
        try {
            String os = System.getProperty("os.name"); // 系统名称
            if (os.toLowerCase().startsWith("win")) {
                Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", sqlStr.toString()}); // windows
                process.waitFor();
            } else if (os.toLowerCase().startsWith("linux")) {
                Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", sqlStr.toString()}); // linux
                process.waitFor();
            }

            logger.info("备份数据成功");

        } catch (IOException e) {
            logger.error("备份数据失败", e);
        } catch (InterruptedException e) {
            logger.error("备份数据失败", e);
        }

    }
}
