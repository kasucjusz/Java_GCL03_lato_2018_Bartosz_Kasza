import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ClientSWING extends JFrame implements ActionListener {

    private JLabel label;
    private JLabel labelPassword;
    private JTextField forMessages;
    private JTextField tfServer, tfPort;
    private JButton login, logout, echo;
    public JTextArea textAreForClient;
    private JPasswordField passwordField;

    private boolean connected;
    private Client client;
    private int defaultPort;
    private String defaultHost;

    ClientSWING(String host, int port) {

        super("Chat Client");
        defaultPort = port;
        defaultHost = host;



        textAreForClient = new JTextArea("Welcome to the Chat room\n", 80, 80);
        JPanel centerPanel = new JPanel(new GridLayout(1,1));
        centerPanel.add(new JScrollPane(textAreForClient));
        textAreForClient.setEditable(false);
        add(centerPanel, BorderLayout.CENTER);





        echo=new JButton("Echo");
        echo.addActionListener(this);
        login = new JButton("Login");
        login.addActionListener(this);
        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setEnabled(false);




        JPanel southPanel = new JPanel();

        label = new JLabel("Username", SwingConstants.CENTER);
        labelPassword=new JLabel("Password",SwingConstants.LEFT);
        southPanel.add(labelPassword);
        passwordField=new JPasswordField("zzzzzzzzzz");
        southPanel.add(passwordField);


        southPanel.add(label);
        forMessages = new JTextField("Anonymous",SwingConstants.RIGHT);
        forMessages.setBackground(Color.WHITE);
        southPanel.add(forMessages);

        southPanel.add(echo);
        southPanel.add(login);
        southPanel.add(logout);


        add(southPanel, BorderLayout.SOUTH);


        JPanel northPanel = new JPanel(new GridLayout(2,1));
        JPanel serverAndPort = new JPanel(new GridLayout(1,5, 1, 3));
        tfServer = new JTextField(host);
        tfPort = new JTextField("" + port);
        tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

        serverAndPort.add(new JLabel("Server Address:  "));
        serverAndPort.add(tfServer);
        serverAndPort.add(new JLabel("Port Number:  "));
        serverAndPort.add(tfPort);
        serverAndPort.add(new JLabel(""));
        northPanel.add(serverAndPort);



        add(northPanel, BorderLayout.NORTH);






        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        forMessages.requestFocus();

    }


    void connectionFailed() {
        login.setEnabled(true);
        logout.setEnabled(false);
        label.setText("Username");
        forMessages.setText("Bartek");
        tfPort.setText("" + defaultPort);
        tfServer.setText(defaultHost);
        tfServer.setEditable(false);
        tfPort.setEditable(false);
        forMessages.removeActionListener(this);
        connected = false;
    }


    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == logout) {
            client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
            return;
        }
        if(o==echo)
        {
            client.sendMessage(new ChatMessage(ChatMessage.ECHO,"ECHO"));
            return;
        }


        if(connected) {
            client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, forMessages.getText()));
            forMessages.setText("");
            return;
        }


        if(o == login) {
            String username = forMessages.getText().trim();
            String password = passwordField.getText().trim();
            if (!password.equals("haslo")) {
                textAreForClient.append("WRONG PASSWORD!!!!\n");
            } else {

                connected = true;

                String server = tfServer.getText().trim();

                String portNumber = tfPort.getText().trim();


                int port = Integer.parseInt(portNumber);


                client = new Client(server, port, username, this);

                client.start();

                forMessages.setText("");
                label.setText("Message: ");

                login.setEnabled(false);
                logout.setEnabled(true);
                tfServer.setEditable(false);
                tfPort.setEditable(false);
                forMessages.addActionListener(this);
            }
        }

    }



}
