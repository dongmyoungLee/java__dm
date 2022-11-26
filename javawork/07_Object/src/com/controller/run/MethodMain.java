package com.controller.run;

import java.util.Arrays;

import com.obj.model.vo.Animal;
import com.obj.model.vo.NewStudent;
import com.obj.model.vo.Student;
import static com.controller.run.MethodsTest.sendMsgStatic;
import static com.controller.run.MethodsTest.test1;

public class MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsTest t = new MethodsTest();
		//System.out.println(t.numAccumulation());
		
		//t.numSend(5, 10);
		
		//t.redundantData("abcdd");
		
		int[] paramArr = new int[] {5,6,7,8};
		t.paramArr(paramArr);
		
		Animal pet = new Animal("카키", 0, "강아지", '남');
		t.paramObj(pet);
		
		int number = 100;
		t.updateNumber(number);
		// 여기서 200이 아니라 100이 나오는 이유는..? -> 기본자료형에 대해서 참조를 할 수 없음.. 매개변수로 넘길때 값을 복사해서 준 것임.. 
		// 만약 200이 나오게 하고 싶다면 ?.. method 에서 return 해줘야함.. java는 포인터가 없으므로 원본자료를 수정할 수 없음..
		//System.out.println(number);
		
		
		// heap메모리에 등록된 데이터는 다른 메소드에서 접근가능.
		int[] intArr = {1,2,3,4,5};
		//System.out.println("intArr 전 " + Arrays.toString(intArr));
		t.updateArr(intArr);
		//System.out.println("intArr 후 " + Arrays.toString(intArr));
		
		// heap메모리에 등록된 데이터는 다른 메소드에서 접근가능.
		Animal pet2 = new Animal("카키", 0, "강아지", '남');
		//System.out.println("메소드 실행 전 " + pet2.name + " " + pet2.age + " " + pet2.gender + " " + pet2.type);
		t.updatePerson(pet2);
		//System.out.println("메소드 실행 후 " + pet2.name + " " + pet2.age + " " + pet2.gender + " " + pet2.type);
		
		t.testReturn("t");
		
		// static 메소드 호출하기
		// 클래스명.메소드명() -> 호출한다. 생성자를 이용하지 않고도 호출한다. 또한 접근제한자의 영향을 받을 수는 있음.
		//MethodsTest.sendMsgStatic("static 테스트");
		
		// static 메소드 활용 시 클래스명을 적지 않아도 사용할 수 있게 하는법. -> static import 를 해주면 됨.
		//sendMsgStatic("static 테스트");
		//System.out.println(test1(10));
		
	}

}
