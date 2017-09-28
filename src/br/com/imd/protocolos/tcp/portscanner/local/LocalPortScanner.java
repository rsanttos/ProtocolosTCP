package br.com.imd.protocolos.tcp.portscanner.local;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {

	public static int porta = 0;
	public static int portaFinal = 65535;
	public static String mensagemErroEnderecoEmUso = "Address already in use: JVM_Bind";

	public static void main(String[] args) throws IOException {
		System.out.println("--> Iniciando escaneamento local de portas.");
		while (porta <= portaFinal) {
			try {
				ServerSocket connectionSocket = new ServerSocket(porta);
			} catch (Exception e) {
				if (e.getMessage().equals(mensagemErroEnderecoEmUso)) {
					System.out.println("Porta " + porta + " está em uso!");
				}
			}

			porta++;
		}

		System.out.println("--> Fim do escaneamento.");
	}
}
