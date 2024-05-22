package entities;

import main.GamePanel;
import main.KeyReader;

public class Head extends Body {
    GamePanel gamePanel;

    KeyReader keyReader = new KeyReader();

    public Head(KeyReader keyReader){
        this.keyReader = keyReader;
        setDefaultValues();
    }

    @Override
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

    public int getTileSize() {
        return tileSize;
    }

}
