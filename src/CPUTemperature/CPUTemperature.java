package CPUTemperature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CPUTemperature {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec("ping www.saiita.cn");
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}else{
				System.out.println(1);
			}
		}
	}
}
