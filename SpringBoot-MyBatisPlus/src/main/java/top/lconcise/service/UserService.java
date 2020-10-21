package top.lconcise.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.business.domain.User;
import top.lconcise.business.search.UserSearchDto;

public interface UserService extends IService<User> {

    IPage<User> selectPageVo(Page page,UserSearchDto userSearchDto);
}
