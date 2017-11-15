package com.test.shopping.web_befor.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RandomUtil  {

	/**
	 * 这是一个抽取的类
	 * 抽上去2个方法
	 * @throws IOException 
	 */
	public static boolean equals(HttpServletRequest req,String sessionName) {
		
		//获得指定的session中的验证码和
		String random_code=(String)req.getSession().getAttribute(sessionName);
		//得到后需要删除
		req.getSession().removeAttribute(sessionName);//为了让他返回的时候就还是可以登录
		System.out.println("session+"+random_code);
		String code = req.getParameter("code");//获得请求中的验证码
		if (code ==null) {
			return false;
		}
		return  code.equals(random_code);
	}
	
	
	public static void getRandomCode(HttpServletRequest req, HttpServletResponse resp,String sessionName) throws IOException {
		
		 //获得随机的数	
		String random_code = UUID.randomUUID().toString().substring(0, 5) ;
//		System.out.println(random_code);
		req.getSession().setAttribute(sessionName, random_code);//放到session中
		
		//创建图片对象
		int width = 80;
		int height = 35;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);

		//画板
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		//绘制一个实心的矩形
		g.fillRect(1, 1, width - 2, height - 2);

		//把随机数画进图片中
		g.setColor(Color.green);//设置随机数的颜色
		Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
		g.setFont(font);//设置随机数的字体和大小
		g.drawString(random_code, 10, 28);
		//干扰线
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}
		//关闭
		g.dispose();
		//把图片对象以流的方式保存出去
		ImageIO.write(image, "jpg", resp.getOutputStream());

	}
}
