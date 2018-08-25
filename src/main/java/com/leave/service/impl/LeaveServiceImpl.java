package com.leave.service.impl;

import com.leave.dao.LeaveDao;
import com.leave.po.Leave;
import com.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LeaveServiceImpl
 * @Description
 * @Author martind
 * @Date 2018/8/25 16:55
 **/
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveDao leaveDao;

    @Override
    public void addLeave(Leave leave) {
        leaveDao.addLeave(leave);

    }
}
