package day15;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class A03 extends Thread{
	public void run() {
		Scanner scan = new Scanner(System.in);
		String ch;
		System.out.println("1. 로그인 2.가입 3.로그아웃");
		System.out.print(">>> ");
		ch = scan.next();
	}
}

public class Ex03 {

	public static void main(String[] args) {
		A03 a = new A03();
		JFrame frame = new JFrame("연습");
		Container c = frame.getContentPane();
		JLabel label = new JLabel();
		label.setText("test");
		Font font = new Font("Impact",Font.ITALIC,32);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		
		c.add(label);
		
		frame.setLocation(1000,200);
		frame.setPreferredSize(new Dimension(500,200));
		frame.pack();
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for(int i =0; ;i++) {
			label.setText(i+".Hello");
		}
	}

}




