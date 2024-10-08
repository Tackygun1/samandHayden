import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class User_Interface{

    public static void main(String args[]){

        int money = 1000;

        JFrame mainFrame = new JFrame("Main Frame");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setSize(400,400);

        JPanel NPanel = new JPanel();

        JButton butPoker = new JButton("Poker");
        JButton butStocks = new JButton("Stocks");
        JButton butRoulette = new JButton("Roulette");
        JButton butBJ = new JButton("BlackJack");

        NPanel.add(butPoker);//Buttons
        NPanel.add(butStocks);
        NPanel.add(butRoulette);
        NPanel.add(butBJ);

        JPanel SPanel = new JPanel();

        SPanel.add(new JLabel("$"+money));

        mainFrame.add(SPanel, BorderLayout.SOUTH);
        mainFrame.add(NPanel, BorderLayout.NORTH);



        butPoker.addActionListener(new pokerListener());
        butBJ.addActionListener(new BJListener());
        butRoulette.addActionListener(new rouletteListener());
        butStocks.addActionListener(new stocksListener());

        //mainFrame.setLayout(new BorderLayout());
        
        mainFrame.setVisible(true);



    }

    public static class pokerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

                JFrame pokerFrame = new JFrame("Poker");
                pokerFrame.setSize(400, 400);

                JButton button2 = new JButton("Test");

                pokerFrame.getContentPane().add(button2);

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



}
