// ChatClient.java
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            Thread messageThread = new Thread(new MessageHandler(reader));
            messageThread.start();

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true) {
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MessageHandler implements Runnable {
        private BufferedReader reader;

        public MessageHandler(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
