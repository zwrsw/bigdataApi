package cn.ce.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {
	private static Properties p = new Properties();
	
	static{
		load();
	}
	public static void load(){
		InputStream inputStream = LoadProperty.class.getClassLoader()
				.getResourceAsStream("config/con.properties");
		try {
			p.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String name){
		if(p!=null && p.containsKey(name)){
			return p.getProperty(name);
		}else{
			load();
			if(p!=null && p.containsKey(name)){
				return p.getProperty(name);
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(get("mail.163.com.host"));
	}
}
