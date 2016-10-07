package entity;

import java.util.List;
import java.util.Map;

public class SpiltPage {
	private int curpage;//当前页
	private int cursize;//当前页的大小
	private List<Map<String, Object>> ls;//获取分页的数据
	private int maxpage;//最大页
	private int countpage;//总条数
	

	public int getCurpage() {
		if (curpage < 1) {
			curpage = 1;
		}
		if (curpage > maxpage) {
			curpage = maxpage;
		}
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getCursize() {
		return cursize;
	}

	public void setCursize(int cursize) {
		this.cursize = cursize;
	}

	public List<Map<String, Object>> getLs() {
		return ls;
	}

	public void setLs(List<Map<String, Object>> ls) {
		this.ls = ls;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public int getCountpage() {
		return countpage;
	}

	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
 

}
