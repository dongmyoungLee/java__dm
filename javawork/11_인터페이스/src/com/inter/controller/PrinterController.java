package com.inter.controller;

import com.inter.common.PrintDriver;

public class PrinterController {
	
	// printerDriver interface 타입의 driver 멤버변수 선언
	private PrintDriver driver;
	
	// 기본생성자에 파라미터로 printerDriver interface 타입을 받는다. 그리고 멤버변수에 할당.
	public PrinterController(PrintDriver driver) {
		this.driver = driver;
	};
	
	// 할당된 멤버변수의 method 실행
	public void printData() {
		driver.print();
		driver.test();
	}
}
