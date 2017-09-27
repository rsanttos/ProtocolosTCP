package br.com.imd.protocolos.tcp.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {

		while (true) {			
			ServerSocket connectionSocket = new ServerSocket(7777);
			System.out.println("Servidor em execução...");
			System.out.println("Aguardando conexão do cliente...");
			Socket socket = connectionSocket.accept();
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado!");
			DataInputStream inBytes = new DataInputStream(socket.getInputStream());
			byte[] data = new byte[128];
			System.out.println(inBytes.read(data) + " bytes recebidos...");
			String rcvdMessage = new String(data).trim();
			System.out.println(rcvdMessage);			
			DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());				
			outBytes.write(rcvdMessage.getBytes());			
			System.out.println("Mensagem enviada para o cliente...");
			socket.close();
			connectionSocket.close();
		}
	}
}
