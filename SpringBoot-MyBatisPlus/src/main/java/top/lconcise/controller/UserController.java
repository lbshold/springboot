package top.lconcise.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.domain.User;
import top.lconcise.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public void page(){
        IPage<User> userIPage = userMapper.selectPageVo(new Page(1, 5), "J");
        userIPage.getRecords().forEach(System.out::println);
    }
}
