package br.com.imd.protocolos.tcp.time;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.Date;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {

		System.out.println("Servidor em execu��o.");
		while (true) {
			ServerSocket connectionSocket = new ServerSocket(7777);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Aguardando conex�o do cliente...");
			Socket socket = connectionSocket.accept();
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado.");

			DataInputStream inBytes = new DataInputStream(socket.getInputStream());
			byte[] dadosRecedidos = new byte[128];
			inBytes.read(dadosRecedidos);
			String mensagemRecebida = new String(dadosRecedidos).trim();
			System.out.println("Cliente diz: " + mensagemRecebida);

			Instant instant = Instant.now();
			long timeStampSegundos = instant.getEpochSecond();
			
			Date data = new Date((long) (timeStampSegundos * 1000));

			DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
			outBytes.writeInt((int) timeStampSegundos);

			System.out.println("Data " + data + " enviada para o cliente no formato: " + timeStampSegundos);
			System.out.println("--------------------------------------------------------------------");

			socket.close();
			connectionSocket.close();
		}
	}
}
