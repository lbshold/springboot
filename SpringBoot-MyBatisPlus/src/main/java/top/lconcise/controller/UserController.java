package top.lconcise.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lconcise.business.common.Result;
import top.lconcise.business.domain.User;
import top.lconcise.business.search.UserSearchDto;
import top.lconcise.service.UserService;

/**
 * 基于User,基础的增删改查,RESTful API
 */
@Api(tags = "用户controller")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询", notes = "note")
    @PostMapping("/page/{current}/{size}")
    public Result<IPage<User>> page(@PathVariable @ApiParam(value = "当前页", required = true) Long current,
                                    @PathVariable @ApiParam(value = "每页条数", required = true) Long size,
                                    @RequestBody UserSearchDto userSearchDto) {
        return Result.ok(userService.selectPageVo(new Page(current, size), userSearchDto));
    }

    @ApiOperation(value = "创建")
    @PostMapping
    public Result create(@RequestBody User user) {
        userService.save(user);
        return Result.ok();
    }

    @ApiOperation(value = "编辑")
    @PutMapping
    public Result put(@RequestBody User user) {
        userService.updateById(user);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id获取详情")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        return Result.ok(userService.getById(id));
    }
}
