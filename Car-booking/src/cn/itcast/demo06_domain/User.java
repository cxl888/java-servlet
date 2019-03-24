package cn.itcast.demo06_domain;

public class User {
   private int uid;
   private String username;
   private String password;
   private String realname;
   private String email;
   private String sex;
   private String birthday;
   private String history;
public String getHistory() {
	return history;
}
public void setHistory(String history) {
	this.history = history;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
}
