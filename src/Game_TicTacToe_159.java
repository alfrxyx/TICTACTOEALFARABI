import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  Game_TicTacToe_159 implements ActionListener {

    Random game = new Random();
    JFrame frame = new JFrame();
    JPanel titlep = new JPanel();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean gamee1;

    Game_TicTacToe_159(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setBackground(new Color(25,25,25));
        label.setForeground(new Color(25,25,25));
        label.setFont(new Font("Ink Free",Font.BOLD,75));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Toe");
        label.setOpaque(true);

        titlep.setLayout(new BorderLayout());
        titlep.setBounds(10,10,700,100);

        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(new Color(150,150,150));

        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(label);
        frame.add(titlep,BorderLayout.NORTH);
        frame.add(panel);

        gantian();
    }

    public void actionPerformed(ActionEvent e) {
        for (int j=0; j<9; j++){
            if (e.getSource()==buttons[j]) {
                if (gamee1){
                    if (buttons[j].getText()==""){
                        buttons[j].setForeground(new Color(234, 0, 0));
                        buttons[j].setText("X");
                        gamee1 = false;
                        label.setText("O Turn");
                        check();
                    }
                }
                else
                {
                    if (buttons[j].getText()==""){
                        buttons[j].setForeground(new Color(0,0,25));
                        buttons[j].setText("O");
                        gamee1 = true;
                        label.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void gantian(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (game.nextInt(2)==0){
            gamee1 = true;
            label.setText("X turn");
        }
        else
        {
            gamee1 = false;
            label.setText("O turn");
        }
    }

    public void check(){
        //p1
        if (    (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")   ){
            tidakmenang(0,1,2);
        }
        if (    (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")   ){
            tidakmenang(3,4,5);
        }
        if (    (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")   ){
            tidakmenang(6,7,8);
        }
        if (    (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")   ){
            tidakmenang(0,3,6);
        }
        if (    (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")   ){
            tidakmenang(1,4,7);
        }
        if (    (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")   ){
            tidakmenang(2,5,8);
        }
        if (    (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")   ){
            tidakmenang(0,4,8);
        }
        if (    (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")   ){
            tidakmenang(2,4,6);
        }

        //p2
        if (    (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")   ){
            menang(0,1,2);
        }
        if (    (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")   ){
            menang(3,4,5);
        }
        if (    (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            menang(6,7,8);
        }
        if (    (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")   ){
            menang(0,3,6);
        }
        if (    (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")   ){
            menang(1,4,7);
        }
        if (    (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            menang(2,5,8);
        }
        if (    (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            menang(0,4,8);
        }
        if (    (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")   ){
            menang(2,4,6);
        }

    }

    public void tidakmenang(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int j=0; j<9; j++){
            buttons[j].setEnabled(false);
        }
        label.setText("X menang!!!");
    }

    public void menang(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int j=0; j<9; j++){
            buttons[j].setEnabled(false);
        }
        label.setText("O Menang!!!");
    }
}
