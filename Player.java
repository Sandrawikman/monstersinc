package MonstersInc;

public class Player {
    private int xPos;
    private int yPos;
    private char look;


    public Player(){
        this.xPos =
    }

    private void move(){

    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    public String toString(){
        return "Player is on x: " + getxPos() + " and y: " + getyPos();
    }
}
