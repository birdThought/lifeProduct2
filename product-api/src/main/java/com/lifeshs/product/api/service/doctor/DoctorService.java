package com.lifeshs.product.api.service.doctor;

import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.dao.doctor.DoctorDao;
import com.lifeshs.product.api.domain.po.Doctor;
import com.lifeshs.product.api.domain.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Doctor login(String username, String password) {
        //1.判断账户是否存在
        Doctor loginAdmin = doctorDao.findByLoginname(username);

        //2.判断密码是否一致
        if (loginAdmin != null && encoder.matches(password, loginAdmin.getPassword())) {
            return loginAdmin;
        } else {
            return null;
        }
    }

    public void setNotice(String id, String status) {
        if (status != null && status.equals("1")) {
            doctorDao.setStatus1(id);

        }
        if (status != null && status.equals("0")) {
            doctorDao.setStatus0(id);
        }

    }

    public List<Notice> findAllNotice() {
        return null;

    }
}
