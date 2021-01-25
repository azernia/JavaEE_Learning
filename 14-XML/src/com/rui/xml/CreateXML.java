package com.rui.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXML {
	public static void main(String[] args) throws IOException {
		//通过DocumentHelper生成文档对象
		Document doc = DocumentHelper.createDocument();
		//添加并得到根元素
		Element root = doc.addElement("books");
		//根元素添加子元素
		Element book = root.addElement("book");
		//为book元素添加属性
		book.addAttribute("bid", "01");
		//为book添加子元素
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		Element price = book.addElement("price");
		//为子元素添加文本
		name.addText("Java");
		author.addText("a");
		price.addText("100");
		//讲doc输出到xml中
		Writer write = new FileWriter(new File("src/book2.xml"));
		doc.write(write);
		write.close();
		//格式良好的输出
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter w = new XMLWriter(new FileWriter(new File("src/book3.xml")), format);
		w.write(doc);
		w.close();
	}
}
