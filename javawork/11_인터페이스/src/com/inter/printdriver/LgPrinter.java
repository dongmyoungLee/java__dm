package com.inter.printdriver;

import com.inter.common.PrintDriver;

public class LgPrinter implements PrintDriver {
	
	public void printLG() {
		System.out.println("LG 프린터 인쇄하는 로직....");
	}
	
	@Override
	public void print() {
		printLG();
	}
}
