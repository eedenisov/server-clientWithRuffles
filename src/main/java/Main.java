import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Сервер стартовал");
        int port = 8088;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Клиент зашел на сервер");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())), true);
            out.println("Приветствуем вас на сервере. Напишите свое имя?");
            String msg = in_outMessages(in, out);

            out.println("Вы являетесь ребёнком? (да/нет)");
            in_outMessages(in, out);

            if (msg.equals("нет")) {
                out.println("Добро пожаловать в зону для взрослых!");
            } else if (msg.equals("да")) {
                out.println("Добро пожаловать в зону для детей");
            } else {
                System.out.println("Такой команды не существует");
            }
            in.close();
            out.close();
            System.out.println("Клиент покинул сервер");
        }
    }

    public static String in_outMessages(BufferedReader in, PrintWriter out) throws IOException {
        String msg;
        msg = in.readLine();
        out.println(msg);
        return msg;
    }
}
