package top.lconcise.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lconcise.business.domain.User;
import top.lconcise.business.search.UserSearchDto;
import top.lconcise.mapper.UserMapper;
import top.lconcise.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPageVo(Page page,UserSearchDto userSearchDto) {
        return userMapper.selectPageVo(page, userSearchDto.getName());
    }
}
