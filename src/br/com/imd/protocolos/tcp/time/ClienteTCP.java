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
		mensagem = "Manda a hora a�!";				
		outBytes.write(mensagem.getBytes());		
		
		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		int milisegundos = inBytes.readInt();
		System.out.println("Timestamp recebido do servidor: " + milisegundos);			
		
		socket.close();
	}
}
