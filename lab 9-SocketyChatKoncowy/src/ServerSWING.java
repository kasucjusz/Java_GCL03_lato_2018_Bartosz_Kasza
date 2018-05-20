import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ServerSWING extends JFrame implements ActionListener {

    private JButton stopStart;
    public JTextArea chat;
    private JTextField tPortNumber;
    private Server server;


    ServerSWING(int port) {
        super("Server");
        server = null;
        JPanel bottom = new JPanel();

        bottom.add(new JLabel("Insert port: "));
        tPortNumber = new JTextField("  " + port);
        bottom.add(tPortNumber);
        stopStart = new JButton("Start");
        stopStart.addActionListener(this);
        bottom.add(stopStart);
        add(bottom, BorderLayout.SOUTH);



        JPanel center = new JPanel(new GridLayout(1,1));
        chat = new JTextArea(80,80);
        chat.setEditable(false);
        chat.append("Chat room.\n");
        center.add(new JScrollPane(chat));

        add(center);


        setSize(400, 600);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if(server != null) {
            server.stop();
            server = null;
            tPortNumber.setEditable(true);
            stopStart.setText("Start");
            return;
        }
        int port;

        port = Integer.parseInt(tPortNumber.getText().trim());


        server = new Server(port, this);
        new ServerRunning().start();
        stopStart.setText("Stop");
    }


//nie konieczne, ale czemu by nie ;]

    class ServerRunning extends Thread {
        public void run() {
            server.start();
            stopStart.setText("Start");
            tPortNumber.setEditable(true);
            chat.append("Server stopped \n");
            server = null;
        }
    }

}
