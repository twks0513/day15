package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("접속을 기다립니다");
		Socket sock = server.accept();
		System.out.println("접속되었습니다");
		
		InputStream in = sock.getInputStream();
		System.out.println("수신 대기...");
		int readData = in.read();
		System.out.println("수신 데이터 : "+readData);
	}
}
