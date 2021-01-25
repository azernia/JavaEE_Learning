package com.rui.test;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.rui.pojo.Num;
import com.rui.util.DBUtil;

public class InsertIntoDataBase {
	public static void main(String[] args) {
		// 将xml中的信息还原到数据库中
		// 解析xml, 生成list集合
		List<Num> list = parseXml();
		// list中的数据写入数据库
		saveNumFromList(list);
	}

	/**
	 * 将list中的数据写入数据库
	 * 
	 * @param list
	 */
	private static void saveNumFromList(List<Num> list) {
		String sql = "insert into t_num values (?, ?, ?)";
		Connection conn = DBUtil.getMySQLConnection();
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			for (Num num : list) {
				DBUtil.bindParameter(pstmt, num.getId(), num.getNum(), num.getType());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
	}

	/**
	 * 解析xml, 生成list集合
	 * 
	 * @return
	 */
	private static List<Num> parseXml() {
		List<Num> list = new ArrayList<>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("src/nums.xml"));
			Element nums = doc.getRootElement();
			Iterator<Element> it = nums.elementIterator();
			while (it.hasNext()) {
				Element e = it.next();
				Num num = new Num();
				num.setId(e.attributeValue("id"));
				num.setType(e.attributeValue("type"));
				num.setNum(Integer.parseInt(e.getText()));
				list.add(num);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return list;
	}
}
