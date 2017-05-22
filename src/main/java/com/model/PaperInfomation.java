package com.model;

import java.io.Serializable;
import java.util.Date;

public class PaperInfomation extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	private String paperId;
	private String paperName;
	private String publishedVector;
	private Date publishedDate;
	private String paperAuthor;
	private String declareId;
	private String baseId;
	
	
	public String getBaseId() {
		return baseId;
	}
	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPublishedVector() {
		return publishedVector;
	}
	public void setPublishedVector(String publishedVector) {
		this.publishedVector = publishedVector;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getPaperAuthor() {
		return paperAuthor;
	}
	public void setPaperAuthor(String paperAuthor) {
		this.paperAuthor = paperAuthor;
	}
	public String getDeclareId() {
		return declareId;
	}
	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}
	
	

}
