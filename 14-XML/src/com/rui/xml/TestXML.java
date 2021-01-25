package com.rui.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 对XML进行操作
 * @author Rui
 * Date 2021年1月25日 下午4:05:57
 */
public class TestXML {
	public static void main(String[] args) throws Exception {
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		//读取XML文件信息
		Document doc = reader.read(new File("src/scores.xml"));
		//获取根元素
		Element root = doc.getRootElement();
		System.out.println("根元素名:" + root.getName());
		//获取根元素下所有子元素，使用迭代器,遇到多个需要获取的元素时使用迭代器
		Iterator<?> it = root.elementIterator();
		while(it.hasNext()) {
			//取出元素
			Element e = (Element)it.next();
			System.out.println(e.getName());
			//获取属性
			Attribute atr = e.attribute("id");
			System.out.println("属性名:" + atr.getName() + ":" + atr.getValue());
			//获取子元素
			Element name = e.element("name");
			Element score = e.element("score");
			Element course = e.element("course");
			System.out.println(name.getName()+ "=" + name.getStringValue());
			System.out.println(course.getName() + "=" + course.getText());
			System.out.println(score.getName() + "=" + score.getText());
			System.out.println("--------------------------------------");
		}
	}
}
