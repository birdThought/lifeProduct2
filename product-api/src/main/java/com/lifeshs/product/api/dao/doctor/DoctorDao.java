package com.lifeshs.product.api.dao.doctor;

import com.lifeshs.product.api.controller.pojo.User;
import com.lifeshs.product.api.domain.po.Doctor;
import com.lifeshs.product.api.domain.vo.reminder_detail;
import com.lifeshs.product.api.domain.vo.task_pust;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorDao {

    Doctor findByLoginname(String id);

    void setStatus1(String id);

    void setStatus0(String id);

    void setStatus(@Param("id") String id, @Param("status") int status);

    List<task_pust> findAllNotice();

    void changPassWord(@Param("id") String id,@Param("newPsw") String newPsw);

    void addNotice(task_pust rd);

}
