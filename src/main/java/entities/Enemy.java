package entities;

import main.GamePanel;

import java.util.Random;

public class Enemy {
    int tileSize = 48;
    int x;
    int y;
    int width = tileSize;
    int height = tileSize;
    Random random = new Random();
    public Enemy(){
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = random.nextInt(20) * tileSize;
        y = random.nextInt(20) * tileSize;
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
}
