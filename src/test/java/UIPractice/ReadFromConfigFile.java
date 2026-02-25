package UIPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromConfigFile {
	
	public static void main(String [] args) {
		
		Properties prop = new Properties();
		File file = new File("C:\\Users\\prash\\eclipse-workspace\\InterviewPrepration\\configurations\\config.properties");
		try {
			FileInputStream fp = new FileInputStream(file);
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.get("name"));
		System.out.println(prop.get("country"));
	}

}
