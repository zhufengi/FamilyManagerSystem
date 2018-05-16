package com.zf.fms.service;

import com.zf.fms.bean.FamilyUser;
import com.zf.fms.dao.UserDao;

import java.util.List;

/**
 * Created by sang on 2017/8/17.
 */
public class UserService {
    private UserDao userDao = new UserDao();
    private FamilyUser loginUser;

    public List<FamilyUser> searchEmp(String username) {
        return userDao.searchEmp(username);
    }

    public FamilyUser getLoginUser() {
        return loginUser;
    }
    public int getCount( String username) {
        return userDao.getCount( username);
    }
    public int updateEmpStatusById(int id) {
        return userDao.updateEmpStatusById(id);
    }
    public List<FamilyUser> getFamilyer() {
        return userDao.getFamilyer();
    }

    /**
     * 获取用户数量
     * @return
     */
    public int getUserCount(){
        return userDao.getUserCount();
    }
    public int login(String username, String password) {
        int result = -1;//表示登录失败
        FamilyUser loginEmp = userDao.login(username, password);
        if (loginEmp == null) {
            return result;
        }else{
            this.loginUser = loginEmp;
            return loginEmp.getUserId();
        }
    }

    public int reg(FamilyUser user) {
        return userDao.reg(user);
    }
    public int updatePass(String password,int userId){
        return userDao.updatePass(password,userId);
    }
}
