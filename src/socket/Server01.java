package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("������ ��ٸ��ϴ�");
		Socket sock = server.accept();
		System.out.println("���ӵǾ����ϴ�");
		
		InputStream in = sock.getInputStream();
		System.out.println("���� ���...");
		int readData = in.read();
		System.out.println("���� ������ : "+readData);
	}
}
