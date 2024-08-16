package com.example.casemodule3.dao;

import com.example.casemodule3.context.DBContext;
import com.example.casemodule3.model.Account;
import com.example.casemodule3.model.Category;
import com.example.casemodule3.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// load du lieu tu DB len
public class DAO {
    Connection conn = null;
    PreparedStatement ps= null;
    ResultSet rs = null;

    public List<Product> getAllProduct(){
        List<Product> list  = new ArrayList<>();

        String query  = "select * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Category> getAllCategory(){
        List<Category> list  = new ArrayList<>();

        String query  = "select * from category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductByCID(String cid){
        List<Product> list  = new ArrayList<>();

        String query  = "select *from product where cateID = ?" ;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByID(String id){

        String query  = "select *from product where id = ?" ;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public List<Product> searchByName(String txtSearch){
        List<Product> list  = new ArrayList<>();
        String query = "select * from product where name like ?";
        try{
            conn = new DBContext().getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1,"%" + txtSearch+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public Account login(String user, String pass){
        String query = "select *from account where user = ? and pass = ?";


        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();

            while (rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        }catch (Exception e){
        }

        return null;
    }

    public Account checkAccountExist(String user){
        String query = "select *from account where user = ? ";


        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            rs = ps.executeQuery();

            while (rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        }catch (Exception e){
        }

        return null;
    }
    public  void signup(String user, String pass) {
        String query = "insert into account(user, pass, isSell, isAdmin) values(?,?,0,0)";

        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2, pass);
            ps.executeUpdate();


        }catch (Exception e){

        }
    }
    public List<Product> getProductBySellId(int sellID) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE sellID = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, sellID);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getString("title"),
                        rs.getString("description")));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list =dao.getProductBySellId(1);
        System.out.println(list);
    }




}
