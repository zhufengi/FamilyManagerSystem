package com.zf.fms.dao;

import com.zf.fms.bean.FamilyTies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public class FamilyTiesDao {
    public int updateFamilyTies(String FamilyTies,int FamilyTiesId){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            ps = con.prepareStatement("UPDATE familyties SET familyTies=? WHERE familyTiesId=?");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }
    public int insert(String name){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("insert into familyties (familyTies) values (?);");
            ps.setString(1,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return -1;
    }
    public int deleteFamilyTies(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("DELETE FROM familyties WHERE familyTiesId=?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }

    public List<FamilyTies> getAllFamilyTies() {
        List<FamilyTies> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("select * from department;");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FamilyTies(rs.getInt("familyTiesId"), rs.getString("familyTies")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
