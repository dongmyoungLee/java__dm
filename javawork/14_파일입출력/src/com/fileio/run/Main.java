package com.fileio.run;

import com.fileio.controller.FileIOController;
import com.fileio.controller.FileStreamController;

public class Main {

	public static void main(String[] args) {
		FileIOController fic = new FileIOController();
		//fic.basicFile();	
		//fic.fileManage();
		
		FileStreamController fsc = new FileStreamController();
//		fsc.fileSave();
//		fsc.loadFile();
//		fsc.saveFileStr();
//		fsc.loadFileStr();
		fsc.memoFile();
		fsc.memoLoad();
		
	}

}
