package cn.ce.common.utils;

import java.util.Date;
import java.util.UUID;

public class KeyGernerUtil {
	/**
	 * 产生唯一key
	 * @param ip
	 * @return
	 */
	public static String getVeiwKey(String ip){
		String tkey="";
		try {
			tkey = DateUtils.getTimeKeyStr(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ukey=UUID.randomUUID().toString();
		
		
		return tkey+"_"+ip+"_"+ukey;
	}
}
