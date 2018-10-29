package Saiita.cn.service.CSV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;

import Saiita.cn.entity.Bugs;

public class BugCsv {
	public static void getBugs() throws IOException {
		Bugs bug=null;
		//生成CsvReader对象，以，为分隔符，GBK编码方式
        CsvReader r;
        String csvFilePath ="D:\\Bugs.csv";
        try {
			r=new CsvReader(csvFilePath,',',Charset.forName("UTF-8"));
			r.readHeaders();
			while(r.readRecord()) {
				System.out.println(r.get("编号"));
				System.out.println(r.get("跟踪"));
				System.out.println(r.get("状态"));
				System.out.println(r.get("优先级"));
				System.out.println(r.get("主题"));
				System.out.println(r.get("作者"));
				System.out.println(r.get("指派给"));
				System.out.println(r.get("%完成"));
				System.out.println(r.get("开始日期"));
				System.out.println(r.get("更新于"));
				System.out.println(r.get("目标版本"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("读取"+csvFilePath+"异常");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		getBugs() ;
	}
}
