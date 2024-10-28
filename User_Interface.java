import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class User_Interface {

    public static void main(String[] args) {
        stocks Game = new stocks(1000.00); // Game object
        double money = Game.getMoney(); // Initial money in the game

        JFrame mainFrame = new JFrame("Main Frame");
        // ICON code
        try {
            Image icon = ImageIO.read(new File("/Users/haydenstreet/IdeaProjects/samandHayden/Drawing-20.sketchpad.png"));
            mainFrame.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 400);

        JPanel NPanel = new JPanel();

        // Create buttons for the different games
        JButton buttonPoker = new JButton("Poker");
        JButton buttonStocks = new JButton("Stocks");
        JButton buttonRoulette = new JButton("Roulette");
        JButton buttonBJ = new JButton("BlackJack");
        JButton buttonCraps = new JButton("Craps");
        JButton buttonSlots = new JButton("Slots");

        // Add buttons to the panel
        NPanel.add(buttonPoker);
        NPanel.add(buttonStocks);
        NPanel.add(buttonRoulette);
        NPanel.add(buttonBJ);
        NPanel.add(buttonCraps);
        NPanel.add(buttonSlots);

        JPanel SPanel = new JPanel();
        SPanel.add(new JLabel("$" + money)); // Display initial money

        mainFrame.add(SPanel, BorderLayout.SOUTH);
        mainFrame.add(NPanel, BorderLayout.NORTH);

        // Add ActionListeners to the buttons
        buttonPoker.addActionListener(new pokerListener());
        buttonBJ.addActionListener(new BJListener());
        buttonRoulette.addActionListener(new rouletteListener());
        buttonStocks.addActionListener(new stocksListener(Game)); // Pass Game object to stocksListener
        buttonCraps.addActionListener(new crapsListener());
        buttonSlots.addActionListener(new slotsListener());

        mainFrame.setVisible(true);
    }

    // Define the pokerListener class
    public static class pokerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame pokerFrame = new JFrame("Poker");
            pokerFrame.setSize(400, 400);

            JButton buttonRaise = new JButton("Raise");
            JButton buttonCall = new JButton("Call");
            JButton buttonFold = new JButton("Fold");

            JTextField raiseAmount = new JTextField("0000000");

            JPanel NPanel = new JPanel();
            NPanel.add(buttonFold);
            NPanel.add(buttonCall);
            NPanel.add(buttonRaise);
            NPanel.add(raiseAmount); // Text field

            pokerFrame.add(NPanel, BorderLayout.NORTH);

            pokerFrame.setVisible(true);
        }
    }

    // Define the BJListener class for Blackjack
    public static class BJListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame BJFrame = new JFrame("Blackjack");
            BJFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");
            BJFrame.getContentPane().add(button2);

            BJFrame.setVisible(true);
        }
    }

    // Define the rouletteListener class
    public static class rouletteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame rouletteFrame = new JFrame("Roulette");
            rouletteFrame.setSize(400, 400);

            JButton button2 = new JButton("Test");
            rouletteFrame.getContentPane().add(button2);

            rouletteFrame.setVisible(true);
        }
    }

    // Define the crapsListener class
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

    // Define the slotsListener class
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

    // Define the stocksListener class
    public static class stocksListener implements ActionListener {
        private stocks game;

        // Constructor that takes the Game object
        public stocksListener(stocks game) {
            this.game = game; // Store the Game object
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame stocksFrame = new JFrame("Stocks");
            stocksFrame.setSize(1000, 1000);

            JButton portfolio = new JButton("Portfolio");
            JButton search = new JButton("Search");
            JButton news = new JButton("News");
            JPanel sideBar = new JPanel();

            sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));

            sideBar.add(portfolio);
            sideBar.add(search);
            sideBar.add(news);

            stocksFrame.getContentPane().add(sideBar, BorderLayout.WEST);
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new FlowLayout());
            stocksFrame.getContentPane().add(contentPanel, BorderLayout.CENTER);

            search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel prompt = new JLabel("Enter Stock Symbol: ");
                    JTextField stockSymbolInput = new JTextField(10); // Text field with 10 columns (width)

                    contentPanel.removeAll(); // Remove any previous content
                    contentPanel.add(prompt);
                    contentPanel.add(stockSymbolInput);

                    contentPanel.revalidate();
                    contentPanel.repaint();

                    JButton submitButton = new JButton("Submit");
                    contentPanel.add(submitButton);

                    submitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String symbol = stockSymbolInput.getText();
                            System.out.println("Searching for stock symbol: " + symbol);
                            displayStockInfo(symbol);
                        }
                    });
                }
            });

            stocksFrame.setVisible(true);
            stocksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void displayStockInfo(String symbol) {
            JFrame stockInfoFrame = new JFrame("Stock Information: " + symbol);
            stockInfoFrame.setSize(400, 600);
            stockInfoFrame.setLayout(new BorderLayout());

            JPanel stockPanel = new JPanel(new GridLayout(3, 1));
            stockPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

            String stockPrice = StocksAPI.getGeneralInfo(symbol, "price");
            String stockDescription = StocksAPI.getGeneralInfo(symbol, "description");

            JLabel stockSymbol = new JLabel(symbol, JLabel.CENTER);
            stockSymbol.setFont(new Font("Arial", Font.BOLD, 30));

            JLabel priceLabel = new JLabel("$" + stockPrice, JLabel.CENTER);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 50));

            JLabel descriptionLabel = new JLabel("<html><div style='text-align: center;'>" + stockDescription + "</div></html>", JLabel.CENTER);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

            stockPanel.add(stockSymbol);
            stockPanel.add(priceLabel);
            stockPanel.add(descriptionLabel);

            JPanel bottomPanel = new JPanel(new BorderLayout());

            JButton buyButton = new JButton("Buy");
            buyButton.setPreferredSize(new Dimension(400, 50));
            buyButton.setBackground(Color.GREEN);
            buyButton.setOpaque(true);
            buyButton.setFont(new Font("Arial", Font.BOLD, 20));
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyStock(symbol, stockPrice);
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stockInfoFrame.dispose(); // Close the window
                }
            });

            bottomPanel.add(buyButton, BorderLayout.CENTER);
            bottomPanel.add(cancelButton, BorderLayout.SOUTH);

            stockInfoFrame.add(stockPanel, BorderLayout.CENTER);
            stockInfoFrame.add(bottomPanel, BorderLayout.SOUTH);

            stockInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            stockInfoFrame.setVisible(true);
        }

        public void buyStock(String symbol, String stockPrice) {
            JFrame buyfield = new JFrame("Buy Stock");
            buyfield.setVisible(true);
            buyfield.setSize(300, 150);
            buyfield.setLayout(new FlowLayout());

            JTextField buyAmount = new JTextField(10);
            JLabel buyLabel = new JLabel("Each stock costs $" + stockPrice + ". Enter amount:");
            JButton confirm = new JButton("Confirm");
            JButton cancel = new JButton("Cancel");

            buyfield.add(buyLabel);
            buyfield.add(buyAmount);
            buyfield.add(confirm);
            buyfield.add(cancel);

            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int amount = Integer.parseInt(buyAmount.getText());
                    double totalCost = amount * Double.parseDouble(stockPrice);

                    if (game.getMoney() >= totalCost) {
                        game.setMoney(game.getMoney() - totalCost); // Deduct money from the Game object
                        System.out.println("You bought " + amount + " shares of " + symbol + ". Total cost: $" + totalCost); // for testing purposes (get rid of print later on)
                        JFrame success = new JFrame("Success!");
                        JLabel successMessage = new JLabel("You bought " + amount + " shares of " + symbol + ". Total cost: $" + totalCost, JLabel.CENTER);
                        success.setSize(600, 100);
                        success.setVisible(true);
                        success.setLocationRelativeTo(null);
                        success.add(successMessage);
                    } else {
                        System.out.println("Not enough money to buy the stocks."); // for testing purposes (get rid of print later on)
                        JFrame error = new JFrame("Error");
                        JLabel errorMessage = new JLabel("!You don't have enough money for this operation!", JLabel.CENTER);
                        error.setSize(400,100);
                        error.setVisible(true);
                        error.setLocationRelativeTo(null); //center on screen
                        error.add(errorMessage);



                    }
                    buyfield.dispose();
                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyfield.dispose();
                }
            });

            buyfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
