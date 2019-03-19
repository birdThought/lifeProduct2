package com.lifeshs.product.api.service.doctor;

import com.github.pagehelper.PageHelper;
import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.dao.doctor.DoctorDao;
import com.lifeshs.product.api.domain.po.Doctor;
//import com.lifeshs.product.api.domain.vo.Notice;
import com.lifeshs.product.api.domain.vo.reminder_detail;
import com.lifeshs.product.api.domain.vo.task_pust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Doctor login(String id, String password) {
        //1.判断账户是否存在
        Doctor loginAdmin = doctorDao.findByLoginname(id);

        //2.判断密码是否一致
        if (loginAdmin != null && encoder.matches(password, loginAdmin.getPassword())) {
            return loginAdmin;
        } else {
            return null;
        }
    }

    public void setNotice(String id, String status) {
//        if (status != null && status.equals("1")) {
//            doctorDao.setStatus1(id);
//
//        }
//        if (status != null && status.equals("0")) {
//            doctorDao.setStatus0(id);
//        }
        int status1 = Integer.parseInt(status);
        doctorDao.setStatus(id,status1);

    }

    public List<task_pust> findAllNotice() {
        PageHelper.startPage(1,10);
        List<task_pust> allNotice = doctorDao.findAllNotice();
        return allNotice;

    }

    public void changPassWord(String id, String oldPsw, String newPsw) {
        Doctor loginAdmin = doctorDao.findByLoginname(id);

        //2.判断密码是否一致
        if (loginAdmin != null && encoder.matches(oldPsw, loginAdmin.getPassword())) {
            String encode = encoder.encode(newPsw);
            doctorDao.changPassWord(id, encode);
        }else {
            throw new  RuntimeException("操作失败");
        }
    }

    public void addNotice(task_pust rd) {
        rd.setCreact_time(new Date());
        doctorDao.addNotice(rd);

    }
}

