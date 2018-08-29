package com.leave.dao.impl;

import com.leave.dao.LeaveDao;
import com.leave.dao.leaveMapper;
import com.leave.po.Leave;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
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
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("请假信息收集");
        sheet.setColumnWidth(2,50*256);
        SXSSFRow row_title = (SXSSFRow) sheet.createRow(0);
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(169, 208, 142)));
        style.setAlignment(CellStyle.ALIGN_CENTER);
        String[] title_message = {"消息ID","请假人姓名","请假原因"};
        for(int i=0;i<3;i++){
            Cell cell = row_title.createCell(i);
            cell.setCellValue(title_message[i]);
            cell.setCellStyle(style);
        }

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
