package cdc.jjs.control.rabise.vo;

import java.util.Date;


public class RabiseResultVO {
	
	private String specimeNumber;
	private String result;
	private Date time;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecimeNumber() {
		return specimeNumber;
	}
	public void setSpecimeNumber(String specimeNumber) {
		this.specimeNumber = specimeNumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
