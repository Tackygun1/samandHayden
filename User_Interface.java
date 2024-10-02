import javax.swing.*;
import java.awt.*;
public class User_Interface{

    public static void main(String args[]){

        JFrame Stocksframe = new JFrame("Stocks");
        //JFrame Pokerframe = new JFrame("Poker");

        Stocksframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Stocksframe.setSize(400,400);
        //Pokerframe.setSize(400, 400);


        //Pokerframe.setVisible(true);

        //JButton button1 = new JButton("Hi");
        //Stocksframe.getContentPane().add(button1);

        Stocksframe.setVisible(true);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Open");

        menuBar.add(fileMenu);


        JMenuItem pokerMenu = new JMenuItem("Poker");
        JMenuItem blackJackMenu = new JMenuItem("BlackJack");

        fileMenu.add(pokerMenu);
        fileMenu.add(blackJackMenu);



        // Text Area at the Center


        JTextArea textArea = new JTextArea();




        //Create the panel at bottom and add label, textArea and buttons


        JPanel panel = new JPanel(); // this panel is not visible in output


        JLabel label = new JLabel("Please Enter Text");


        JTextField textField = new JTextField(15); // accepts upto 15 characters


        JButton btn_send = new JButton("Send");


        JButton btn_reset = new JButton("Reset");


        panel.add(label); // Components Added using Flow Layout


        panel.add(textField);


        panel.add(btn_send);


        panel.add(btn_reset);








        //Adding Components to the frame.


        Stocksframe.getContentPane().add(BorderLayout.SOUTH, panel);


        Stocksframe.getContentPane().add(BorderLayout.NORTH, menuBar);


        Stocksframe.getContentPane().add(BorderLayout.CENTER, textArea);

        Stocksframe.setVisible(true);



    }

}
