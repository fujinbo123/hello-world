package com.zhiling.webmagic.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {

	public static void main(String[] args) {
		String content = readFile();
		Document doc = Jsoup.parse(content);
		/*
		 * String title = doc.title(); System.out.println(title); Element a =
		 * doc.getElementById("tblprnt"); Elements th =
		 * a.getElementsByTag("th"); Elements li_content =
		 * a.getElementsByTag("thead");
		 * 
		 * String html = htmltest; Document doc = Jsoup.parse(html);
		 */
		Elements rows = doc.select("table[class=sortableTable]").get(0).select("tr");
		if (rows.size() == 1) {
			System.out.println("没有结果");
		} else {
			System.out.println("--------------------------- 查询结果 ---------------------------");
			Element row = rows.get(1);
			System.out.println("姓名:" + row.select("td").get(0).text());
			System.out.println("身份证号:" + row.select("td").get(1).text());
			System.out.println("-------------------------------------------------------------");
		}

	}

	public static String readFile() {
		StringBuffer sb = new StringBuffer();
		String pathname = "E://test.txt";
		try (FileReader reader = new FileReader(pathname); BufferedReader br = new BufferedReader(reader)) {
			String line;
			// 网友推荐更加简洁的写法
			while ((line = br.readLine()) != null) {
				// 一次读入一行数据
				// System.out.println(line);
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
