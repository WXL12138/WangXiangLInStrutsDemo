package com.wxl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wxl.bean.Product;
import com.wxl.bean.ProductVo;

public class ProductDao extends BaseDao {
	
	public ArrayList<Product> queryByVo(ProductVo pv){
		ArrayList<Product> list = new ArrayList<Product>();
		StringBuffer str = new StringBuffer("select * from product where 1=1 ");
		ArrayList valueList = new ArrayList();
		if(!"".equals(pv.getProductName())){
			str.append("and productName like ? ");
			valueList.add("%"+pv.getProductName()+"%");
		}
		if(0!=pv.getMinprice()){
			str.append("and price>? ");
			valueList.add(pv.getMinprice());
		}
		if(0!=pv.getMaxprice()){
			str.append("and price<? ");
			valueList.add(pv.getMaxprice());
		}
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(str.toString());
				for (int i = 0; i < valueList.size(); i++) {
					ps.setObject(i+1, valueList.get(i));
				} 
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Product pro = new Product();
					pro.setId(rs.getInt("id"));
					pro.setPicture(rs.getString("picture"));
					pro.setPrice(rs.getDouble("price"));
					pro.setProductName(rs.getString("productName"));
					list.add(pro);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public int updateId(Product pro){
		int i = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("update product set productName=?,price=?,picture=? where id=?");
				ps.setString(1, pro.getProductName());
				ps.setDouble(2, pro.getPrice());
				ps.setString(3, pro.getPicture());
				ps.setInt(4, pro.getId());
				i = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public Product getMyId(int id){
		Product pro = null;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select*from product where id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					pro = new Product();
					pro.setId(id);
					pro.setPicture(rs.getString("picture"));
					pro.setPrice(rs.getDouble("price"));
					pro.setProductName(rs.getString("productName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pro;
	}
	
	public int deleteId(int id){
		int result = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("delete from product where id = ?");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Product> queryPro(){
		ArrayList<Product> list =new ArrayList<Product>();
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select * from product");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Product pro = new Product();
					pro.setId(rs.getInt("id"));
					pro.setPicture(rs.getString("picture"));
					pro.setPrice(rs.getDouble("price"));
					pro.setProductName(rs.getString("productName"));
					list.add(pro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	public int toAddPro(Product p){
		int result = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("insert into product(productName,price,picture) values(?,?,?)");
				ps.setString(1, p.getProductName());
				ps.setDouble(2, p.getPrice());
				ps.setString(3, p.getPicture());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
