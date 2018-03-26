import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class LogIn extends JFrame {
    private JTable tableOfUsers;
    private JPanel listOfUsersPanel;
    private JScrollPane skrolpanel;
    private JFrame frameForTable;
    private JMenuBar menuBar;


    public LogIn()
    {
        frameForTable=new JFrame("Tabelka");
        frameForTable.setContentPane(listOfUsersPanel);

        frameForTable.setVisible(true);
        frameForTable.pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Program");
        JMenu menu1=new JMenu("Praca");
        menuBar.add(menu1);
        menuBar.add(menu);
        JMenuItem item1=new JMenuItem("Dodaj");
        JMenuItem item = new JMenuItem("Zamknij");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Dodaj dodaj=new Dodaj((DefaultTableModel)(LogIn.this.tableOfUsers.getModel()));


            }
        });
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(item);
        menu1.add(item1);
        frameForTable.setJMenuBar(menuBar);




        DefaultTableModel model=new DefaultTableModel();
        tableOfUsers.setFillsViewportHeight(true);
        tableOfUsers.setAutoCreateColumnsFromModel(true);
        tableOfUsers.setPreferredScrollableViewportSize(new Dimension(550, 200));
        model.addColumn("Nazwa studenta");
        model.addColumn("Temat pracy");
        model.addColumn("Stron pracy");
        model.addColumn("Nazwa promotora pracy");
        model.addColumn("Ocena promotora pracy");
        model.addColumn("Nazwa recenzenta pracy");
        model.addColumn("Ocena recenzenta pracy");


        tableOfUsers.setModel(model);




    }


}

