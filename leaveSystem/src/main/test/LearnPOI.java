import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LearnPOI {
    public static void main(String[] args) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        int cnt = 0;
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("0");
//        for(int i=0; i<20000;i++){
//            if(i%10000==0 && i!=0){
//               sheet = (SXSSFSheet) workbook.createSheet(String.valueOf(i));
//               cnt = 0;
//            }
//            SXSSFRow row = (SXSSFRow) sheet.createRow(cnt);
//            row.createCell(0).setCellValue(df.format(new Date()));
//            cnt++;
//        }
        FileOutputStream fileOutputStream = new FileOutputStream("Martin.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
