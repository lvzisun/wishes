package com.wishes.exception.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wishes.core.AbstractHandler;
import com.wishes.core.Handlable;
import com.wishes.core.Result;
import com.wishes.exception.CommonException;
import com.wishes.util.JsonUtil;

public class CommonExceptionHandler extends AbstractHandler{

	private static final Log log=LogFactory.getLog(CommonExceptionHandler.class);
	
	protected Result result;
	
	public CommonExceptionHandler() {
		super(CommonException.Sign.getSign());
	}

	@Override
	public Result getResult() {
		return result;
	}

	@Override
	public void doHandle(Handlable handlable) {
		CommonException ex=(CommonException)handlable;
		log.info(ex);
		Map<String, String> map=new LinkedHashMap<String, String>();
		map.put("code", ex.getCode());
		map.put("message", ex.getMessage());
		final String json=JsonUtil.toJson(map);
		this.result= new Result(){
			@Override
			public String getJson() {
				return json;
			}
		};
	}
	
	
}
