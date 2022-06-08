package day15;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class clock extends Thread{
	public void run() {
		A03 a = new A03();
		B03 b = new B03();
		JFrame frame = new JFrame("연습");
		Container c = frame.getContentPane();
		JLabel label = new JLabel();		
		Font font = new Font(null,0,32);
		label.setFont(font); 
		label.setHorizontalAlignment(JLabel.CENTER);
		
		
		c.add(label);
		
		frame.setLocation(1000,200);
		frame.setPreferredSize(new Dimension(500,200));
		frame.pack();
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i =0; ;i++) {
			String str = null;
			try {
				str = b.dateset();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
			label.setText(str);
		}
	}
}
class A03 extends Thread{
	String id=null,pw=null;
	int cookie=0;
	public void run() {
		display();
	}
	public void display() {
		Scanner scan = new Scanner(System.in);
		int ch;
		if(cookie ==0) {
			while(true) {
				System.out.println("1. 로그인 2.가입 3.로그아웃");
				System.out.print(">>> ");
				ch = scan.nextInt();
				if(ch == 1) {
					login();
				}else if(ch == 2) {
					signin();					
				}else if(ch ==3) {
					System.out.println("로그인 되어있지 않습니다");
					continue;
				}
			}
		}else if(cookie==1) {
			System.out.println("1.내정보 2.로그아웃");
			System.out.print(">>> ");
			ch = scan.nextInt();
			if(ch == 1) {
				mypage();
				display();
			}else if(ch == 2) {
				logout();				
			}
		}
	}
	public void signin() {
		Scanner scan = new Scanner(System.in);
		System.out.print("가입할 아이디 입력 : ");
		id = scan.next();
		System.out.print("비밀번호 입력 : ");
		pw=scan.next();
		System.out.println("가입 완료");
	}
	
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("아이디 : ");
			String loginId= scan.next();
			if(loginId == null||!loginId.equals(id)) {
				System.out.println("아이디가 틀렸습니다");
				break;
			}else {
				System.out.print("비밀번호 : ");
				String loginPw = scan.next();
				if(loginPw ==null||!loginPw.equals(pw)) {
					System.out.println("비밀번호가 틀렸습니다");
					break;
				}else {
					cookie++;
					func();
					display();
				}
			}
		}
	}

	
	public void func() {
		clock c = new clock();		
		c.start();
		Scanner scan = new Scanner(System.in);
		System.out.println("인증 성공!");
		while(true) {
			System.out.println("==== 환영합니다 ====");
			System.out.println("1.기능");
			System.out.println("2.off");
			System.out.print(">>> ");
			int ch2=scan.nextInt();
			if(ch2 ==1) {
				System.out.println("기능 시작");
			}else if(ch2 ==2) {
				System.out.println("기능종료");
				break;
			}
		}
	}
	
	public void logout() {		
		System.out.println("로그아웃합니다");
		if(cookie==1) {
			cookie--;
			}
		display();
	}
	public void mypage() {
		System.out.println("내 아이디 : "+id);
		System.out.println("내 비밀번호 : "+pw);
		
	}
	
}

class B03 extends Thread{

	public String dateset() throws InterruptedException {
		SimpleDateFormat simpl = new SimpleDateFormat("a hh시 mm분 ss초");
		for(int i=0;;i++) {
			Date date = new Date();
			String time = simpl.format(date);
			Thread.sleep(1000);		
			return time;		
		}
	}
}

public class Ex03 {

	public static void main(String[] args) throws InterruptedException {
		A03 a = new A03();
		B03 b = new B03();
		
		
		a.start();
		
		
	}

}




