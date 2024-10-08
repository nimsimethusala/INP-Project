package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);

            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");

            //data reading option
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //sout
            String message = dataInputStream.readUTF();
            System.out.println(message);

            String message1 = "Server side message";

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message1);
            dataOutputStream.flush();

            //connection closed
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}