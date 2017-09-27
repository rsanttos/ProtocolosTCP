package br.com.imd.protocolos.tcp.echo;

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

		System.out.print("Digite a mensagem para enviar ao servidor: ");
		mensagem = leitorTeclado.nextLine();		
		
		outBytes.write(mensagem.getBytes());
		
		System.out.println("Mensagem enviada para servidor...");
		
		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		byte[] data = new byte[128];
		System.out.println(inBytes.read(data) + " bytes recebidos...");
		String rcvdMessage = new String(data).trim();
		System.out.println(rcvdMessage);			
		
		socket.close();
	}
}
