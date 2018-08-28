package com.leave.dao.impl;

import com.leave.dao.LeaveDao;
import com.leave.dao.leaveMapper;
import com.leave.po.Leave;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName LeaveDaoImpl
 * @Description
 * @Author martind
 * @Date 2018/8/25 16:57
 **/
@Repository
public class LeaveDaoImpl implements LeaveDao {

    @Override
    public void addLeave(Leave leave) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try{
            leaveMapper mapper = openSession.getMapper(leaveMapper.class);
            mapper.addLeave(leave);
//            List<Leave> leave1 = mapper.queryAll();
//            System.out.println(leave1);
        }finally {
            openSession.close();
        }
    }

    @Override
    public List<Leave> queryAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try{
            leaveMapper mapper = openSession.getMapper(leaveMapper.class);
            List<Leave> leave = mapper.queryAll();
//            System.out.println(leave1);
            return leave;
        }finally {
            openSession.close();
        }
    }


    @Override
    public void leaveOutPut(List<Leave> leaveList) throws IOException {
//        System.out.println("这里是dao层");
////        for(int i=0; i<leaveList.size(); i++){
////            System.out.println(leaveList.get(i).getId() + " 请假人：" + leaveList.get(i).getLeaveName() + " 请假原因：" +leaveList.get(i).getLeaveText());
////        }
////
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("请假信息收集");
        for(int i=0; i<leaveList.size(); i++){
            SXSSFRow row = (SXSSFRow) sheet.createRow(i+1);
            row.createCell(0).setCellValue(leaveList.get(i).getId());
            row.createCell(1).setCellValue(leaveList.get(i).getLeaveName());
            row.createCell(2).setCellValue(leaveList.get(i).getLeaveText());

        }
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\leave.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();

    }
}
