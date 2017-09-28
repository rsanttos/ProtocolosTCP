package br.com.imd.protocolos.tcp.portscanner.remoto;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RemotePortScanner {

	public static int porta = 1;
	public static int portaFinal = 1024;
	public static String enderecoRemoto = "";
	public static String mensagemErroTimeOut = "Connection timed out: connect";
	public static String mensagemErroEnderecoEmUso = "Address already in use: JVM_Bind";
	public static String mensagemErroConexaoRecusada = "Connection refused: connect";
	
	static Scanner leitorTeclado = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Digite o endereço remoto a ser escaneado: ");
		enderecoRemoto = leitorTeclado.nextLine();	
		System.out.println("--> Iniciando escaneamento remoto de portas.");
		while (porta <= portaFinal) {
			try {
				Socket socket = new Socket(enderecoRemoto, porta);
			} catch (Exception e) {			
				if(e.getMessage().equals(mensagemErroConexaoRecusada)) {
					System.out.println("Conexão recusada para a porta: " + porta);					
				} else if (e.getMessage().equals(mensagemErroEnderecoEmUso)) {
					System.out.println("Porta " + porta + " está em uso!");					
				} else if (e.getMessage().equals(mensagemErroTimeOut)) {
					System.out.println("Timeout para a porta: " + porta);					
				}
			}
			
			porta++;
		}
		
		System.out.println("--> Fim do escaneamento.");
	}
}
