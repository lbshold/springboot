package com.summit.client.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Created by liusj on 2019/11/7
 */
@TableName(value = "sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
}
