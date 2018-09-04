package com.leave.dao;

import com.leave.po.Leave;

import java.util.List;

public interface leaveMapper {
    public void addLeave(Leave leave);
    public Leave queryLeaveById(Integer id);
    public List<Leave> queryAll();
    public void deleteLeave();
}
