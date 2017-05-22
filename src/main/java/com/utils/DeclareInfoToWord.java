package com.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DeclareInfoToWord {
	private static Configuration configuration = null;

    static{
        configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setClassForTemplateLoading(DeclareInfoToWord.class, "/templates");
    }


    public static  File createDoc(Map dataMap,String templateName,String filePath,String fileName){
    	File outFile = null;
    	try {
			Template template = configuration.getTemplate(templateName);
			//输出文件
			outFile = new File(filePath + File.separator + fileName);
			//如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8"));
			//生成文件
			template.process(dataMap, out);
			//关闭流
			out.flush();
			out.close();
		} catch (Exception e) {
			
		}
		return outFile;
    }
}
