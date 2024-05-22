package entities;

import main.GamePanel;

import java.util.Random;

public class Enemy extends Body{
    Random random = new Random();
    public Enemy(){
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = random.nextInt(20) * tileSize;
        y = random.nextInt(20) * tileSize;
    }
}
