package top.lconcise.design_demo.performance_counter.controller;

import top.lconcise.design_demo.performance_counter.domain.Metrics;
import top.lconcise.design_demo.performance_counter.vo.UserVo;

/**
 * @author: liusj
 * @date: 2022/3/7
 */
public class UserController {

    private Metrics metrics = new Metrics();

    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        System.out.println("register。。。");
        // ..
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register",respTime);
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        System.out.println("login...");
        // ..
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordTimestamp("login",respTime);
        return null;
    }
}
