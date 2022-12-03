package com.inter.run;

import com.inter.controller.PrinterController;
import com.inter.printdriver.LgPrinter;
import com.inter.printdriver.SamsungPrinter;

public class PrinterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	
		new PrinterController(new SamsungPrinter()).printData();
		
		new PrinterController(new LgPrinter()).printData();
	}

}
