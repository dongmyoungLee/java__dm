package com.api.controller;

import java.util.StringTokenizer;

public class StringApiController {

	public static void main(String[] args) {
		// 자바에서 문자열 처리에 대한 클래스
		
		// String : 기본적인 문자열을 처리할때 기본자료형 처럼 사용
		String name = "유병승";
		name = new String("유병승");
		
		// StringBuffer :  클래스 사용방식으로 문자열을 관리 -> 생성, 메소드호출
		StringBuffer sb = new StringBuffer("크리스마스");
		
		// 저장된 문자열을 변경하게 되면 차이가 발생한다.
		System.out.println(name);
		System.out.println(sb);
		
		//저장된 공간이 변경되는 차이가 발생한다.
		System.out.println("String 변경 전 주소 : " + name.hashCode());
		System.out.println("StringBuffer 변경 전 주소 : " + sb.hashCode());
		name += "유후~!";
		System.out.println(name);

		// StringBuffer 의 문자열을 수정할때는 메소드를 이용해야한다.
		// append() 메소드 이용
		sb.append("유후!");
		System.out.println(sb);
		
		//StringBuffer 는 저장값을 계속 만들지 않는다..
		System.out.println("String 변경 후 주소 : " + name.hashCode());
		System.out.println("StringBuffer 변경 후 주소 : " + sb.hashCode());
		
		//String : 일반적인 문자열을 관리할때 사용
		//StringBuffer -> 네트워크상에서 문자열을 전송할 때 사용, 문자를 조작 할 때 (수정,삽입,삭제)
		// StringBuilder : 클래스 사용방식으로 문자열을 관리 -> 생성, 메소드호출
		
		
		// String 에서 제공하는 문자열을 다루는 메소드
		//1. 문자열을 합쳐주는 기능 : concat()
		String test = "IT";
		// 반환해서 변수에 할당해서 사용해야 한다.
		test = test.concat(" 요즘은 코딩이 대세");
		System.out.println(test);
		
		// 2. 특정문자를 포함했는지 확인해주는 기능 : contains() boolean
		boolean result = test.contains("IT");
		
		if (test.contains("IT")) {
			System.out.println("들어있어");
		}
		
		// 3. 문자열에서 특정문자의 인덱스번호로 찾는기능 : indexOf();
		int index	 = test.indexOf("코");
		System.out.println(index);
		
		// 오른쪽에서 부터 검색시작 ...lastIndex();
		
		//4. 특정패턴을 갖는 문자명을 내가 넣은 기준으로 배열로 변환해주는기능 : split();
		// csv 파일 파싱할 때 많이사용 (js랑같은듯)
		
		
		//5. 배열 데이터를 특정구분자로 포함하는 문자열로 반환
		// String.jon("특정구분자", 배열 변수명); static 메소드임
		String[] data = {"서울", "대전", "대구", "부산", "광주", "전주"};
		test = String.join("-", data);
		System.out.println(test);
		
		
		//6 문자열의 지정구역을 잘라내는 기능
		// subString(시작인덱스[,끝인덱스]);
		test = "유병승";
		test = test.substring(0, 1);
		System.out.println(test);
		
		//7. 영문자 대문자, 소문자로 일괄변경 -> toLowerCase 이용
		
		//8. 문자열의 양쪽끝에 공백을 제거해주는기능 : trim();
		test = "유병승 ";
		if(test.trim().equals("유병승")) {
			System.out.println("자바쌤");
		}
		
		//9. 다른 타입의 데이터를 문자열로 변경
		int age = 19;
		double height = 180.5;
		char gender = 'M';
		// test = (String)age; 이거불가함.
		// String에서 제공하는 형변환 메소드를 사용.
		// static 으로 제공 -> valueOf();
		test = String.valueOf(age);
		System.out.println(test);
		
		// 10. 지정문구를 다른 문구로 변환 replace();
		test = "자바 공 부 가 어 렵 다";
		test = test.replace(" ", "");
		System.out.println(test);
		
		
		
		// Stringbuffer 클래스 다루기
		// 원본 저장소를 수정하기 때문에 메소드 실행시 반환형을 갖지 않음(void)
		// 저장된 문자열 조작 하는 기능.
		// 1. 저장된 문자열에 특정 문구를 추가하는 기능 : append();
		
		StringBuffer sbTest = new StringBuffer();
		sbTest.append("이제 곧 쉬는시간");
		System.out.println(sbTest);
		
		// 2. 문자열의 특정위치에 삽입을 하는 기능 : insert();
		sbTest.insert(3, "갓갓갓갓갓");
		System.out.println(sbTest);
		sbTest.insert(sbTest.indexOf("갓갓갓갓갓"), "굿");
		System.out.println(sbTest);
		
		// 3. 특정위치 문자 삭제 : delete();
		sbTest.delete(0, 5);
		System.out.println(sbTest);
		
		// 4.한글자만 지우기 : deleteCharAt();
		sbTest.deleteCharAt(0);
		System.out.println(sbTest);
		
		// 5. 특정문자 수정 : setCharAt();
		
		// String 에서 제공하는 기본 method도 다 사용가능
		
		
		// StringBuilder 클래스는 Buffer 클래스와 동일하다.
		StringBuilder sb2 = new StringBuilder("빌덕밧");
		System.out.println(sb2);
		
		// append, insert 등등 다 가능
		
		
		// StringTokenizer 클래스 이용하기
		// 문자열을 특정문자 기준으로 구분하고 iterate 방식으로 한개씩 가져와서 사용하는 클래스
		// String 클래스의 split() 메소드와 비슷하다.
		
		test = "AA|BB|CC";
		test = "oracle,html/css,javascript,jquery,servlet/jsp,mybatis,spring";
		// split은 이런거 안됨 ㅋ
		StringTokenizer st = new StringTokenizer(test, ",/");
		// StringTokenizer 에서 데이터 가져올때 제공하는 메소드 사용
		
		// iterate 방식으로 꺼내 쓰는 방식
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
		
	}

	@Override
	public String toString() {
		return "StringApiController [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
