package com.lifeshs.product.api.domain.vo;

import java.util.Date;

public class task_pust {
    private  int id;
    private String receice_id;
    private String content;
    private Date send_time;
    private String cycle;
    private int status;
    private Date creact_time;
    private String illness;

    public String getReceice_id() {
        return receice_id;
    }

    public void setReceice_id(String receice_id) {
        this.receice_id = receice_id;
    }

    public task_pust() {
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public task_pust(int id, String receice_idString, String content, Date send_time, String cycle, int status, Date creact_time) {
        this.id = id;
        this.receice_id = receice_idString;
        this.content = content;
        this.send_time = send_time;
        this.cycle = cycle;
        this.status = status;
        this.creact_time = creact_time;
        this.illness=illness;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceice_idString() {
        return receice_id;
    }

    public void setReceice_idString(String receice_idString) {
        this.receice_id = receice_idString;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreact_time() {
        return creact_time;
    }

    public void setCreact_time(Date creact_time) {
        this.creact_time = creact_time;
    }
}
