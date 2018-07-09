package com.bs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bs.model.vo.Member;

public class BsDAO {
	public Member selectMember(Connection conn, String id, String pw) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select * from member where id=? ";
		Member m = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setPw(rs.getString("password"));
				m.setNickName(rs.getString("nickName"));
				m.setEmail(rs.getString("email"));
				
				/*찾을 m의 값을 변경후 m리턴*/
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
