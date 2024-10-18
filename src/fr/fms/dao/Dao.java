package fr.fms.dao;

import java.util.ArrayList;

import fr.fms.entities.Article;

public interface Dao {
	
	public void create(Article obj);
	public boolean update (Article obj);
	public boolean delete (Article obj);
	public ArrayList<Article>readAll();
}
