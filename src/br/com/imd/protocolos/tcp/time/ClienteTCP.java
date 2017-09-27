package br.com.imd.protocolos.tcp.time;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	static Scanner leitorTeclado = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		String mensagem = "";
		mensagem = "Manda a hora aí!";				
		outBytes.write(mensagem.getBytes());		
		System.out.println("Mensagem enviada para servidor!");
		
		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		int data = inBytes.readInt();
		System.out.println("Segundos enviados pelo servidor: " + data);			
		
		socket.close();
	}
}
