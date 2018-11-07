package Saiita.cn.service.CSV;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.List;

import Saiita.cn.entity.RedmineBugs;
import Saiita.cn.service.GetInfo.getRedmineBug;

public class BugCsv {
	public static boolean getBugs(List<RedmineBugs> dataList) throws IOException {
		boolean isSucess = false;
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream("D:\\质量报表\\PTQ.csv");
			osw = new OutputStreamWriter(out);
			if (dataList != null && !dataList.isEmpty()) {
				for (RedmineBugs data : dataList) {
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			// TODO: handle exception
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				if(osw!=null) {
					try {
						osw.close();
						osw =null;
					}catch(Exception e3){
						e3.printStackTrace();
					}
				if(out!=null) {
					try {
						out.close();
						out=null;
					} catch (Exception e4) {
						// TODO: handle exception
						e4.printStackTrace();
					}
				}
				}
				
			}
			
		}
		return isSucess;
	}

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println(getBugs(getRedmineBug.getDaysInfo()));
	}
}
