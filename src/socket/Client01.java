package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception{
		Socket sock = new Socket("192.168.7.139",12345);
		OutputStream out = sock.getOutputStream();
		Scanner scan = new Scanner(System.in);
		int sendData;
		System.out.println("숫자 입력");
		sendData = scan.nextInt();
		out.write(sendData);
		System.out.println("데이터를 전송하였습니다.");
	}
}
