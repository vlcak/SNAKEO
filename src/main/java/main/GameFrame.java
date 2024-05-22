package main;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("Chytni se hada");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        gamePanel.startGameThread();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
