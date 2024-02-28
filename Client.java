package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	
	
	@SuppressWarnings("deprecation")
	public Client(String ip,int port) {

		
		
		try {
			
			socket = new Socket(ip,port);
			System.out.println("Conectado!!");
			
			input = new DataInputStream(System.in);
			
			out = new DataOutputStream(socket.getOutputStream());
			
		
		} catch (UnknownHostException e) {
			System.out.println("Host não encontrado");
			
			
		}
		
		catch (IOException e) {
			System.out.println(e);
			
		}
		String line = "Olá Mundo!";
		
		while(!line.equals("over")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
				System.out.println("Enviado!");
			} catch (IOException e) {
				
				System.out.println(e);
			}
		}
		try {
			input.close();
			out.close();
			socket.close();
			System.out.println("Conexão Fechada!");
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
	}
	
	public static void main(String args[]) {
		Client cliente = new Client("127.0.0.1",30000);
	}

}
