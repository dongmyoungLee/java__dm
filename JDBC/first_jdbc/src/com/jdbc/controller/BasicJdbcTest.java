package com.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbc.model.vo.Member;

public class BasicJdbcTest {

	public static void main(String[] args) {
		// JDBC 를 이용해서 DB에 있는 데이터 조작하기(CRUD)
		
		try {
			
			try {
				// 1. jar 가 제공하는 클래스가 있는지 확인
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				// 2. DriverManager 클래스를 이용해서 접속하는 객체를 생성한다.
				
				// - DriverManager 클래스가 제공하는 getConnection()메소드 (static)를 이용
				// getConnection 메소드의 매개변수
				// 첫번째 매개변수 : DB 접속 주소(DB서버), 이용포트, DB버전 String 값..
				
				// 문자열패턴 : jdbc:oracle:thin:@접속ip주소:포트번호:버전명 -> oracle...
				// 두번째 매개변수 : 사용자 계정명(DB접속계정) String 자료형..
				
				// 세번째 매개변수 : 사용자 계정 비밀번호 String 자료형..
				
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"BS",
						"BS"
						);
				System.out.println("DB접속 완료");
				
				// Connection 에서 트랜잭션 처리하기 -> commit , rollback
				// 기본 Connection 에서는 autocommit 으로 실행됨.
				// 직접 commit , rollback 을 핸들링하기 위해..
				conn.setAutoCommit(false);
				
				// 3. Connection 객체를 이용해서 sql 문 실행 객체를 생성함..
				// Statement, PreparedStatement 두개의 객체가 있음..
				// Statement : Connection 객체의 createStatement() 메소드 이용..
				// PreparedStatement : Connection 객체의 preparedStatement() 메소드를 이용..
				
				Statement stmt = conn.createStatement();
//				PreparedStatement pstmt = conn.prepareStatement("sql 문");
				
				
				// 4. 생성된 Statement, PreparedStatement 객체가 제공하는 메소드를 이용해서 sql 문 실행..
				// executeQuery(["sql문"]) : select 문을 실행할때 사용 -> 반환형 ResultSet 객체
				// executeUpdate(["sql문"]) : insert, update, delete문을 사용할때 사용 -> 반환형 int 
				
				// 1) 실행할 sql 문 작성
				String sql = "SELECT * FROM MEMBER";
				
				// 2) 쿼리문 실행하기
				// select 문 실행의 결과는 ResultSet 객체에 저장..
				ResultSet rs = stmt.executeQuery(sql);
//				int result = stmt.executeQuery("")
				
				// 5. 가져온 결과 활용
				// ResultSet 객체에는 DB에서 조회한 데이터가 저장되어 있음
				// ResultSet 이 제공하는 메소드를 이용해서 데이터를 가져옴
				// 1. next() : 다음 row를 지정할때 사용하는 메소드 -> 반환형 true , false
				// 2. getString || getInt || getDouble ...
				
				// 1번 row를 가져옴
				
				/*
				rs.next();
				
				// dataMapping
				String memberId = rs.getString("member_id");
				String password = rs.getString("member_pwd");
				String memberName = rs.getString("member_name");
				int age = rs.getInt("age");
				Date enroll_date = rs.getDate("enroll_date");
				
				// 2번 row
				rs.next();
				
				memberId = rs.getString("member_id");
				memberName = rs.getString("member_name");
				password = rs.getString("member_pwd");
				age = rs.getInt("age");
				enroll_date = rs.getDate("enroll_date");
				
				System.out.println(memberId + " " + memberName + " " + password + " " + age + " " + enroll_date);
				*/
				
				// 조회된 전체 데이터 출력
				/*
				while(rs.next()) {
					String memberId = rs.getString("member_id");
					String password = rs.getString("member_pwd");
					String memberName = rs.getString("member_name");
					int age = rs.getInt("age");
					Date enroll_date = rs.getDate("enroll_date");
					System.out.println(memberId + " " + memberName + " " + password + " " + age + " " + enroll_date);
				}
				*/
				
				// 인덱스번호로 가져올수도 있긴함
//				while(rs.next()) {
//					String memberId = rs.getString(1);
//					String password = rs.getString(2);
//					String memberName = rs.getString(3);
//					int age = rs.getInt(5);
//					Date enroll_date = rs.getDate(10);
//					System.out.println(memberId + " " + memberName + " " + password + " " + age + " " + enroll_date);
//				}
				
				// DB 에서 가져온 데이터는 VO 클래스에 저장해서 관리
				// DB 의 1개 row는 1개 VO객체와 매핑되어 처리..
				
				List<Member> members = new ArrayList();
				
				/*
				while(rs.next()) {
					Member m = new Member();
					
					m.setMemberId(rs.getString("member_id"));
					m.setMemberPwd(rs.getString("member_pwd"));
					m.setMemberName(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setAge(rs.getInt("age"));
					m.setEmail(rs.getString("email"));
					m.setAddress(rs.getString("address"));
					m.setHobby(rs.getString("hobby").split(","));
					m.setEnrollDate(rs.getDate("enroll_date"));
					
					members.add(m);
				}
				
				members.stream().forEach(e -> System.out.println(e));
				
//				for (Member m : members) {
//					System.out.println(m);
//				}
				
				*/
				
				
				// sql 문 조건이 있는 경우 -> where 절
				// 1. 성별이 남자인 회원만 검색
				Scanner sc = new Scanner(System.in);
				/*
				System.out.println("남자인 회원만 조회");
				System.out.println("검색할 성별 : ");
				String keyword = sc.next();
				
				sql = "SELECT * FROM MEMBER WHERE GENDER = '" + keyword + "'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Member m = new Member();
					
					m.setMemberId(rs.getString("member_id"));
					m.setMemberPwd(rs.getString("member_pwd"));
					m.setMemberName(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setAge(rs.getInt("age"));
					
					members.add(m);
				}
				
				members.stream().forEach(e -> System.out.println(e));
				*/
				
				// 주소 조회
				
				/*
				System.out.println("주소로 조회하기");
				System.out.println("주소 입력 : ");
				String addrKeyword = sc.next();
				
				sql = "SELECT * FROM MEMBER WHERE ADDRESS LIKE '%" + addrKeyword + "%'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Member m = new Member();
					
					m.setMemberId(rs.getString("member_id"));
					m.setMemberPwd(rs.getString("member_pwd"));
					m.setMemberName(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setAge(rs.getInt("age"));
					m.setAddress(rs.getString("address"));
					
					members.add(m);
				}
				
				members.stream().forEach(e -> System.out.println(e));
				
				*/
				
				// DML 구문 실행하기
				// insert, updatem, delete 구문 실행
				// 트랜잭션 처리를 해줘야함..
				System.out.println("회원가입");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				System.out.println("패스워드 :");
				String pw = sc.nextLine();
				System.out.println("이름 :");
				String nm = sc.nextLine();
				System.out.println("성별 :");
				String gender = sc.nextLine();
				System.out.println("나이 : ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("이메일 : ");
				String mail = sc.nextLine();
				System.out.println("번호 : ");
				String phone = sc.nextLine();
				System.out.println("주소 : ");
				String addr = sc.nextLine();
				System.out.println("취미 : ");
				String hobb = sc.nextLine();
				
				
				sql = "INSERT INTO MEMBER VALUES('"+id+"', '"+pw+"', '"+nm+"', '"+gender+"', "+age+",'"+mail+"', '"+phone+"', '"+addr+"', '"+hobb+"', SYSDATE)";
				int result = stmt.executeUpdate(sql);
				System.out.println(result);
				
				if (result > 0) {
					conn.commit();
					System.out.println("회원가입이 완료 되었습니다.");
				} else {
					conn.rollback();
				}
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
