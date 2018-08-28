package com.leave.service;

import com.leave.po.Leave;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Service
public interface LeaveService {
    public void addLeave(Leave leave) throws IOException;
    public List<Leave> queryAll() throws IOException;
    public void leaveOutPut(List<Leave> leaveList) throws IOException;
}
