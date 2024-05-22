package entities;

import java.util.Random;

public class Enemy extends Body{
    public Enemy(){
        setDefaultValues();
    }

    @Override
    public void setDefaultValues(){
        Random random = new Random();
        x = random.nextInt(20) * tileSize;
        y = random.nextInt(20) * tileSize;
    }
}
