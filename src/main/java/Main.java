package main.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сервер стартовал");
        int port = 8091;
        String msg;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())), true);
            out.println("Сервер: Приветствуем вас на сервере. Напишите свое имя?");
            msg = in.readLine();
            out.println("Клиент: " + msg);

            out.println("Сервер: Вы являетесь ребёнком? (да/нет)");
            msg = in.readLine();
            out.println("Клиент: " + msg);

            if (msg.equals("нет")) {
                out.println("Сервер: Добро пожаловать в зону для взрослых!");
            } else if (msg.equals("да")) {
                out.println("Сервер: Добро пожаловать в зону для детей");
            } else {
                System.out.println("Такой команды не существует");
            }
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
