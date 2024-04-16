package com.javaex.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {

	public static void main(String[] args) {
		//	내 PC의 로컬 IP
		printLocalIp();
		//	서버 IP (naver, google) 
		printSeverIp("www.naver.com");
		printSeverIp("www.google.com");
	}

	private static void printLocalIp( ) {
		//	local loop back: 127.0.0.1
		//	PC : IP
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("IP Address:" + local.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	private static void printSeverIp(String hostName) {
		try {
			InetAddress [] hosts = InetAddress.getAllByName(hostName);
			for (InetAddress remote: hosts) {
				System.out.println(hostName + " -> IP Address:" + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
