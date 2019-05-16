package com.wxl.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wxl.bean.Product;
import com.wxl.bean.User;
import com.wxl.service.LoginService;
import com.wxl.service.ProductService;

public class LoginAction {
	private User user = new User(); 
	private Product product;
	private ArrayList<Product> proList;
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	
	public String login(){
		LoginService ls = new LoginService();
		User myUser = ls.queryByName(user.getName());
		if(myUser==null){
			return "login";
		}
		if(user.getName().equals(myUser.getName()) && user.getPassword().equals(myUser.getPassword())){
			Cookie nameCookie = new Cookie("LOGINNAME",user.getName());
			ServletActionContext.getResponse().addCookie(nameCookie);
			ActionContext.getContext().put("LOGINNAME", user.getName());
			
			ProductService ps = new ProductService();
			proList = ps.queryAllPro();
			return "list";
		}
		return "login";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ArrayList<Product> getProList() {
		return proList;
	}
	public void setProList(ArrayList<Product> proList) {
		this.proList = proList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
}
