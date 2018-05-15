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
				insertData("alipay");//tbname，为要插入的数据表名
	}
	
	public static void insertData(String tbName){
		try {
						
			//casilin:插入数据，先从excel中读取数据
			InputStream is = new FileInputStream("D://alipay.xlsx");
			ExcelReader excelReader = new ExcelReader();
			String[] colName = excelReader.readExcelTitle(is);
		    
		    //开始建立插入的sql语句,每一次插入的开头都是不变的,都是字段名
		    StringBuffer sqlBegin = new StringBuffer("insert into " + tbName + "(");
		    //获取字段名，并添加入sql语句中
		    for (int i = 0; i < colName.length; i ++){
		    	sqlBegin.append(colName[i]);
		    	if (i != colName.length -1) {
		    		sqlBegin.append(",");
		    	}
		    }
		    sqlBegin.append(") values(");
		    is.close();
		    
		    //下面读取字段内容
		    POIFSFileSystem fs;
		    HSSFWorkbook wb;
		    HSSFSheet sheet;
		    HSSFRow row;
		      
		    is = new FileInputStream("D://casilin//testFiles//test.xls");
	        fs = new POIFSFileSystem(is);    
	        wb = new HSSFWorkbook(fs);  
	        sheet = wb.getSheetAt(0);
	            
	        //得到总行数    
	        int rowNum = sheet.getLastRowNum();    
	        row = sheet.getRow(0);    
	        int colNum = row.getPhysicalNumberOfCells();    
	        //正文内容应该从第二行开始,第一行为表头的标题    
	        String sql = new String(sqlBegin);
	        String temp;
	        for (int i = 1; i <= rowNum; i++) {    
	            row = sheet.getRow(i);    
	            int j = 0;    
	            while (j<colNum) {       
	            	temp = excelReader.getStringCellValue(row.getCell((short) j)).trim();
	            	
	            	//日期的特殊处理
	            	if (colName[j].indexOf("date") != -1){
	            		temp = temp.substring(0, temp.length()-2);
	            		//excel是以1990年为基数的，而java中的date是以1970年为基数的。所以要扣除差 25569天
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

