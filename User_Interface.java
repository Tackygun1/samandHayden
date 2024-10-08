import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class User_Interface{

    public static void main(String args[]){

        double money = 1000.1;






        JFrame mainFrame = new JFrame("Main Frame");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setSize(400,400);

        JPanel NPanel = new JPanel();

        JButton buttonPoker = new JButton("Poker");
        JButton buttonStocks = new JButton("Stocks");
        JButton buttonRoulette = new JButton("Roulette");
        JButton buttonBJ = new JButton("BlackJack");
        JButton buttonCraps = new JButton("Craps");
        JButton buttonSlots = new JButton("Slots");

        NPanel.add(buttonPoker);//Buttons
        NPanel.add(buttonStocks);
        NPanel.add(buttonRoulette);
        NPanel.add(buttonBJ);
        NPanel.add(buttonCraps);
        NPanel.add(buttonSlots);

        JPanel SPanel = new JPanel();

        SPanel.add(new JLabel("$"+money));

        mainFrame.add(SPanel, BorderLayout.SOUTH);
        mainFrame.add(NPanel, BorderLayout.NORTH);



        buttonPoker.addActionListener(new pokerListener());
        buttonBJ.addActionListener(new BJListener());
        buttonRoulette.addActionListener(new rouletteListener());
        buttonStocks.addActionListener(new stocksListener());
        buttonCraps.addActionListener(new crapsListener());
        buttonSlots.addActionListener(new slotsListener());

        //mainFrame.setLayout(new BorderLayout());
        
        mainFrame.setVisible(true);



    }

    public static class pokerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame pokerFrame = new JFrame("Poker");
            pokerFrame.setSize(400, 400);

            JButton buttonRaise = new JButton("Raise");
            JButton buttonCall = new JButton("Call");
            JButton buttonFold = new JButton("Fold");

            JTextField raiseAmount = new JTextField("0000000");

            JLabel displayMoney = new JLabel("$"+money);

            JPanel NPanel = new JPanel();
            JPanel SPanel = new JPanel();

            NPanel.add(buttonFold);
            NPanel.add(buttonCall);
            NPanel.add(buttonRaise);
            NPanel.add(raiseAmount);//Text field

            SPanel.add();

            pokerFrame.add(NPanel, BorderLayout.NORTH);

            pokerFrame.setVisible(true);


        }
    }
    public static class stocksListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame stocksFrame = new JFrame("Stocks");
            stocksFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            stocksFrame.getContentPane().add(button2);

            stocksFrame.setVisible(true);


        }
    }
    public static class BJListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame BJFrame = new JFrame("Blackjack");
            BJFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            BJFrame.getContentPane().add(button2);

            BJFrame.setVisible(true);


        }
    }
    public static class rouletteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame rouletteFrame = new JFrame("Roulette");
            rouletteFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            rouletteFrame.getContentPane().add(button2);

            rouletteFrame.setVisible(true);


        }
    }
    public static class crapsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame crapsFrame = new JFrame("Craps");
            crapsFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            crapsFrame.getContentPane().add(button2);

            crapsFrame.setVisible(true);


        }
    }
    public static class slotsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame slotsFrame = new JFrame("Slots");
            slotsFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            slotsFrame.getContentPane().add(button2);

            slotsFrame.setVisible(true);
            }
        }









}
