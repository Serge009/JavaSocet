package Socket;

/**
 * Created by 23 on 20.03.14.
 */
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] ar) {
        int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            while (! Thread.currentThread().isInterrupted()) {
                Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
                Thread serverThread = new Thread(new ServerThread(socket));
                serverThread.start();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
