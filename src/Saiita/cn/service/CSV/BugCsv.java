package Saiita.cn.service.CSV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;

import Saiita.cn.entity.Bugs;

public class BugCsv {
	public static void getBugs() throws IOException {
		Bugs bug=null;
		//����CsvReader�����ԣ�Ϊ�ָ�����GBK���뷽ʽ
        CsvReader r;
        String csvFilePath ="D:\\Bugs.csv";
        try {
			r=new CsvReader(csvFilePath,',',Charset.forName("UTF-8"));
			r.readHeaders();
			while(r.readRecord()) {
				System.out.println(r.get("���"));
				System.out.println(r.get("����"));
				System.out.println(r.get("״̬"));
				System.out.println(r.get("���ȼ�"));
				System.out.println(r.get("����"));
				System.out.println(r.get("����"));
				System.out.println(r.get("ָ�ɸ�"));
				System.out.println(r.get("%���"));
				System.out.println(r.get("��ʼ����"));
				System.out.println(r.get("������"));
				System.out.println(r.get("Ŀ��汾"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ"+csvFilePath+"�쳣");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		getBugs() ;
	}
}
