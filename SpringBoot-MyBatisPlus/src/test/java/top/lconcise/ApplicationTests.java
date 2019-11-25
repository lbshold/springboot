package top.lconcise;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lconcise.domain.User;
import top.lconcise.mapper.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);

        IPage<User> userIPage = userMapper.selectPageVo(new Page(1, 5), "J");
        userIPage.getRecords().forEach(System.out::println);
    }
}
