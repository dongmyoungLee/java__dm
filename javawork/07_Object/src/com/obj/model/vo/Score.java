package com.obj.model.vo;

public class Score {
	private int math;
	private int eng;
	private int kor;
	private int coding;
	private String studentId;

	public Score() {}
	
	public Score(String studentId) {
		this.studentId = studentId;
	}
	
	public Score(int math, int eng, int kor, int coding, String studentId) {
		this.math = math;
		this.kor = kor;
		this.eng = eng;
		this.coding = coding;
		this.studentId = studentId;
	}
	
	// 기능(메소드)으로 변수를 이용하게 만들자..
	// 필드 값을 대입 -> setter() 메소드
	// 필드 값을 가져오는 것 -> getter() 메소드
	// 일반적으로 클래스에 선언된 필드는 각 setter와 getter 메소드가 한개씩 있음.
	
	// 접근제한자 반환형 메소드명(매개변수) { 로직 }
	// 메소드명에 대한 규칙이 있음.
	// getter : get필드명 -> getMath();
	
	public void setMath(int math) {
		if (math < 0) {
			this.math = 0;
		}
		
		this.math = math;
	}
	public int getMath() {
		return this.math;
	}
	
	public void setKor(int kor) {
		if (kor < 0) {
			this.kor= 0;
		}
		
		this.kor = kor;
	}
	public int getKor() {
		return this.kor;
	}
	
	public void setEng(int eng) {
		if (eng < 0) {
			this.eng= 0;
		}
		
		this.eng = eng;
	}
	public int getEng() {
		return this.eng;
	}
	
	public void setCoding(int coding) {
		if (coding < 0) {
			this.coding= 0;
		}
		
		this.coding = coding;
	}
	public int getCoding() {
		return this.coding;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	// 객체의 정보를 추가 알려주는 메소드 만들기
	public void infoScorePrint() {
		System.out.println(math + " " + kor + " " + eng + " " + coding);
	}
	
	public String infoScore() {
		return math + " " + kor + " " + eng + " " + coding + " " + studentId;
	}
	
	public void sum() {
		int result = 0;
		
		result += math;
		result += kor;
		result += eng;
		result += coding;
		
		System.out.println(result);
	}
	
	public void average() {
		int result = 0;
		
		result = (math + kor + eng + coding) / 4;
		
		System.out.println(result);
	}
	
		
}
