package MonstersInc;

public class Monster {
    private int xPos;
    private int yPos;
    private char look = '\u058e';


    public Monster(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    public int getyPos() {
        return yPos;
    }
    public char getLook(){
        return look;
    }

    public void setyPos(int change) {
        this.yPos += change;
    }
    public int getxPos(){
        return xPos;
    }
    public void setxPos(int change){
        this.xPos += change;
    }

    @Override
    public String toString(){
        return "This monster is on x: " + getxPos() + " and y: " + getyPos();
    }
}
