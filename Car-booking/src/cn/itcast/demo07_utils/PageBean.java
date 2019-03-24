package cn.itcast.demo07_utils;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{

	private int pageNumber;//当前页 ---前台传递
	
	private int pageSize;//一页显示多少条数据 ---后台自定义
	
	private int startIndex;//起始索引下标 --- 计算出来
	
	private int totalRecord;//总记录数---  从数据库中查询出来
	
	private int totalPage; //总页数  ---  计算出来
	
	private List<T> result;//每一页的数据  --从数据库中查询出来

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex=(this.getPageNumber()-1)*this.getPageSize();
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage=(this.getTotalRecord()%this.getPageSize()==0?(this.getTotalRecord()/this.getPageSize()):(this.getTotalRecord()/this.getPageSize()+1));
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}
