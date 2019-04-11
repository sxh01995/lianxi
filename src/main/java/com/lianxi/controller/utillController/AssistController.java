package com.lianxi.controller.utillController;

import com.lianxi.utill.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/assist")
public class AssistController {
    @RequestMapping("/show")
    public void show(String imgName, HttpServletResponse response) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(Constant.PATH + imgName));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] a=new byte[1024];
        Integer s=0;
        while ((s=inputStream.read(a))!=-1){
            outputStream.write(a,0,s);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
