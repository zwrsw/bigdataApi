package cn.ce.common.bean;

public class CustomerMsg {
	//是否成功
	private String result;
	//失败信息
	private String msg;
	//唯一标示
	private String key;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
