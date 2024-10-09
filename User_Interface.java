import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class User_Interface {

    public class Global {
        public static double money = 1000.1;
    }

    public static void main(String args[]) {


        JFrame mainFrame = new JFrame("Main Frame");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setSize(600, 400);

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

        SPanel.add(new JLabel("$" + Global.money));

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

    public static class pokerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //double money = 1000.1;

            JFrame pokerFrame = new JFrame("Poker");
            pokerFrame.setSize(400, 400);

            JButton buttonRaise = new JButton("Raise");
            JButton buttonCall = new JButton("Call");
            JButton buttonFold = new JButton("Fold");

            JTextField raiseAmount = new JTextField(7);

            JLabel displayMoney = new JLabel("$" + Global.money);

            JPanel NPanel = new JPanel();
            JPanel SPanel = new JPanel();

            NPanel.add(buttonFold);
            NPanel.add(buttonCall);
            NPanel.add(buttonRaise);
            NPanel.add(raiseAmount);//Text field

            SPanel.add(displayMoney);

            pokerFrame.add(NPanel, BorderLayout.NORTH);
            pokerFrame.add(SPanel, BorderLayout.SOUTH);

            pokerFrame.setVisible(true);


        }
    }

    public static class stocksListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame stocksFrame = new JFrame("Stocks");
            stocksFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            stocksFrame.getContentPane().add(button2);

            stocksFrame.setVisible(true);


        }
    }

    public static class BJListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame BJFrame = new JFrame("Blackjack");
            BJFrame.setSize(450, 400);

            JButton stayButton = new JButton("Stay");
            JButton hitButton = new JButton("Hit");
            JButton splitButton = new JButton("Split");
            JButton DDButton = new JButton("Double Down");
            JButton betButton = new JButton("Bet");

            JPanel NPanel = new JPanel();
            JPanel SPanel = new JPanel();

            JTextField betAmountInput = new JTextField(7);

            JLabel BJMoney = new JLabel("Your total savings: $" + Global.money);

            JLabel BJBet = new JLabel("Your current bet: $0");

            NPanel.add(stayButton);
            NPanel.add(hitButton);
            NPanel.add(splitButton);
            NPanel.add(DDButton);

            SPanel.add(BJMoney);
            SPanel.add(BJBet);
            SPanel.add(betAmountInput);
            SPanel.add(betButton);

            class betAmountListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String betAmountS = (betAmountInput.getText());
                    int betAmount = Integer.parseInt(betAmountS.trim());
                    if (betAmount<Global.money) {
                        Global.money -= betAmount;
                        BJBet.setText("Your current bet: $" + betAmount);
                        BJMoney.setText("Your total savings: $" + Global.money);
                        BJFrame.setVisible(false);
                        SPanel.add(BJBet);
                        SPanel.add(BJMoney);
                        SPanel.add(BJBet);
                        SPanel.add(betAmountInput);
                        SPanel.add(betButton);
                        BJFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Not enough funds");
                    }
                }
            }
            class splitListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }
            class stayListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String betAmountS = (betAmountInput.getText());
                    int betAmount = Integer.parseInt(betAmountS.trim());
                    if (betAmount<Global.money) {
                        Global.money -= betAmount;
                        BJBet.setText("Your current bet: $" + betAmount);
                        BJMoney.setText("Your total savings: $" + Global.money);
                        BJFrame.setVisible(false);
                        SPanel.add(BJBet);
                        SPanel.add(BJMoney);
                        SPanel.add(BJBet);
                        SPanel.add(betAmountInput);
                        SPanel.add(betButton);
                        BJFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Not enough funds");
                    }
                }
            }
            class hitListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }
            class DDListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String betAmountS = (betAmountInput.getText());
                    int betAmount = Integer.parseInt(betAmountS.trim());
                    if (betAmount<Global.money) {
                        Global.money -= betAmount;
                        BJBet.setText("Your current bet: $" + betAmount);
                        BJMoney.setText("Your total savings: $" + Global.money);
                        BJFrame.setVisible(false);
                        SPanel.add(BJBet);
                        SPanel.add(BJMoney);
                        SPanel.add(BJBet);
                        SPanel.add(betAmountInput);
                        SPanel.add(betButton);
                        BJFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Not enough funds");
                    }
                }
            }

            betButton.addActionListener(new betAmountListener());
            hitButton.addActionListener(new hitListener());
            stayButton.addActionListener(new stayListener());
            splitButton.addActionListener(new splitListener());
            DDButton.addActionListener(new DDListener());

            BJFrame.add(NPanel, BorderLayout.NORTH);
            BJFrame.add(SPanel, BorderLayout.SOUTH);

            BJFrame.setVisible(true);



        }
    }


    static class rouletteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame rouletteFrame = new JFrame("Roulette");
            rouletteFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            rouletteFrame.getContentPane().add(button2);

            rouletteFrame.setVisible(true);


        }
    }

    static class crapsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame crapsFrame = new JFrame("Craps");
            crapsFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");

            crapsFrame.getContentPane().add(button2);

            crapsFrame.setVisible(true);


        }
    }

    static class slotsListener implements ActionListener {
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