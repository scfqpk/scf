package service;

import dao.CateMgDao;
import entity.Category;
import entity.SpiltPage;

public class CateMgService {
	private CateMgDao cmd = new CateMgDao();
	public boolean deleteCat(Category cate){
		return cmd.deleteCat(cate);
	}
	public boolean deleteAllCat(String ids){
		return cmd.deleteAllCat(ids);
	}
	public SpiltPage updateCat(int cur){
		return cmd.updateCat(cur);
	}
	public boolean modifycate(Category cate){
		return cmd.modifycate(cate);
	}
}