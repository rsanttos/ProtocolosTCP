package br.com.imd.protocolos.tcp.portscanner.remoto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class RemotePortScanner {

	public static int porta = 1;
	public static int portaFinal = 1024;

	public static void main(String[] args) throws IOException {
		System.out.println("--> Iniciando escaneamento de portas local.");
		while (porta <= portaFinal) {
			try {
				ServerSocket connectionSocket = new ServerSocket();
			} catch (Exception e) {
				System.out.println("Porta " + porta + " está em uso!");
			}
			
			porta++;
		}
		
		System.out.println("--> Fim do escaneamento.");
	}
}
