package com.bs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.model.service.bsService;
import com.bs.model.vo.Member;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. parameter값 가져오기(client가 보내준 데이터)
//		2. 그 데이터를 DB에 가서 정보를 조회,수정,삭제,삽입<CRUD)
//			- JDBC를 이용한 데이터 처리!
//		3. 정보확인 후 관련 응답페이지 작성 / 페이지 호출
		
		//parameter값으로 넘어오는 데이터는 타입이 문자열임. 
		//숫자형 데이터가 오는 경우는 parsing처리
		//post방식으로 문자형 데이터가 오는 경우 문자형 데이터가 한글일 경우 글자가 깨짐 
		//문자셋설정을 해줘야함!(filter에서 설정함)
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//비지니스 로직처리!
		Member m = new bsService().selectMember(id, pw);
		
		//응답페이지작성
		if(m!=null) {
			if(m.getPw().equals(pw)) {
				//로그인성공!!
				RequestDispatcher rd = request.getRequestDispatcher("login.do");
				rd.forward(request, response);
			}else {
				//비밀번호가 다름
				RequestDispatcher rd = request.getRequestDispatcher("errorPW.do");
				request.setAttribute("msg", "패스워드가 일치하지 않습니다!");
				rd.forward(request, response);
			}
		}else {
			//아이디 없음
			RequestDispatcher rd = request.getRequestDispatcher("errorID.do");
			request.setAttribute("msg", "아이디가 일치하지 않습니다!!");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
