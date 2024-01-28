package lk.ijse.controller;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    private Socket socket;
    private ArrayList<ClientHandler> clientList;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket, ArrayList<ClientHandler> clientList) throws IOException {
        this.socket = socket;
        this.clientList = clientList;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true){
                String message = in.readLine();
                for (ClientHandler clientHandler : clientList){
                    clientHandler.out.println(message);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
