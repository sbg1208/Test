package com.bs.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.bs.model.dao.BsDAO;
import com.bs.model.vo.Member;

public class bsService {

	
	/*1. DB와 연결할 수 있는 Connection객체 생성
	2. DAO에 Connection객체/ controller가 보낸 데이터 전달
	3. 트랜젝션관리(commit,rollback)
	4. Connection객체 반환*/
	
	public Member selectMember(String id,String pw) {
		Connection conn =getConnection();
		Member m = new BsDAO().selectMember(conn,id,pw);
		close(conn);
		return m;
	}
	
}
