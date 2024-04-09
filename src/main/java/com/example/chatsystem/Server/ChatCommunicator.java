package com.example.chatsystem.Server;

import com.google.gson.Gson;

import java.io.File;
import java.net.Socket;

public class ChatCommunicator implements Runnable {
    private final Socket socket;
    private final UDPBroadcaster broadcaster;
    private final Gson gson;

    private FileLog fileLog;
    private File file;
    private final PeopleLog peopleLog;
    private String username;

    public ChatCommunicator(Socket socket, UDPBroadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();

        this.peopleLog = PeopleLog.getInstance();
        this.file = new File("src/main/java/main/chatsystem/File/ChatLog");
        this.fileLog = FileLog.getInstance(file);
    }

    @Override
    public synchronized void run() {
        Gson gson = new Gson();
        try {
            while (true) {
                BufferedReader reader = StreamsFactory.createReader(socket);
                PrintWriter writer = StreamsFactory.createWriter(socket);
                String firstReply = reader.readLine();

                if (firstReply.equals("connect")) {
                    System.out.println("CONNECTED");
                    fileLog.log("User from " + socket.getInetAddress() + " has connected.");
                    writer.println("login required");
                    writer.flush();
                    String loginData = reader.readLine();
                    try {
                        User login = gson.fromJson(loginData, User.class);
                        username = login.getNickname();
                        if (!login.getNickname().isEmpty() || !login.getPassword().isEmpty())
                        {
                            writer.println("Approved");
                            System.out.println("Logged successfully");
                            writer.flush();

                            Message message = new Message(username + " has joined the chat");
                            String joinBroadcast = gson.toJson(message);
                            broadcaster.broadcast(joinBroadcast); //User data in broadacaster



                            fileLog.log(socket.getInetAddress() + " User " + login.getNickname() + " has joined the chat.");
                        }
                        else
                        {
                            writer.println("Disapproved");
                            System.out.println("Logging procedure failure");
                            writer.flush();
                        }
                    }
                    catch (JsonSyntaxException e)
                    {
                        writer.println("Disconnected");
                        writer.flush();
                        e.printStackTrace();
                    }
                }
                if (firstReply.equals("Disconnect"))
                {

                    writer.println("Disconnected");
                    writer.flush();

                    String leftBroadcast = reader.readLine();
                    broadcaster.broadcast(leftBroadcast);

                    fileLog.log(socket.getInetAddress() + " User " + username + " has left the chat.");
                    break;
                }
                if (firstReply.equals("Send message")) {
                    writer.println("Provide message content");
                    writer.flush();
                    String messageContent = reader.readLine();
                    Message jSonMessage = gson.fromJson(messageContent, Message.class);
                    broadcaster.broadcast(messageContent);

                    fileLog.log(socket.getInetAddress() + " User " + username + " has sent a message: "+jSonMessage.getMessage());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}