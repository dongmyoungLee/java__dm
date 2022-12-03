package com.inter.printdriver;

import com.inter.common.PrintDriver;

public class CannonPrinter implements PrintDriver {
	public void printCannon() {
		System.out.println("캐논 프린터 인쇄하는 로직....");
	}
	
	@Override
	public void print() {
		printCannon();
	}
}
