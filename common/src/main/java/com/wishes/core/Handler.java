package com.wishes.core;
/**
 * 责任链节点
 * @author lvzisun
 *
 */
public interface Handler {

	Handler setNext(Handler next);
	
	void handle(Handlable handlable);
	
	Result getResult();
}
