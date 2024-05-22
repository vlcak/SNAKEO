package entities;

import main.GameFrame;
import main.GamePanel;
import main.KeyReader;

public class Head extends Body {
    GamePanel gamePanel;

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

    public int getTileSize() {
        return tileSize;
    }

}
