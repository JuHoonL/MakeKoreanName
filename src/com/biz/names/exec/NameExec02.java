package com.biz.names.exec;

import java.util.Scanner;

import com.biz.names.service.NameService;

public class NameExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fstFile = "src/com/biz/names/한국인성씨.txt";
		String sndFile = "src/com/biz/names/이름리스트.txt"; 
		String printFile = "src/com/biz/names/";
		
		NameService ns = new NameService(fstFile, sndFile, printFile);
		
		ns.readFirstFile();
		ns.readSndFile();
		ns.menu(printFile);
		
		
		
	}

}
