package com.leave.controller;

import com.leave.po.Leave;
import com.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName LeaveController
 * @Description
 * @Author martind
 * @Date 2018/8/25 16:05
 **/
@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "leave")
    public String addLeave(Leave leave){
        System.out.println(leave.getLeaveName());
        leaveService.addLeave(leave);
        return "success";
    }
}
