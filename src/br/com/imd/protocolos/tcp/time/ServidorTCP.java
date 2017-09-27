package br.com.imd.protocolos.tcp.time;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {

		System.out.println("Servidor em execução...");
		while (true) {
			ServerSocket connectionSocket = new ServerSocket(7777);
			System.out.println("Aguardando conexão do cliente...");
			Socket socket = connectionSocket.accept();
			System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado!");

			DataInputStream inBytes = new DataInputStream(socket.getInputStream());
			byte[] data = new byte[128];
			inBytes.read(data);
			String mensagemRecebida = new String(data).trim();
			System.out.println("Cliente diz: " + mensagemRecebida);

			Instant instant = Instant.now();
			long timeStampSeconds = instant.getEpochSecond();

			DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
			outBytes.writeInt((int) timeStampSeconds);

			System.out.println("Timestamp: " + timeStampSeconds + " enviado para o cliente!");

			socket.close();
			connectionSocket.close();
		}
	}
}
