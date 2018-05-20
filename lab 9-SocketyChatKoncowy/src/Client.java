import java.net.*;
import java.io.*;


public class Client  {


    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private ClientSWING clientSWING;

    private String server, username;
    private int port;

    Client(String server, int port, String username, ClientSWING cg) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.clientSWING = cg;
    }

        public void start() {
        try {
            socket = new Socket(server, port);
        }
        catch(Exception ec) {
            display("Error connectiong to server:" + ec);
         }

        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(msg);


        try
        {
            sInput  = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
        }


        new ListenFromServer().start();
        try
        {
            sOutput.writeObject(username);
        }
        catch (IOException eIO) {
            display("Exception doing login : " + eIO);
            disconnect();
        }
    }


    private void display(String msg) {

            clientSWING.textAreForClient.append(msg+" \n");
    }
//
    //
    //
    //DO WYSYLANIA WIADOMOSCI DO SERWERA


    void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        }
        catch(IOException e) {
            display("Exception writing to server: " + e);
        }
    }

    private void disconnect() {
        try {
            if(sInput != null) sInput.close();
        }
        catch(Exception e) {} // not much else I can do
        try {
            if(sOutput != null) sOutput.close();
        }
        catch(Exception e) {} // not much else I can do
        try{
            if(socket != null) socket.close();
        }
        catch(Exception e) {} // not much else I can do

        // inform the GUI
        if(clientSWING != null)
            clientSWING.connectionFailed();

    }

    class ListenFromServer extends Thread {

        public void run() {
            while(true) {
                try {
                    String msg = (String) sInput.readObject();

                        clientSWING.textAreForClient.append(msg);

                }
                catch(IOException e) {
                    display("Logged out : ");
                    if(clientSWING != null)
                        clientSWING.connectionFailed();
                    break;
                }
                catch(ClassNotFoundException e2) {
                }
            }
        }
    }
}
