package com.biz.names.exec;

import java.util.Scanner;

import com.biz.names.service.NameService;

public class NameExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String fstFile = "src/com/biz/names/한국인성씨.txt";
		String sndFile = "src/com/biz/names/이름리스트.txt"; 
		String printFile = "src/com/biz/names/한국인이름리스트.txt";
		
		NameService ns = new NameService(fstFile, sndFile, printFile);
		
		ns.readFirstFile();
		ns.readSndFile();
		
		while(true) {
			System.out.println("=======================================");
			System.out.println("menu : 화면출력(1),  파일저장(2),  종료(0)");
			System.out.println("=======================================");
			System.out.print(">> ");
			String strCount = scan.nextLine();
			
			if(strCount.equals("0")) return;
			ns.makeFullName(100);
			if(strCount.equals("1")) ns.view();
			if(strCount.equals("2")) ns.printWriter();
		}
		
	}

}
