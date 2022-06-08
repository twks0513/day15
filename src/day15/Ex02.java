package day15;

import java.util.Scanner;

class A02 extends Thread{
	public void run() {
		for(;;) {
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("A02 : ");
		}
	}
	
}

public class Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String msg;
		
		A02 a = new A02();
		a.setDaemon(true);
		a.start();
		while(true) {
			System.out.println("입력");
			msg = scan.next();
			System.out.println("출력 : "+msg);
			//a.run();
		}
	}
}
