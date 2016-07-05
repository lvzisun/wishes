package com.wishes.core;

import com.wishes.core.Handlable.Sign;
import com.wishes.exception.CommonException;

/**
 * 抽象实现
 * @author lvzisun
 *
 */
public abstract class AbstractHandler implements Handler{
	
	protected Handler next;
	protected Sign sign;

	public AbstractHandler(Sign sign) {
		super();
		if(sign==null){
			throw CommonException.IS_NULL.newInstance("责任链节点的处理标记不能为null");
		}
		this.sign = sign;
	}

	@Override
	public final Handler setNext(Handler next) {
		if(this.next!=null){
			this.next.setNext(next);
		}else{
			this.next=next;
		}
		return this;
	}

	@Override
	public final void handle(Handlable handlable) {
		if(sign.equals(handlable.getSign())){
			this.doHandle(handlable);
		}else if(next!=null){
			next.handle(handlable);
		}else{
			throw CommonException.NOT_HANDLE.newInstance("无法处理该对象["+handlable+"],因为没有相应的处理器");
		}
	}

	public abstract void doHandle(Handlable handlable);
}
