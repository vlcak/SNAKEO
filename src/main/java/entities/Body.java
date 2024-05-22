package entities;

public class Body {
    int tileSize = 48;
    int x;
    int y;
    int width = tileSize;
    int height = tileSize;

    public Body(){
        setDefaultValues();
    }

    public Body(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setDefaultValues(){
        x = 0;
        y = 0;
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
