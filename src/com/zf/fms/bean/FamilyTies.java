package com.zf.fms.bean;

/**
 * Created by Administrator on 2018/4/17 0017.
 * 家庭成员关系
 */
public class FamilyTies {
    private int familyTiesId;
    private String familyTies;

    public FamilyTies(int familyTiesId, String familyTies) {
        this.familyTiesId = familyTiesId;
        familyTies = familyTies;
    }

    public int getFamilyTiesId() {
        return familyTiesId;
    }

    public void setFamilyTiesId(int familyTiesId) {
        this.familyTiesId = familyTiesId;
    }

    public String getFamilyTies() {
        return familyTies;
    }

    public void setFamilyTies(String familyTies) {
        familyTies = familyTies;
    }
}
