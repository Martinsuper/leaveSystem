package com.leave.dao;

import com.leave.po.Leave;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface LeaveDao {

    void addLeave(Leave leave) throws IOException;
}
