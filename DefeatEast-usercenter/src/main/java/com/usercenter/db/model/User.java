package com.usercenter.db.model;

import java.util.Date;

public class User {
	
    private Integer id;

    private String idcard;

    private String link;

    private Integer linkType;

    private String name;

    private String psw;

    private String salt;

    private Date monifyTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getMonifyTime() {
        return monifyTime;
    }

    public void setMonifyTime(Date monifyTime) {
        this.monifyTime = monifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}