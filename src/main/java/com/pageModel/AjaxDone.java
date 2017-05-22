package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author cfl
 *
 */
@XmlRootElement(name = "declare")
public class AjaxDone implements java.io.Serializable{
//	"id":"1000",
//	"fileName":"测试文件.txt",
//	"attachmentPath":"/upload/测试文件.txt",
//	"attachmentSize":"1024"
	
	private String id;
	private String fileName;
	private String attachmentPath;
	private String attachmentSize;
	
	private String statusCode;
	private String message;
	private String confirmMsg="";
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	
	public static AjaxDone build(String navTabId,String statusCode, String message, String rel, String callbackType,String forwardUrl) {
		AjaxDone ajax = new AjaxDone();
		ajax.setStatusCode(statusCode);
		ajax.setMessage(message);
		ajax.setNavTabId(navTabId);
		ajax.setRel(rel);
		ajax.setCallbackType(callbackType);
		ajax.setForwardUrl(forwardUrl);
		return ajax;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getConfirmMsg() {
		return confirmMsg;
	}
	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getAttachmentSize() {
		return attachmentSize;
	}
	public void setAttachmentSize(String attachmentSize) {
		this.attachmentSize = attachmentSize;
	}
	
	
}
