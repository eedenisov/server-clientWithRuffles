package main.java;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8091;

        try {
            Socket client = new Socket(host, port);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(client.getOutputStream())), true);
            inMessages(in);

            out.println("Алан");
            inMessages(in);
            inMessages(in);

            out.println("нет");
            inMessages(in);
            inMessages(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inMessages(BufferedReader in) throws IOException {
        String msg = in.readLine();
        System.out.println(msg);
    }
}
