package br.com.imd.protocolos.tcp.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {

		System.out.println("Servidor em execução.");
		while (true) {			
			ServerSocket connectionSocket = new ServerSocket(7777);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Aguardando conexão do cliente...");
			Socket socket = connectionSocket.accept();
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado!");
			DataInputStream inBytes = new DataInputStream(socket.getInputStream());
			byte[] data = new byte[128];
			inBytes.read(data);
			
			String mensagemRecebida = new String(data).trim();
			System.out.println("Mensagem recebida: " + mensagemRecebida);			
			DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());				
			outBytes.write(mensagemRecebida.getBytes());			
			System.out.println("Mensagem retornada para o cliente: " + mensagemRecebida);
			System.out.println("--------------------------------------------------------------------");
			socket.close();
			connectionSocket.close();
		}
	}
}
