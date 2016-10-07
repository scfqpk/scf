package service;

import java.util.List;
import java.util.Map;

import dao.CateAddDao;
import entity.Category;


public class CateAddService {
	private CateAddDao cad = new CateAddDao();
	public List<Map<String,Object>> queryCats(Category cate){
		return cad.queryCate(cate);
	}
	
	public boolean insertCat(Category cate){
		return cad.insertCate(cate);
	}

}
