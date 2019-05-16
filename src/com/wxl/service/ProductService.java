package com.wxl.service;

import java.util.ArrayList;

import com.wxl.bean.Product;
import com.wxl.bean.ProductVo;
import com.wxl.dao.ProductDao;

public class ProductService { 
	
	public ArrayList<Product> queryByInfo(ProductVo pv){
		ArrayList<Product> list = null;
		ProductDao dao = new ProductDao();
		list = dao.queryByVo(pv);
		return list;
		
	}
	
	public boolean updateByAll(Product pro){
		boolean b = false;
		ProductDao dao = new ProductDao();
		int i =dao.updateId(pro);
		if(i>0){
			b = true;
		}
		return b;
	}
	
	public Product queryById(int id){
		ProductDao dao = new ProductDao();
		Product pro = dao.getMyId(id);
		return pro;
	}
	
	public boolean deleteById(int id){
		boolean b = false;
		ProductDao dao = new ProductDao();
		int i = dao.deleteId(id);
		if(i>0){
			b = true;
		}
		return b;
		
	}
	
	public ArrayList<Product> queryAllPro(){
		ArrayList<Product> list = null;
		ProductDao dao = new ProductDao();
		list = dao.queryPro();
		return list;
	}
	
	public int addPro(Product p){
		ProductDao dao = new ProductDao();
		int i = dao.toAddPro(p);
		return i;
	}
}
