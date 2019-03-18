package com.lifeshs.product.api.controller.doctor;

import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;
import com.lifeshs.product.api.entity.Result;
import com.lifeshs.product.api.entity.StatusCode;
import com.lifeshs.product.api.service.doctor.DoctorService;
import com.lifeshs.product.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");

        Doctor loginUser = doctorService.login(username,password);

        if (loginUser == null){

            return new Result(false, StatusCode.USER_PASS_ERROR,"用户名或密码输入有误");
        }else {
            //1.生成token，且返回给前端
            String token = jwtUtil.createJWT(loginUser.getId(), loginUser.getMobile(), "doctor");
            Map result = new HashMap();
            result.put("name",loginUser.getUserName());
            result.put("token",token);

            return new Result(true,StatusCode.OK,"用户登录成功",result);


        }



    }

    @RequestMapping(value ="/setNotice",method = RequestMethod.POST)
    public Result setNotice(@RequestBody Map map){
        String id = (String)map.get("reminderDetailId");
       String status = (String)map.get("status");
       String token = (String) map.get("token");

        try {
            doctorService.setNotice(id,status);
            return new Result(true,StatusCode.OK,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"操作失败");
        }


    }

    @RequestMapping(value = "findAllNotice",method = RequestMethod.GET)
    public Result findAllNotice(){
        doctorService.findAllNotice();
        return null;


    }
}
