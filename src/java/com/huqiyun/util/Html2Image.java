package com.huqiyun.util;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class Html2Image {
	public static void main(String[] args) throws Exception {
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		WebClient wc=new WebClient();
		HtmlPage page = wc.getPage("http://192.168.1.124:8081/MySpring/index.jsp");
		String htmlstr=page.asXml().replaceAll("</?(html).*?>","");
		imageGenerator.loadHtml(htmlstr);
		imageGenerator.getBufferedImage();
		imageGenerator.saveAsImage("d:/hello-world.png");
		imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
		
	}
	
}
