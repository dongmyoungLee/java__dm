package com.polymorphism.controller;

import com.polymorphism.vo.Animal;
import com.polymorphism.vo.Cat;
import com.polymorphism.vo.Dog;
import com.polymorphism.vo.Duck;
import com.polymorphism.vo.Employee;
import com.polymorphism.vo.Person;
import com.polymorphism.vo.Snake;
import com.polymorphism.vo.Student;
import com.polymorphism.vo.Teacher;

public class polymorphismController {
	
//	private Student s;
//	private Employee e;
//	private Teacher t;
	
	// person 을 전부 상속받고 있으니까 person만 선언해서 응용할 수 있음..
	private Person p;
//	
//	public polymorphismController(Person p) {
//
//	}
	
	public void basicPolymorphism() {
		// 기본 다형성 적용해보자..
		// 다형성은 클래스간 상속관계에 있을때 부모클래스의 타입으로 선언된 변수에 자식클래스를 생성한 객체가 저장되는 것.
		
		Person p = new Person();
		Student s = new Student();
		Employee e = new Employee();
		
		
		// 클래스명은 Student로 나온다..
		// 이 상태에선 getter, setter 접근이 현재는 안됨...
		// upCasting - 부모클래스 생성후 자식클래스 넣으면 들어감
		Person p2 = new Student("유병승", 19, 180.5, 5, 3);
		// 부모타입에  저장된 자식객체는 부모클래스의 멤버들만 접근이 가능해짐... * 자식의 멤버는 접근이 불가능하다.. *
		System.out.println(p2.getName());
	
		p2 = new Employee("박세현", 28, 190.5, 200, 0.3);
		System.out.println(p2.getName());
		
		
		// 그렇다면 자식타입의 멤버에 접근하려고 할때는 어떻게 ..?
		Employee e2 = (Employee)p2;
		System.out.println(e2.getSalary());
		
		// 이게 안되는 이유는 형 변환보다 접근연산의 우선순위가 높기때문..
		//(Employee)p2.getSalary();
		
		// 이렇게해줘야함
		//((Employee)p2).getSalary();
		
		// Object type의 변수는 java에 사용하는 모든 클래스의 객체를 저장할 수 있다.
//		Object o = new Student();
//		o = new Teacher();
//		o = new Employee();
//		o = new Person();
//		o = new Scanner(System.in);
//		o = new String();
//		printObject(new Employee("유병승", 19, 180.5, 200, 3.5));
//		printObject(new Student("유병승", 19, 180.5, 200, 5));
//		printObject(new String("한개로 다 처리하자"));
		
		
		// instanceof 연산자를 이용하면 타입을 확인할 수 있음.
		
		printObject(new Student("유병승", 19, 180.5, 200, 5));
		printObject(new Employee("유병승", 19, 180.5, 200, 3.5));
		
			
		// equals Override
		 Student s4 = new Student("유병승", 19, 180.5, 5, 3);
		 Student s5 = new Student("유병승", 19, 180.5, 5, 3);
		 
		 System.out.println(s4.equals(s5));
		
		// 자식타입 클래스 변수에 부모타입의 객체를 저장할 수 는 없음..
		// Student s4 = new Person();
		
		// 부모타입으로 선언된 변수에 저장된 데이터 타입확인하기..
		
	}
	
	// 객체를 출력하는 메소드 구현하기
//	public void printObject(Person p) {
//		
//	}
//	
//	public void printObject(Student s) {
//		
//	}
//	
//	public void printObject(Teacher t) {
//		
//	}
//	
//	public void printObject(Employee e) {
//		
//	}
	//이렇게 해야되는데 Object 를 이용하면 .. ?
	
	public void printObject(Person o) {
		// 사람이면 이름, 나이, 키
		if (o instanceof Student) {
			Student s = (Student)o;
			System.out.println(s.getName() + " " + s.getAge() + " " +s.getGrade() + " " + s.getClassNumber());
		} else if (o instanceof Employee) {
			Employee e = (Employee)o;
			System.out.println(e.getName() + " " + e.getAge() + " " +e.getSalary() + " " + e.getBonus());
		} else {
			
		}
		
	}
	
	
	public void dynamicBindTest() {
		// 메소드 동적 바인딩
		// 부모클래스 타입에 저장된 자식클래스 객체가 있을때
		// 부모메소드를 오버라이드한 메소드는 형변환 없이 클래스의 메소드가 호출되는 것.
		
		// 처음엔 Person 으로 읽지만 값이 Student이므로 Student의 toString을 실행했음.
		Person p = new Student("유병승", 19, 180.5, 1, 3);
		
		// p.toString();
		System.out.println(p);
		
	}
	
	public void animal() {		
		totalBark(new Cat());
		totalBark(new Dog());
		totalBark(new Duck());
		totalBark(new Snake());
	}
	
	// 동적 바인딩...
	public void totalBark(Animal a) {
		a.bark();
	}
	
	public void polyArrayTest() {
		// 학생, 사원, 선생관리
		int personCount = 0;
		
		Student[] students = new Student[] {
			new Student("유병승", 19, 180.5, 1, 3),	
			new Student("유병승1", 19, 180.5, 1, 3),	
			new Student("유병승2", 19, 180.5, 1, 3)	
		};
		Employee[] employees = new Employee[] {
			new Employee(),
			new Employee(),
			new Employee()
		};
		Teacher[] teachers = new Teacher[10];
		// 위에처럼 각각 해야하는걸 아래처럼 처리할 수 있음
		
		
		Person[] persons = new Person[30];
		persons[0] = new Student("유병승", 19, 180.0, 5 ,3);
		persons[1] = new Employee("유병승", 19, 180.0, 5 ,3.5);
		persons[2] = new Teacher();
		persons[3] = new Student("이순신", 55, 163.2, 6, 2);
		
		personCount = 0;
		for(int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				personCount++;
			}
		}
		System.out.println(personCount);
		
		Animal[] animals = new Animal[10];
		animals[0] = new Dog("뽀삐", "남");
		animals[1] = new Cat("야옹", "여");
		animals[2] = new Snake();
		animals[3] = new Dog("꽥꽥이", "남");
		System.out.println("관리되는 동물 울음소리 출력...");
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null) {
				
				if (animals[i] instanceof Dog) {
					animals[i].bark();
				}
				
			}
		}
		
		
	}
	
}
