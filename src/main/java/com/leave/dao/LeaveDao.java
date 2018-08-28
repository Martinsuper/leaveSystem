package com.leave.dao;

import com.leave.po.Leave;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface LeaveDao {

    void addLeave(Leave leave) throws IOException;
    List<Leave> queryAll() throws IOException;
    void leaveOutPut(List<Leave> leaveList) throws IOException;
}
