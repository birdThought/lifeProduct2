package com.lifeshs.product.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
//import com.lifeshs.product.api.controller.pojo.Doctor;
//import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.dao.UserDao;
import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;


    public User login(String username, String password){
        //1.判断账户是否存在
        User loginAdmin = userDao.findByLoginname(username);

        //2.判断密码是否一致
        if(loginAdmin!=null && encoder.matches(password,loginAdmin.getPassword()) ){
            return loginAdmin;
        }else{
            return null;
        }
    }



    public String  findDoctor(String username,String token){

        String doctor = userDao.findDoctor(username);
        return doctor;

    }

    public List<Date> findAllTime(int pageNum,int pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<Date> allTime = userDao.findAllTime();
        return allTime;


    }

    public void diaLogBox(Doctor doctor) {

        userDao.diaLogBox(doctor);


    }
}
