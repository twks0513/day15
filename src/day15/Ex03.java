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
		JFrame frame = new JFrame("����");
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
				System.out.println("1. �α��� 2.���� 3.�α׾ƿ�");
				System.out.print(">>> ");
				ch = scan.nextInt();
				if(ch == 1) {
					login();
				}else if(ch == 2) {
					signin();					
				}else if(ch ==3) {
					System.out.println("�α��� �Ǿ����� �ʽ��ϴ�");
					continue;
				}
			}
		}else if(cookie==1) {
			System.out.println("1.������ 2.�α׾ƿ�");
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
		System.out.print("������ ���̵� �Է� : ");
		id = scan.next();
		System.out.print("��й�ȣ �Է� : ");
		pw=scan.next();
		System.out.println("���� �Ϸ�");
	}
	
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("���̵� : ");
			String loginId= scan.next();
			if(loginId == null||!loginId.equals(id)) {
				System.out.println("���̵� Ʋ�Ƚ��ϴ�");
				break;
			}else {
				System.out.print("��й�ȣ : ");
				String loginPw = scan.next();
				if(loginPw ==null||!loginPw.equals(pw)) {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
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
		System.out.println("���� ����!");
		while(true) {
			System.out.println("==== ȯ���մϴ� ====");
			System.out.println("1.���");
			System.out.println("2.off");
			System.out.print(">>> ");
			int ch2=scan.nextInt();
			if(ch2 ==1) {
				System.out.println("��� ����");
			}else if(ch2 ==2) {
				System.out.println("�������");
				break;
			}
		}
	}
	
	public void logout() {		
		System.out.println("�α׾ƿ��մϴ�");
		if(cookie==1) {
			cookie--;
			}
		display();
	}
	public void mypage() {
		System.out.println("�� ���̵� : "+id);
		System.out.println("�� ��й�ȣ : "+pw);
		
	}
	
}

class B03 extends Thread{

	public String dateset() throws InterruptedException {
		SimpleDateFormat simpl = new SimpleDateFormat("a hh�� mm�� ss��");
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




