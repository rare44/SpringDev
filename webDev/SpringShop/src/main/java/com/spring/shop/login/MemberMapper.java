package com.spring.shop.login;

public interface MemberMapper {
	//myBatis >> Spring ���̿��� db��ű���� �����ϴ¾�
	public abstract int joinMember(Member m);

	public abstract int checkID(String id);

	public abstract Member getMemberByID(Member m);
	
	
}
