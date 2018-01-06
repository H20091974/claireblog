package com.claire.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hzn on 2018/1/6.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Admin {
    private int id;
    private String username;//用户名
    private String password;//md5加密后的密码
    private String email;//邮箱,默认为#
    private String resume;//简历的html文本
    private String Avatar;//头像地址
}
