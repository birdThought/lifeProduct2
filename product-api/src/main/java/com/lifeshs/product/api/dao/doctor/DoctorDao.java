package com.lifeshs.product.api.dao.doctor;

import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;

public interface DoctorDao {

    Doctor findByLoginname(String username);

    void setStatus1(String id);

    void setStatus0(String id);
}
