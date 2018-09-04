package com.leave.Martind;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel_out {

    public void OutPut(ArrayList<ArrayList<String>> lists, List<String> title, String sheetName, String outPutFileName) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sxssfSheet = (SXSSFSheet) workbook.createSheet(sheetName);
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short)10);
        for(int i =0;i<title.size();i++){
            sxssfSheet.setColumnWidth(i,12*2*256);
        }
        SXSSFRow row_title = (SXSSFRow) sxssfSheet.createRow(0);
        XSSFCellStyle title_style = (XSSFCellStyle) workbook.createCellStyle();
        title_style.setAlignment(CellStyle.ALIGN_CENTER);
        title_style.setFont(font);
        for(int i=0;i<title.size();i++){
            Cell cell = row_title.createCell(i);
            cell.setCellValue(title.get(i));
            cell.setCellStyle(title_style);
        }
        XSSFCellStyle row_style = (XSSFCellStyle) workbook.createCellStyle();
        row_style.setAlignment(CellStyle.ALIGN_CENTER);
        row_style.setFont(font);
        for(int i=0;i<lists.size();i++){
            SXSSFRow row = (SXSSFRow) sxssfSheet.createRow(i+1);
            for(int j=0;j<title.size();j++){
                Cell cell = row.createCell(j);
                if(j==0){
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(Integer.valueOf(lists.get(i).get(j)));
                }else{
                    cell.setCellValue(lists.get(i).get(j));
                }
                cell.setCellStyle(row_style);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(outPutFileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

}