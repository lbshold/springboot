package top.lconcise.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.lconcise.domain.User;
import top.lconcise.mapper.UserMapper;

/**
 * Created by liusj on 2019/7/25
 */
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @CachePut(key = "#p0.id")
    @Override
    public void update(User user) {
        userMapper.update(user, null);
    }

    @CacheEvict(key = "#p0", allEntries = true)
    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Cacheable(key = "#p0")
    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }
}
