package com.inter.printdriver;

import com.inter.common.PrintDriver;

// printerDriver interface..
public class SamsungPrinter implements PrintDriver {
	public void printSamsung() {
		System.out.println("삼성 프린트 인쇄하는 로직....");
	}
	
	@Override
	public void print() {
		printSamsung();
	}
	
	@Override
	public void test() {
		System.out.println("삼성프린터 재정의 했음");
	}
}
