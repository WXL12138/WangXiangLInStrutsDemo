package com.wxl.action;

import java.io.File;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wxl.bean.Product;
import com.wxl.bean.ProductVo;
import com.wxl.service.ProductService;

public class ProductAction implements ModelDriven<Product>{
	private Product product;
	private ArrayList<Product> proList;
	private ProductVo pv;

	private File photo;
	private String photoFileName;
	private String photoContentType;
	
	public String query(){
		ProductService ps = new ProductService();
		proList = ps.queryByInfo(pv);
		return "list";
	}
	
	public String update(){
		ProductService ps = new ProductService();
		File file = new File("D:/picfile");
		if(!file.exists()){
			file.mkdir();
		}
		String newFileName = System.currentTimeMillis()+photoFileName.substring(photoFileName.lastIndexOf("."));
		photo.renameTo(new File(file,newFileName));
		product.setPicture("/pic/"+newFileName);
		
		
		boolean b = ps.updateByAll(product);
		if(b){
			proList = ps.queryAllPro();
			ActionContext.getContext().put("MSG", "修改成功");
			return "updateSc";
		}else{
			ActionContext.getContext().put("MSG", "修改失败");
			return "update";
		}
	}
	
	public String preUpdate(){
		ProductService ps = new ProductService();
		Product pro =  ps.queryById(product.getId());
		product.setPrice(pro.getPrice());
		product.setProductName(pro.getProductName());
		product.setId(pro.getId());
		product.setPicture(pro.getPicture());
		
		return "update";
	}
	
	public String delete(){
		ProductService ps = new ProductService();
		boolean b = ps.deleteById(product.getId());
		if(b){
		proList = ps.queryAllPro();
		ActionContext.getContext().put("MSG", "删除成功");
		}else{
			ActionContext.getContext().put("MSG", "删除失败");
		}
		return "delete";
	}
	
	public String preAdd(){
		return "addList";
	}
	public String add(){
		File file = new File("D:/picfile");
		if(!file.exists()){
			file.mkdir();
		}
		String newFileName = System.currentTimeMillis()+photoFileName.substring(photoFileName.lastIndexOf("."));
		photo.renameTo(new File(file,newFileName));
		product.setPicture("/pic/"+newFileName);
		
		ProductService ps = new ProductService();
		int i = ps.addPro(product);
		if(i>0){
			proList = ps.queryAllPro();
			
			ActionContext.getContext().put("MSG", "增加成功");
			return "list";
		}else{
			ActionContext.getContext().put("MSG", "增加失败");
			return "addList";
		}
	}
	@Override
	public Product getModel() {
		if(product==null){
			product= new Product();
		}
		return product;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public ProductVo getPv() {
		return pv;
	}

	public void setPv(ProductVo pv) {
		this.pv = pv;
	}
	

}
