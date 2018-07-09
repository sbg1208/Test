package com.bs.model.vo;

public class Member {

	private String id;
	private String pw;
	private String name;
	private int age;
	private String nickName;
	private String email;
	
	public Member() {
		
	}

	public Member(String id, String pw, String name, int age, String nickName, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.nickName = nickName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", nickName=" + nickName
				+ ", email=" + email + "]";
	}
	
	
	
	
	
}
