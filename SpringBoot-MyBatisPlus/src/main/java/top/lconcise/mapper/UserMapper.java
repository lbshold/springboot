package top.lconcise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.lconcise.domain.User;

/**
 * Created by liusj on 2019/10/9
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageVo(Page page, @Param("name") String name);
}
