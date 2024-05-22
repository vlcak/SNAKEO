package entities;

import main.GameFrame;
import main.GamePanel;
import main.KeyReader;

public class Head {
    GamePanel gamePanel;
    int tileSize = 48;
    int width = tileSize;
    int height = tileSize;
    int x;
    int y;



    KeyReader keyReader = new KeyReader();


    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public Head(KeyReader keyReader){
        this.keyReader = keyReader;
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 2 * tileSize;
        y = 2 * tileSize;
    }
    public void update(){
        if(keyReader.upPressed == true){
            y -= tileSize;
        }
        if(keyReader.downPressed == true){
            y += tileSize;
        }
        if(keyReader.leftPressed == true){
            x -= tileSize;
        }
        if(keyReader.rightPressed == true){
            x += tileSize;
        }
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getTileSize() {
        return tileSize;
    }

}
