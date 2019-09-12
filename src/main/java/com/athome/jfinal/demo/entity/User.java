package com.athome.jfinal.demo.entity;

import com.jfinal.plugin.activerecord.Model;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 萧一旬
 * @date Create in 19:37 2019/8/29
 */

@ToString
public class User extends Model<User> {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
