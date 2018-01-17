package com.claire.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by hzn on 2018/1/6.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class BabyInfo {
    private int id;
    private String name;
    private Date birthday;
    private String profile;
    private String country;
    private String gender;
    private String partner;
    private String hobby;
}
