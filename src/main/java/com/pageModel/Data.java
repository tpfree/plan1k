package com.pageModel;

public class Data<T extends Object> implements java.io.Serializable {
	private T result;
	private Integer errcode = 0;
	private boolean success = false;// 是否成功
	private Integer count = 0;

	public static Data build(Integer errcode, boolean success, Object result) {
		Data d = new Data();
		d.setErrcode(errcode);
		d.setSuccess(success);
		d.setResult(result);
		return d;
	}

	public static Data build(Integer errcode, boolean success, Object result,
			Integer count) {
		Data d = new Data();
		d.setErrcode(errcode);
		d.setSuccess(success);
		d.setResult(result);
		d.setCount(count);
		return d;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
}
