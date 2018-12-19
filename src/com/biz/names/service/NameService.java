package com.biz.names.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.biz.names.vo.FullNameVO;

public class NameService {

	List<String> firstList;
	List<String> sndList;
	
	List<FullNameVO> fNameList;
	
	String fstFile;
	String sndFile;
	String printFile;
	
	public NameService(String fstFile, String sndFile, String printFile) {
		firstList = new ArrayList();
		sndList = new ArrayList();
		fNameList = new LinkedList(); 		//기능은 같으나 지우고 다시쓰는게 반복되면 반복될수록 LinkedList가 더 효율적이다.
		this.fstFile = fstFile;
		this.sndFile = sndFile;
		this.printFile = printFile;
	}
	
	
	public void readFirstFile() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(fstFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String readF = br.readLine();
				if(readF == null) break;
				String[] splitF = readF.split(":");
//				일부 특수문자는 단독으로 split가 안되는 것들이 있다. 대표적으로 (), ! 등의 문자들은 split이 안되는데 이런 경우 \를 두개(\\)포함하면 가능
				String[] hanN = splitF[1].split("\\(");
				
				firstList.add(hanN[0]);	
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void readSndFile() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(sndFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String readF = br.readLine();
				if(readF == null) break;
				sndList.add(readF);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void makeFullName(int intN) {
		fNameList.clear();
		
		for(int i = 0 ; i < intN ; i ++) {
			int fstPos = (int)(Math.random()*firstList.size());
			int sndPos = (int)(Math.random()*sndList.size());
			
			FullNameVO vo = new FullNameVO();
			String fName = firstList.get(fstPos); //.substring(0, 1);
			String sName = sndList.get(sndPos);
			vo.setStr1stname(fName);
			vo.setStr2ndname(sName);
			
			fNameList.add(vo);
		}
	}
	
	
	public void view() {
		System.out.println("==================");
		System.out.println("한국인 이름들");
		System.out.println("==================");
		for(FullNameVO v : fNameList) {
			System.out.println(v.getStr1stname() + v.getStr2ndname());
		}
	}
	
	
	public void printWriter() {
		PrintWriter pw ;
		
		try {
			pw = new PrintWriter(printFile);
			
			for(FullNameVO v : fNameList) {
				pw.println(v.getStr1stname() + v.getStr2ndname());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void printWriter01(String pF) {
		PrintWriter pw ;
		
		try {
			pw = new PrintWriter(pF);
			
			for(FullNameVO v : fNameList) {
				pw.println(v.getStr1stname() + v.getStr2ndname());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장완료");
	}
	
	
	public void menu(String File) {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름생성개수 >> ");
		String strC = scan.nextLine();
		int Num = Integer.valueOf(strC);
		while(true) {
			System.out.println("=======================================");
			System.out.println("menu : 화면출력(1),  파일저장(2),  종료(0)");
			System.out.println("=======================================");
			System.out.print(">> ");
			String strCount = scan.nextLine();
			if(strCount.equals("0")) return;
			
			this.makeFullName(Num);
			if(strCount.equals("1")) this.view();
			if(strCount.equals("2")) {
				System.out.print("저장할 파일명 >> ");
				String ScanName = scan.nextLine();
				this.printWriter01(File + ScanName + ".txt");
			}
		}
	}
	
}
