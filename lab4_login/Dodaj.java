import javax.swing.*;
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


public class Dodaj extends JFrame {
    private JFrame ramka;
    private JPanel panell;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JComboBox comboBox3;
    private JButton addToTable;
    LogIn obiekt;

    public Dodaj ()
    {
        ramka=new JFrame("Uzytkownicy");
        ramka.setContentPane(panell);

        ramka.setVisible(true);
        ramka.pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Program");
        JMenu menu1=new JMenu("Okno");
        menuBar.add(menu1);
        menuBar.add(menu);
        JMenuItem item1=new JMenuItem("Zamknij");
        JMenuItem item = new JMenuItem("Zamknij");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ramka.setVisible(false);

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
        ramka.setJMenuBar(menuBar);


        addToTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String studentName=textField1.getText();
                String tematPracy=textField2.getText();
                String stronPracy=(String)comboBox1.getSelectedItem();
                String nazwaPromotora=textField3.getText();
                String ocenaPromotora=(String)comboBox2.getSelectedItem();
                String nazwaRecenzenta=textField4.getText();
                String ocenaRecenzenta=(String)comboBox3.getSelectedItem();

                model.addRow(new Object[]{studentName,tematPracy,stronPracy,nazwaPromotora,ocenaPromotora,nazwaRecenzenta,ocenaRecenzenta});


            }
        });
    }
    DefaultTableModel model;

    Dodaj(DefaultTableModel model)
    {
        this.model=model;
    }

}