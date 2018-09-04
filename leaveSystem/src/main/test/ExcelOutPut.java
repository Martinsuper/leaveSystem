import com.leave.po.Leave;
import com.leave.service.LeaveService;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelOutPut {


    @Autowired
    private LeaveService leaveService;

//    public static void main(String[] args) throws IOException {


    //        SXSSFWorkbook workbook = new SXSSFWorkbook();
//        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("请假信息收集");
//        for(int i=0; i<leaveList.size(); i++){
//            SXSSFRow row = (SXSSFRow) sheet.createRow(i+1);
//            row.createCell(0).setCellValue(leaveList.get(i).getId());
//            row.createCell(1).setCellValue(leaveList.get(i).getLeaveName());
//            row.createCell(2).setCellValue(leaveList.get(i).getLeaveText());
//
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream("leave.xlsx");
//        workbook.write(fileOutputStream);
//        fileOutputStream.close();
//    }

//    @Test
//    public class test1{
//        leaveService.q
//
//    }
//    @Test
//    public class lea
}
