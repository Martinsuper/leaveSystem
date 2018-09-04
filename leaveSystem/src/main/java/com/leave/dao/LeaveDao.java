package com.leave.dao;

import com.leave.po.Leave;

import java.io.IOException;
import java.util.List;

public interface LeaveDao {

    public void addLeave(Leave leave) throws IOException;
    public List<Leave> queryAll() throws IOException;
    public void leaveOutPut(List<Leave> leaveList, String outPutFileName) throws IOException;
    public void deleteLeave() throws IOException;
}
