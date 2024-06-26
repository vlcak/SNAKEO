package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyReader implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, startGame;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            upPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            downPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            leftPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            rightPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            startGame = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            upPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            downPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            leftPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            rightPressed = false;
        }
    }

    public boolean wasAction(){
        return upPressed || downPressed || leftPressed || rightPressed;
    }
}
