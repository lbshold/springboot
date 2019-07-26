package top.lconcise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import top.lconcise.domain.User;

/**
 * Created by liusj on 2019/7/25
 */

public interface UserService extends IService<User> {


    void update(User user);


    void deleteById(Long id);

    @Cacheable(key = "#p0")
    User selectById(Long id);
}
