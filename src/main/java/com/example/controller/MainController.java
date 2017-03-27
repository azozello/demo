package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index(){
        return "index.html";
    }

    @RequestMapping(value = "/img")
    public void getImage(HttpServletResponse response){
        File f = new File("src/main/resources/images.jpeg");
        try (InputStream is = new FileInputStream(f);
             OutputStream os = response.getOutputStream()){
            response.setContentType("image/jpeg");

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = is.read(bytes)) != -1) {
                os.write(bytes,0,read);
            }
            response.flushBuffer();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
