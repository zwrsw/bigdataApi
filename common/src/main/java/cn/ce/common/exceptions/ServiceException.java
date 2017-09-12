package cn.ce.common.exceptions;

public class ServiceException  extends RuntimeException{
 /**
	 * 
	 */
	private static final long serialVersionUID = -3772954747953885372L;
public ServiceException(String message){
	 
	 super(message);
 }
	
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
		
}
