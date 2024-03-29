package com.edoc.lucene.index;

import java.io.FileReader;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class EdocDocument implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public static final String FIELD_CONTENT = "contents";
	public static final String FIELD_FILENAME = "fileName";
	public static final String FIELD_CREATETIME = "createTime";
	public static final String FIELD_SOURCEFILEID = "sourceFileId";
	public static final String FIELD_VERSIONNUM = "versionNum";
	public static final String FIELD_CREATORNAME = "creatorName";
	public static final String FIELD_CREATORID = "creatorId";
	public static final String FIELD_FILESIZE = "fileSize";
	public static final String FIELD_SOURCEFILENAME = "sourceFileName";
	public static final String FIELD_SOURCEFILEICON = "icon";
	
	private String fileName = null;
	private FileReader fileReader = null;
	private String contents = null;
	private String createTime = null;
	private String sourceFileId = "";
	private String versionNum = "";
	private String creatorName = "";
	private String creatorId = "";
	private String fileSize = "";
	private String sourceFileName = "";
	private Document doc = null;
	private String icon = "";
	
	public EdocDocument(String sourceFileName ,String fileName, String content, String createTime){
		doc = new Document();
	    doc.add(new Field(FIELD_CONTENT,content,Field.Store.YES, Field.Index.ANALYZED));
	    doc.add(new Field(FIELD_FILENAME,fileName,Field.Store.YES, Field.Index.ANALYZED));
	    doc.add(new Field(FIELD_CREATETIME,createTime,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_SOURCEFILENAME,sourceFileName,Field.Store.YES, Field.Index.ANALYZED));
	    this.sourceFileName = sourceFileName;
	    this.fileName = fileName;
	    this.contents = content;
	    this.createTime = createTime;
	}
	
	public EdocDocument(String sourceFileName,String fileName, String content, String createTime,String sourceFileId,
				String versionNum,String creatorName,String creatorId,String fileSize,String icon){
		doc = new Document();
	    doc.add(new Field(FIELD_CONTENT,content,Field.Store.YES, Field.Index.ANALYZED));
	    doc.add(new Field(FIELD_FILENAME,fileName,Field.Store.YES, Field.Index.ANALYZED));
	    doc.add(new Field(FIELD_CREATETIME,createTime,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_SOURCEFILEID,sourceFileId,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_VERSIONNUM,versionNum,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_CREATORNAME,creatorName,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_CREATORID,creatorId,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_FILESIZE,fileSize,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    doc.add(new Field(FIELD_SOURCEFILENAME,sourceFileName,Field.Store.YES, Field.Index.ANALYZED));
	    doc.add(new Field(FIELD_SOURCEFILEICON,icon,Field.Store.YES, Field.Index.NOT_ANALYZED));
	    
	    this.sourceFileName = sourceFileName;
	    this.fileName = fileName;
	    this.contents = content;
	    this.createTime = createTime;
	    this.sourceFileId = sourceFileId;
	    this.versionNum = versionNum;
	    this.creatorName = creatorName;
	    this.creatorId = creatorId;
	    this.fileSize = fileSize;
	    this.icon = icon;
	}

	public EdocDocument() {
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSourceFileId() {
		return sourceFileId;
	}

	public void setSourceFileId(String sourceFileId) {
		this.sourceFileId = sourceFileId;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	
}
