package top.lconcise.ribbon.server.service;

import top.lconcise.ribbon.server.domain.User;

import java.util.List;

/**
 * Created by liusj on 2020/1/20
 */
public interface UserService {

    List<User> getUsers();

    User getUserById(long id);

}
