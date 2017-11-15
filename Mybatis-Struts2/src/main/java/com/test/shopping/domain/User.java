package com.test.shopping.domain;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author JUST-GO
 *  这是用户信息的domain对象
 *  包含很多属性
 */
public class User {
	private Long id            ;     //唯一标识:对应着表中的主键
	private String username      ;     //用户名称 ,用于登陆使用--->唯一性.
	private String password      ;     //密码
	private String email         ;     //注册邮箱地址,唯一
	
	private Integer type          ;     //用户的类别.  0:超级管理员,1:管理员,2:客户
	private Boolean status        ;     //账号状态:    0:启用,1:禁用
	private Date loginTime     ;     //当前登陆的时间
	private String loginIp       ;     //当前登陆的IP
	private Date lastLoginTime ;     //上一次的登陆时间
	private String lastLoginIp   ;     ///上一次的登陆IP
	
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Integer getType() {
		return type;
	}
	public Boolean getStatus() {
		return status;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", type=" + type
				+ ", status=" + status + ", loginTime=" + loginTime
				+ ", loginIp=" + loginIp + ", lastLoginTime=" + lastLoginTime
				+ ", lastLoginIp=" + lastLoginIp + "]";
	}
	
	
	
}
