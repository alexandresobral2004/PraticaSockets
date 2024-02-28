package sockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
	
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	
	
	
	//clasee construtora de ServerSide
	public ServerSide(int port) {
		try {
			
			server = new ServerSocket(port);
			System.out.println("Servidor Iniciado!");
			System.out.println("Aguardando Cliente!");
			socket = server.accept();
			System.out.println("Cliente aceito!");
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String line = "";
			while(!line.equals("over")) {
				try {
					
					line = in.readUTF();
					System.out.println("MSG_Cliente: "+line);
					
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("Fechando Conexão");
			socket.close();
			in.close();;
			
			
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String args[]) {
		
		ServerSide myServer = new ServerSide(30000);
		
		
	}
	
	

}

