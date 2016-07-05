package com.wishes.exception;

import com.wishes.core.Handlable;
/**
 * 异常的基类
 * @author lvzisun
 *
 */
public class CommonException extends RuntimeException implements Handlable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7424336209061582833L;
	private static final String PREFIX="0000";
	
	public static final CommonException IS_NULL=new CommonException(PREFIX+"0000","空值异常");
	public static final CommonException NOT_HANDLE=new CommonException(PREFIX+"0001","责任链无法处理异常");
	
	private String code;
	
	public CommonException(String code) {
		super();
		this.code=code;
	}
	public CommonException(String code,String message) {
		super(message);
		this.code=code;
	}
	public CommonException(String code,Throwable cause) {
		super(cause);
		this.code=code;
	}
	public CommonException(String code,String message, Throwable cause) {
		super(message, cause);
		this.code=code;
	}
	
	public CommonException newInstance(String message){
		return new CommonException(this.code,message);
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public Sign getSign() {
		return Sign.getSign();
	}
	/**
	 * 单例
	 * @author lvzisun
	 *
	 */
	public static class Sign implements Handlable.Sign{
		
		private static final Sign sign=new Sign();
		
		private Sign(){
			
		}

		public static Sign getSign() {
			return sign;
		}
		
	}
}
