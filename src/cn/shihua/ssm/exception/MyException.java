package cn.shihua.ssm.exception;

/**
 * 自定义异常类
 * @author chenweizhi
 *
 * 2018年6月13日
 */
public class MyException extends Exception {
	
	//自定义异常信息
	private String message;
	
	public MyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
