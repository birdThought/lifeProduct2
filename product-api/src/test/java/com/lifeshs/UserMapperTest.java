package com.lifeshs;

import com.alibaba.fastjson.JSONObject;
import com.lifeshs.product.api.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserDao userMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Test
    public void  delTest(){
        userMapper. deleteByPrimaryKey(1);
    }
    @Test
    public void json(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("搜索","多少");
        System.out.println(jsonObject);

    }
    @Test
    public void  encoder(){
        boolean matches = encoder.matches("123456", "$2a$10$n5fHmWUbeUHBwc.6mzfVFuPHRYq67v8sPaDreJB6On/K9Oe7f56rS");

        String encode = encoder.encode("123456");
        System.out.println(encode+"           2321321");
        System.out.println(matches);

    }
}
