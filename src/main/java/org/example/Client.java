package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //remote socket
            Socket socket = new Socket("localhost", 3000);

            //request to the server
            String message = "This is client side message";

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            //send the data
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message1 = dataInputStream.readUTF();
            System.out.println(message1);

            //connection close
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
