package com.lifeshs.product.api.dao;
//
//import com.lifeshs.product.api.controller.pojo.Doctor;
//import com.lifeshs.product.api.controller.pojo.User;
//import com.lifeshs.product.api.controller.pojo.Doctor;
import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);

    User findByLoginname(String name);


    String findDoctor(String username);

    List<Date> findAllTime();

    void diaLogBox(Doctor doctor);
}