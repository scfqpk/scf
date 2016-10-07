package service;

import java.util.List;
import java.util.Map;

import entity.Article;
import entity.SpiltPage;

public interface Inews {
public abstract SpiltPage ls(int cur,String words);
public abstract boolean deletenews(int id);
public abstract boolean deleteAllnews(String ids);
public abstract boolean updatenews(Article art);
}
