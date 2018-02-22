package MonstersInc;

public class Player {
    private int xPos;
    private int yPos;
    private char look;


    public Player(int x, int y, char look){
        this.xPos = x;
        this.yPos = y;
        this.look = look;
    }
    public char getLook(){
        return look;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int change) {
        this.xPos += change;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int change) {
        this.yPos += change  ;
    }
    public String toString(){
        return "Player is on x: " + getxPos() + " and y: " + getyPos();
    }
}
