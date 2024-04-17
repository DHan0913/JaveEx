package com.javaex.network.echoserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;

//	Server.java로 부터 통신용 Socket
public class ServerThread extends Thread {
	// 필드
	private Socket socket; // ServerSocket으로부터 발급된 통신용 소켓
	private String clientInfo;

	// 생성자
	public ServerThread(Socket socket) {
		this.socket = socket;

	}

	@Override
	public void run() {
		// 클라이언트 접속시의 처리 로직
		try {
			// 클라이언트 IP, 포트 확인
			InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			clientInfo = socketAddress.getAddress() + ":" + socketAddress.getPort();
			System.out.println("[클라이언트 " + clientInfo + "가 연결되었습니다.");
			// 클라이언트로부터 message 수신
			InputStream is = socket.getInputStream();
			Reader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			// Echo back을 위한 Stream 생성
			OutputStream os = socket.getOutputStream();
			Writer osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			// 메시지 수신, 전달 받은 메시지를 Echo back
			String message;

			while (true) {
				// 메시지 수신
				message = br.readLine();

				if (message == null) {
					System.out.println(clientInfo + "[접속 종료되었습니다.]");
					break;
				}

				System.out.println(clientInfo + ":" + message);
				// 전달 받은 데이터를 Echo Back
				System.out.println("Echo Back to" + clientInfo);
				bw.write("[Echo:]" + message);
				bw.newLine();
				bw.flush();
			}

			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}