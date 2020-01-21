package top.lconcise.ribbon.server.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.lconcise.ribbon.server.domain.User;
import top.lconcise.ribbon.server.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liusj on 2020/1/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        return initUser();
    }

    @Override
    public User getUserById(long id) {
        List<User> users = getUsers().stream().filter(user -> id == user.getId()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(users)) {
            return new User(0L, "", "空");
        }
        return users.get(0);
    }

    private List<User> initUser() {
        List<User> userList = new ArrayList<>();

        User user1 = new User(1L, "刘备", "刘备");
        User user2 = new User(2L, "关羽", "关羽");
        User user3 = new User(3L, "张飞", "张飞");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
