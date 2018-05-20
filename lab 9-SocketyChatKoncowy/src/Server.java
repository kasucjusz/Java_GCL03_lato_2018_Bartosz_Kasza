import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    private static int uniqueId;
    private ArrayList<ClientThread> al;

    private ServerSWING serverSWING;

    private int port;
    private boolean keepGoing;


    public Server(int port, ServerSWING serverSWING) {
        this.serverSWING = serverSWING;
        this.port = port;

        al = new ArrayList<ClientThread>();
    }

    public void start() {
        keepGoing = true;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);

            while(keepGoing)
            {
                display("Server waiting for Clients on port " + port + ".");

                Socket socket = serverSocket.accept();
                if(!keepGoing)
                    break;
                ClientThread t = new ClientThread(socket);
                al.add(t);
                t.start();
            }
            try {
                serverSocket.close();
                for(int i = 0; i < al.size(); ++i) {
                    ClientThread tc = al.get(i);
                    try {
                        tc.sInput.close();
                        tc.sOutput.close();
                        tc.socket.close();
                    }
                    catch(IOException ioE) {
                    }
                }
            }
            catch(Exception e) {
                display("Exception closing the server and clients: " + e);
            }
        }
        catch (IOException e) {

            display(" Exception on new ServerSocket: ");
        }
    }

    protected void stop() {
        keepGoing = false;

        try {
            new Socket("localhost", port);
        }
        catch(Exception e) {
       }
    }

                                         //wyswietlamy sobie do event logu-------------przerobic zeby bylo tylko jedno okno w serwerze-----na temat tego kto sie podlaczyl it
    private void display(String msg) {


            serverSWING.chat.append(msg + "\n");
    }
    /*
     *  przekazywane sa wiadomosci do wszystkich klientow od wszyskitch klientow
     *
     */
    private synchronized void broadcast(String message) {
        String messageLf = message + "\n";
        serverSWING.chat.append(messageLf);
        //////petla odpowiedzialna za rozsylanie do wszystkich klientow, jesli sie nie uda to usuwamy go z listy
        for(int i = al.size(); --i >= 0;) {
            ClientThread ct = al.get(i);
            if(!ct.writeMsg(messageLf)) {
                ////////////////////////////////jesli nie uda sie to usuwa, ale raczej tak sie nie zdarzy, chyba ze nagle utracilbby polaczenie
                al.remove(i);
                display("Disconnected Client " + ct.username + " removed from list.");
            }
        }
    }

    private synchronized void echo(String message)
    {

        serverSWING.chat.append("From client: "+ message);


    }


    synchronized void remove(int id) {

        if(al.contains(id))
        {
            al.remove(id);
        }
    }

    class ClientThread extends Thread {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String username;
        ChatMessage chatMessage;

        ClientThread(Socket socket) {
            id = ++uniqueId;
            this.socket = socket;
            try
            {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput  = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
                display(username + " just connected.");
            }
            catch (IOException e) {
                display("Exception creating new Input/output Streams: " + e);
                return;
            }

            catch (ClassNotFoundException e) {
            }
        }

        public void run() {
            boolean keepGoing = true;
            while(keepGoing) {
                try {
                    chatMessage = (ChatMessage) sInput.readObject();
                }
                catch (IOException e) {
                    display(username + " Exception reading Streams: " + e);
                    break;
                }
                catch(ClassNotFoundException e2) {
                    break;
                }
                String message = chatMessage.getMessage();

                switch(chatMessage.getType()) {

                    case ChatMessage.MESSAGE:
                        broadcast(username + ": " + message);
                        break;
                    case ChatMessage.LOGOUT:
                        display(username + " disconnected with a LOGOUT message.");
                        keepGoing = false;
                        break;
                    case ChatMessage.ECHO:
                        echo("ECHO");

                }
            }

            remove(id);
            close();
        }

        private void close() {
            try {
                if(sOutput != null) sOutput.close();
            }
            catch(Exception e) {}
            try {
                if(sInput != null) sInput.close();
            }
            catch(Exception e) {};
            try {
                if(socket != null) socket.close();
            }
            catch (Exception e) {}
        }


        private boolean writeMsg(String msg) {
            if(!socket.isConnected()) {
                close();
                return false;
            }
            try {
                sOutput.writeObject(msg);
            }
            catch(IOException e) {
                display("Error sending message to " + username);
                display(e.toString());
            }
            return true;
        }
    }
}