package main;

import entities.Body;
import entities.Enemy;
import entities.Head;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    KeyReader keyReader = new KeyReader();
    Head head = new Head(keyReader);
    ArrayList<Body>bodies = new ArrayList<>();
    Enemy enemy = new Enemy();
    public int tileSize = 48;
    public int width = 20 * tileSize;
    public int height = 20 * tileSize;
    public boolean timeforNewBody = false;
    int bodycount = 0;
    Font font = new Font("Aptos", Font.BOLD,24);
    public int score = 0;
    Thread gameThread;
    int fps = 8;
    int gameState = 1;

    public GamePanel(){
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.GRAY);
        addKeyListener(keyReader);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(gameState == 2){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for(int i = 0; i< width; i+= tileSize){
                g.drawLine(i,0,i,height);
                g.drawLine(0,i,width,i);
            }
            g.setColor(Color.green);
            for (Body body: bodies) {
                g.fillRect(body.getX(), body.getY(), body.getWidth(), body.getHeight());
            }
            g.setFont(font);
            g.setColor(Color.PINK);
            g.drawString("Máš "+ Integer.toString(score)+ "slimáků ",100,80);
            g.setColor(Color.green);
            g.fillRect(head.getX(),head.getY(),head.getWidth(),head.getHeight());
            g.setColor(Color.red);
            g.fillRect(enemy.getX(), enemy.getY(),enemy.getWidth(),enemy.getHeight());
            g.setColor(Color.green);


        }
        if(gameState == 1){
            g.setFont(font);
            g.drawString("PPRESS SPACE TO START", 96, 400);
        }

    }
    public void update(){
        if(gameState == 2 && keyReader.wasAction()){
            followHead();
            head.update();
            checkForCollision();
        }
        else if(keyReader.startGame == true){
            gameState = 2;
        }
    }
    public void initializeBody(){
        if(timeforNewBody == true){
            if(keyReader.upPressed == true){
                bodies.add(new Body(enemy.getX(),enemy.getY()));
                bodycount++;
                timeforNewBody = false;

            }
        }

    }
    public void followHead(){
        int previsousX = head.getX();
        int previsousY = head.getY();
        int tempX = 0, tempY = 0;
        for (Body body:bodies){
            tempX = body.getX();
            tempY = body.getY();
            body.setX(previsousX);
            body.setY(previsousY);
            previsousX = tempX;
            previsousY = tempY;
        }
    }
    public void checkForCollision(){
        if(head.getX() == enemy.getX() && head.getY() == enemy.getY()){
            bodies.add(new Body(enemy.getX(), enemy.getY()));
            enemy.setDefaultValues();
            score++;
            bodycount++;
        }
        if(head.getX() + tileSize > width){
            head.setX(head.getX() - head.getTileSize());
        }
        if(head.getX() - tileSize < -tileSize) {
            head.setX(head.getX() + head.getTileSize());
        }
        if(head.getY() - tileSize < -tileSize) {
            head.setY(head.getY() + head.getTileSize());
        }
        if(head.getY() + tileSize > height) {
            head.setY(head.getY() - head.getTileSize());
        }
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
}
