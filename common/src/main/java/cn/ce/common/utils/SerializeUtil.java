package cn.ce.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class SerializeUtil {
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
		//序列化
		baos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		byte[] bytes = baos.toByteArray();
		return bytes;
		} catch (Exception e) {
		 e.printStackTrace();
		}
		return null;
	}
	 
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
		//反序列化
		bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
		
		
		} catch (Exception e) {
		 e.printStackTrace();
		}
		return null;
		}
	
	
	 public static Map<String, Object> testBytes2Map(byte[] bytes) {
		 
		         Map<String, Object> result = null;
		
		         try {
		 
		             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		 
		             ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
		 
		  
		 
		             result = (Map<String, Object>) inputStream.readObject();
		
		             inputStream.close();
		
		         } catch (ClassNotFoundException e) {
		 
		             e.printStackTrace();
		
		         } catch (IOException e) {
		 
		             e.printStackTrace();
		 
		         }
		
		  
		 
		         return result;
		
		     }

	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.0.55");
		Map<String, String > map=new HashMap<String, String>();
		map.put("1", "11");
		jedis.set("aa".getBytes(), SerializeUtil.serialize(map));
		Map<String, Object>map1=testBytes2Map(jedis.get("aa".getBytes()));
		for (String s : map1.keySet()) {
			System.out.println(map1.get(s));
		}
		
	}
	}
