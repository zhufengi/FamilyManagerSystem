package com.zf.fms.dao;

import com.zf.fms.bean.FamilyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17 0017.
 * 用户表
 */
public class UserDao {

    public int updateEmpStatusById(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("UPDATE  familyuser WHERE userID=?");
            ps.setInt(1,id);
            return ps.executeUpdate();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(ps);
            DBUtils.close(connection);
        }
        return -1;
    }

    /**
     * 获取users的数量
     * @return
     */
    public int getUserCount(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps=connection.prepareStatement("SELECT count(*) FROM familyuser");
            rs = ps.executeQuery();
            if (rs.next()){
               return rs.getInt(1);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.close(ps);
            DBUtils.close(connection);
        }
        return -1;
    }

    /**
     * 系统登录
     * @param name
     * @param password
     * @return
     */
    public FamilyUser login(String name, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM familyuser WHERE name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new FamilyUser(rs.getInt("userId"), rs.getString("name"),
                        rs.getString("sex"), rs.getString("age"),
                        rs.getString("password"), rs.getString("phone"),
                        rs.getString("work"), rs.getTimestamp("birthTime"),
                        rs.getString("birthAddress"),rs.getInt("role"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取家庭成员
     * @return
     */
    public List<FamilyUser> getFamilyer(){
        List<FamilyUser> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("SELECT * FROM familyuser WHERE role=1 OR role=2");
            rs = ps.executeQuery();
            while (rs.next()){
                users.add( new FamilyUser(rs.getInt("userId"), rs.getString("name"),
                        rs.getString("sex"), rs.getString("age"),
                        rs.getString("phone"), rs.getString("work"),
                        rs.getTimestamp("birthTime"), rs.getString("birthAddress")));
            }
            return users;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(connection);
        }
        return users;

    }

    /**
     * 搜索的结果数
     * @param name
     * @return
     */
    public  int getCount(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT count(*) FROM  familyuser");
        if (name != null && !"".equals(name)) {
            sb.append(" WHERE name=?");
        }
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            int index = 1;
            if (name != null && !"".equals(name)) {
                ps.setString(index++, name);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }

    /**
     *  更新密码
     * @param password
     * @param userId
     * @return
     */
    public int updatePass(String password, int userId){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("UPDATE familyuser SET password=? WHERE userId=?");
            ps.setString(1, password);
            ps.setInt(2, userId);
            return ps.executeUpdate();//mysql更新
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }



    /**
     * 注册成员
     * @param familyUser
     * @return
     */
    public int reg(FamilyUser familyUser) {
        if (isUsernameExists(familyUser.getName())) {
            return -1;
        }
        System.out.println(familyUser.toString());
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("INSERT INTO familyuser(userId,name,sex,age,password,phone,work,birthAddress,role) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, familyUser.getUserId());
            ps.setString(2, familyUser.getName());
            ps.setString(3, familyUser.getSex());
            ps.setString(4, familyUser.getAge());
            ps.setString(5, familyUser.getPassword());
            ps.setString(6, familyUser.getPhone());
            ps.setString(7, familyUser.getWork());
            ps.setString(8, familyUser.getBirthAddress());
            ps.setInt(9,familyUser.getRole());
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return 0;
    }

    public boolean isUsernameExists(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * from familyuser WHERE name=?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return false;
    }
    public  List<FamilyUser> searchEmp(String name) {
        List<FamilyUser> users = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT * FROM familyuser");
        if (name != null && !"".equals(name)) {
            sb.append(" WHERE name LIKE ?");//where 后面需要跟 ?
        }
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            int index = 1;
            if (name != null && !"".equals(name)) {
                ps.setString(index++, '%'+name+'%');
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add( new FamilyUser(rs.getInt("userId"), rs.getString("name"),
                        rs.getString("sex"), rs.getString("age"),
                        rs.getString("phone"), rs.getString("work"),
                        rs.getTimestamp("birthTime"), rs.getString("birthAddress")));

            }
            return users;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return users;
    }
}
