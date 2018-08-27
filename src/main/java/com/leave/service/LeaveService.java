package com.leave.service;

import com.leave.po.Leave;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
public interface LeaveService {
    void addLeave(Leave leave);
}
