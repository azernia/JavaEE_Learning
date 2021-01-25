package com.rui.test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.rui.pojo.Num;
import com.rui.util.DBUtil;

/**
 * 将数据备份为XML文件
 * 
 * @author Rui Date 2021年1月25日 下午4:42:19
 */
public class TestNum {
	public static void main(String[] args) {
		// 查询所有数据作为List集合
		List<Num> list = selectAll();
		//将数据输出到XML文件中
		writeNum2XML(list);
	}
	
	/**
	 * 将List的数据写入XML
	 * @param list
	 */
	private static void writeNum2XML(List<Num> list) {
		Document doc = DocumentHelper.createDocument();
		Element nums = doc.addElement("nums");
		// 循环为根元素添加子元素
		for (Num num : list) {
			nums.addElement("num")
				.addAttribute("id", num.getId())
				.addAttribute("type", num.getType())
				.addText(num.getNum() + "");
		}
		// 输出到文件
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter("src/nums.xml"), format);
			writer.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static List<Num> selectAll() {
		String sql = "select * from t_num";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Num> list = new ArrayList<>();
		Num num = null;
		conn = DBUtil.getMySQLConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				num = new Num();
				num.setId(rs.getString("id"));
				num.setNum(rs.getInt("num"));
				num.setType(rs.getString("type"));
				list.add(num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}
}
