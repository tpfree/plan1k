package com.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageUtil {
	
	public static BufferedImage generationImage(HttpServletRequest request,String sessionName,Integer numLen) {
		Font mFont = new Font("Arial Black", Font.PLAIN, 16);
		// 组织生成页面内容被缓存，保证每次重新生成随机验证码

//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
		// 指定 图形验证码大小
		int width = 100, height = 20;
		// 生成一张新图片
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 在图片中绘制内容
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(1, 1, width - 1, height - 1);
		g.setColor(new Color(102, 102, 102));
		g.setFont(mFont);
		// 随即生成线条，让图片看起来更加杂乱
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x1 = random.nextInt(width - 1);
			int y1 = random.nextInt(height - 1);
			int x2 = random.nextInt(6) + 1;
			int y2 = random.nextInt(12) + 1;
			g.drawLine(x1, y1, x2, y2);
		}
		// 随机生成线条，让图片看起来更杂乱
		for (int i = 0; i < 70; i++) {
			int x1 = random.nextInt(width - 1);
			int y1 = random.nextInt(height - 1);
			int x2 = random.nextInt(6) + 1;
			int y2 = random.nextInt(12) + 1;
			g.drawLine(x1, y1, x2, y2);
		}
		// 读取变量，用于保存系统生成的随机字符串
		String sRand = "";
		for (int i = 0; i < numLen; i++) {
			// 取得一个随机生成的字符
			String tmp = getRandomChar();
			sRand += tmp;
			// 将系统随机生成的字符添加到图形验证码图片上
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(tmp, 15 * i + 10, 15);
		}
		// 将系统随机生成的图形验证码添加到用户Session中
		request.getSession(true).setAttribute(sessionName, sRand);
		g.dispose();
		
		return image;
		// 输出图形验证码图片
		// try {
		// ImageIO.write(image, "JPEG", response.getOutputStream());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
	
	public static String getSRand(int num){
		String sRand = "";
		for (int i = 0; i < num; i++) {
			// 取得一个随机生成的字符
			String tmp = getRandomChar();
			sRand += tmp;
		}
		return sRand;
	}
	
	private static String getRandomChar() {
		int rand = (int) Math.round(Math.random() * 2);
		long itmp = 0;
		rand=0;
		char ctmp = '\0';
		switch (rand) {
		case 1:
			itmp = Math.round(Math.random() * 25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
			// 生成小写字母
		case 2:
			itmp = Math.round(Math.random() * 25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
			// 生成数字
		default:
			itmp = Math.round(Math.random() * 9);
			return String.valueOf(itmp);
		}
	}

	// 生成随即颜色
	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
