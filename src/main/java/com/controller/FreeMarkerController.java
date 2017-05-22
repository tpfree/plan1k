package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.DeclareBase;
import com.utils.DeclareInfoToWord;

/**
 * 
 * 
 * @author cfl
 * 
 */
@Controller
@RequestMapping(value="freeMarkController")
public class FreeMarkerController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(FreeMarkerController.class);

	@RequestMapping(params="downResumeDoc")
    public ModelAndView downResumeDoc(HttpServletRequest request,HttpServletResponse response,String declareId) 
            throws IOException{
        request.setCharacterEncoding("utf-8");
        Map<String,Object> map = new HashMap<String,Object>();
      
        //给map填充数据
        map.put("ids","ARX1-23232");
        map.put("name","王奕");
        map.put("type", "拔尖人才");
        map.put("fields","科技创新");
        map.put("xingshi","直接引进");
        map.put("phone","13021364589");
        map.put("email","123@qq.com");
        map.put("unit","交通教育厅");
        map.put("telName","海丽");
        map.put("telPhone","13025864978");
  
        
        map.put("year","2017");
        map.put("month","05");
        map.put("date","16");

        //提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        //否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错，这里暂时忽略这个步骤
        File file = null;
        InputStream fis = null;
        OutputStream out = null;

        try{
        	String tempPath = request.getSession().getServletContext()
    				.getRealPath("/upload");
        	String filename = "temp" + (int) (Math.random() * 100000) + ".doc"; 
            file = DeclareInfoToWord.createDoc(map, "baseInfo.ftl",tempPath,filename);
            
            
            fis = new BufferedInputStream(new FileInputStream(file));
            response.reset();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/x-msdownload;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=baseInfo.doc");
 
            byte[] buffer = new byte[fis.available()];//缓冲区
            fis.read(buffer);
            fis.close();
            
            out = new BufferedOutputStream(response.getOutputStream()); 
            out.write(buffer);
            out.flush();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(fis != null){
            	fis.close();  
            }
            if(out != null) {
            	out.flush();
            	out.close();  
            }
            if(file != null) {
            	file.delete(); // 删除临时文件  
            }
        }
        return null;
    }
}
