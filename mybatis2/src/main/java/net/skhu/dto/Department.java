package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String departmentName;
    Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}