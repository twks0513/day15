package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception{
		while(true) {
			Socket sock = new Socket("192.168.7.6",12345);
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Scanner scan = new Scanner(System.in);
		//int sendData;
		String sendData;
		System.out.println("������ �Է�");
		//sendData = scan.nextInt();
		sendData = scan.next();
		dos.writeUTF(sendData);
		System.out.println("�����͸� �����Ͽ����ϴ�.");
		
		InputStream in = sock.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		System.out.println("���� ���...");
		String readData = dis.readUTF();
		System.out.println("���� ������ : "+readData);
		}
	}
}
