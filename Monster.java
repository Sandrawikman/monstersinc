package MonstersInc;

public class Monster {
    private int xPos;
    private int yPos;
    private char look;

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    public int getxPos(){
        return xPos;
    }
    public void setxPos(){

    }

    private void move(){

    }
    private void findNextMove(){

    }
    @Override
    public String toString(){
        return "This monster is on x: " + getxPos() + " and y: " + getyPos();
    }
}
