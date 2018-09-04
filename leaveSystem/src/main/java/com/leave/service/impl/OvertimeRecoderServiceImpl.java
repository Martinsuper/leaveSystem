package com.leave.service.impl;

import com.leave.Martind.Excel_out;
import com.leave.Martind.Excel_reader;
import com.leave.service.OvertimeRecoderService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OvertimeRecoderServiceImpl implements OvertimeRecoderService {

    @Override
    public void generate(String overtimepath) throws IOException, ParseException {
        Excel_out excel_out = new Excel_out();
        Excel_reader excel_reader = new Excel_reader();
        ArrayList<ArrayList<String>> arr = excel_reader.reader(overtimepath);


        String curr = "20:00:00";
        Set<String> myset = new HashSet<>();
        for (int i = 2; i < arr.size(); i++) {

            String mydate = arr.get(i).get(3).substring(11);

            DateFormat format1 = new SimpleDateFormat("HH:mm:ss");
            Date formatdate = format1.parse(mydate);
            Date standard = format1.parse(curr);
            if (formatdate.compareTo(standard) > 0) {
                myset.add(arr.get(i).get(3).substring(0, 10));
            }
        }
        ArrayList<ArrayList<String>> lists = new ArrayList<>();

        for (int i = 2; i < arr.size(); i++) {
            String mydate = arr.get(i).get(3).substring(0, 10);
            if (myset.contains(mydate)) {
                lists.add(arr.get(i));
            }
        }

        List<String> mytitle = new ArrayList<>();
        mytitle.add("人员编号");
        mytitle.add("姓名");
        mytitle.add("部门");
        mytitle.add("考勤时间");
        mytitle.add("考勤状态");
        mytitle.add("考勤区域");
        mytitle.add("设备序列号");
        excel_out.OutPut(lists, mytitle, "加班记录", "myovertime.xlsx");
    }
}
