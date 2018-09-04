package com.leave.controller;


import com.leave.service.OvertimeRecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
@Controller
@RequestMapping(value = "overtime")
public class OvertimeRecodersController {

    @Autowired
    private OvertimeRecoderService overtimeRecoderService;


    @RequestMapping(value = "/")
    public String firstPage(){
        return "uploadPage";
    }
    @RequestMapping("/uploadFile")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path= file.getOriginalFilename();
                    String suffix = path.substring(path.lastIndexOf("."));
                    path = "overtime" + suffix;
                    System.out.println(path);
                    //上传
                    file.transferTo(new File(path));
                }

            }
        }
        return "UploadSuccess";
    }

    @RequestMapping("/downOverTime")
    public ResponseEntity<byte[]> downOverTime() throws IOException, ParseException {
//        leaveService.leaveOutPut(leaveService.queryAll(),"LeaveName.xlsx");
        overtimeRecoderService.generate("overtime.xls");
        File file = new File("myovertime.xlsx");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, headers, statusCode);
        return entity;
    }

}
