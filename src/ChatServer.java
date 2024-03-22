// ChatServer.java
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static int PORT = 12345;
    private static HashSet<PrintWriter> clientOutputStreams = new HashSet<>();
    private static HashMap<PrintWriter, String> connectedUsers = new HashMap<>();
    private static int userCount = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println("Server started...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                    clientOutputStreams.add(writer);

                    Thread listenerThread = new Thread(new ClientHandler(clientSocket, writer));
                    listenerThread.start();
                }
            } catch (BindException e) {
                System.out.println("Port " + PORT + " already in use. Trying next one.");
                PORT++;
                continue; // Try next port number
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String userName;

        public ClientHandler(Socket socket, PrintWriter writer) {
            try {
                clientSocket = socket;
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                this.writer = writer;
                userName = "User" + ++userCount;
                connectedUsers.put(writer, userName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(connectedUsers.get(writer) + ": " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientOutputStreams.remove(writer);
                connectedUsers.remove(writer);
                System.out.println(connectedUsers.get(writer) + " disconnected.");
            }
        }

        private void broadcast(String message) {
            for (PrintWriter client : clientOutputStreams) {
                client.println(connectedUsers.get(writer) + ": " + message);
                client.flush();
            }
        }
    }
}
