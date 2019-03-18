package com.lifeshs.product.api.controller.user;

import com.github.pagehelper.PageInfo;
//import com.lifeshs.product.api.controller.pojo.Doctor;
//import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;
import com.lifeshs.product.api.entity.Result;
import com.lifeshs.product.api.entity.StatusCode;
import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.service.UserService;
import com.lifeshs.product.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.lifeshs.product.api.controller.util.JwtUtil;
//import com.lifeshs.product.api.service.MAppNormalService;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");

        User loginUser = userService.login(username,password);

        if (loginUser == null){

                return new Result(false,StatusCode.USER_PASS_ERROR,"用户名或密码输入有误");
            }else {
                //1.生成token，且返回给前端
                String token = jwtUtil.createJWT(loginUser.getId(), loginUser.getMobile(), "user");
                Map result = new HashMap();
                result.put("name",loginUser.getusername());
                result.put("token",token);

                return new Result(true,StatusCode.OK,"用户登录成功",result);


            }



    }


    @RequestMapping(value = "/findDoctor")
    public Result findDoctor(@RequestBody Map map){
        String username = (String) map.get("username");
        String token = (String) map.get("token");
        String doctor = userService.findDoctor(username, token);
        if (doctor==null){
            return new Result(false,StatusCode.USER_PASS_ERROR,"数据库异常");

        }else {

            return new Result(true,StatusCode.OK,"成功",doctor);
        }

    }
    @RequestMapping(value = "/findAllTime")
    public Result findAllTime(@RequestParam int pageNum,@RequestParam int pageSize){
        List<Date> allTime = userService.findAllTime(pageNum,pageSize);
        PageInfo<Date> datePageInfo = new PageInfo<>(allTime);
        return new Result(true,StatusCode.OK,"成功",datePageInfo);

    }
    @RequestMapping(value = "/diaLogBox")
    public void diaLogBox(@RequestBody Map content){
        String userCode = (String) content.get("userCode");
        String username = (String) content.get("username");
        String password = (String) content.get("password");
        String content1 = (String) content.get("content");
        Doctor doctor = new Doctor();
        doctor.setContent(content1);

        doctor.setPassword(encoder.encode(password));
        doctor.setUserCode(userCode);
        doctor.setUserName(username);

            userService.diaLogBox(doctor);

    }


        }





