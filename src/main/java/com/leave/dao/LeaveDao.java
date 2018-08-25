package com.leave.dao;

import com.leave.po.Leave;
import org.springframework.stereotype.Service;

public interface LeaveDao {

    void addLeave(Leave leave);
}
