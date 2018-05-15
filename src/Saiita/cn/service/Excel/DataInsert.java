package Saiita.cn.service.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import Saiita.cn.JDBC.JDBC;

public class DataInsert {

	public static Connection conn;
	static JDBC jdbc = new JDBC();
	public static void main(String[] args) {
		 		conn = jdbc.getConnection();
				insertData("alipay");//tbname��ΪҪ��������ݱ���
	}
	
	public static void insertData(String tbName){
		try {
						
			//casilin:�������ݣ��ȴ�excel�ж�ȡ����
			InputStream is = new FileInputStream("D://alipay.xlsx");
			ExcelReader excelReader = new ExcelReader();
			String[] colName = excelReader.readExcelTitle(is);
		    
		    //��ʼ���������sql���,ÿһ�β���Ŀ�ͷ���ǲ����,�����ֶ���
		    StringBuffer sqlBegin = new StringBuffer("insert into " + tbName + "(");
		    //��ȡ�ֶ������������sql�����
		    for (int i = 0; i < colName.length; i ++){
		    	sqlBegin.append(colName[i]);
		    	if (i != colName.length -1) {
		    		sqlBegin.append(",");
		    	}
		    }
		    sqlBegin.append(") values(");
		    is.close();
		    
		    //�����ȡ�ֶ�����
		    POIFSFileSystem fs;
		    HSSFWorkbook wb;
		    HSSFSheet sheet;
		    HSSFRow row;
		      
		    is = new FileInputStream("D://casilin//testFiles//test.xls");
	        fs = new POIFSFileSystem(is);    
	        wb = new HSSFWorkbook(fs);  
	        sheet = wb.getSheetAt(0);
	            
	        //�õ�������    
	        int rowNum = sheet.getLastRowNum();    
	        row = sheet.getRow(0);    
	        int colNum = row.getPhysicalNumberOfCells();    
	        //��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���    
	        String sql = new String(sqlBegin);
	        String temp;
	        for (int i = 1; i <= rowNum; i++) {    
	            row = sheet.getRow(i);    
	            int j = 0;    
	            while (j<colNum) {       
	            	temp = excelReader.getStringCellValue(row.getCell((short) j)).trim();
	            	
	            	//���ڵ����⴦��
	            	if (colName[j].indexOf("date") != -1){
	            		temp = temp.substring(0, temp.length()-2);
	            		//excel����1990��Ϊ�����ģ���java�е�date����1970��Ϊ�����ġ�����Ҫ�۳��� 25569��
	            		Date d = new Date((Long.valueOf(temp) - 25569) * 24 * 3600 * 1000);
	            		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	            		temp = "'" + formater.format(d) + "'";
	            	}
	            	
	                sql = sql + temp;
	                if (j != colNum-1){
	                	sql = sql + ",";
	                }
	                j ++;    
	            }       
	            sql = sql + ")";
	            System.out.println(sql.toString());
	            PreparedStatement ps = conn.prepareStatement(sql.toString());
	            ps.execute();
	            ps.close();
	            sql = "";
	            sql = sqlBegin.toString();
	        }
			
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {    
            e.printStackTrace();    
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	


}

