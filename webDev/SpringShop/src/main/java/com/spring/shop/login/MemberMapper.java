package com.spring.shop.login;

public interface MemberMapper {
	//myBatis >> Spring 사이에서 db통신기능을 구현하는애
	public abstract int joinMember(Member m);

	public abstract int checkID(String id);

	public abstract Member getMemberByID(Member m);
	
	
}
