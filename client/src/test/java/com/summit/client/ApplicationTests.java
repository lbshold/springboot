package com.summit.client;

import com.summit.client.business.domain.RainfallStatistics;
import com.summit.client.business.domain.User;
import com.summit.client.business.mapper.RainfallStatisticsMapper;
import com.summit.client.business.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RainfallStatisticsMapper rainfallStatisticsMapper;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
    }

    @Test
    public void test() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users.size());
        List<RainfallStatistics> rainfallStatistics = rainfallStatisticsMapper.selectList(null);
        System.out.println(rainfallStatistics.size());
    }

}
