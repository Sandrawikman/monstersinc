package MonstersInc;

import java.util.ArrayList;

public class Board {
    private int sizeXDimension;
    private int sizeYDimension;
    private int numberOfMonsters;
    private ArrayList<Monster> monsters;

    public Board(int x, int y) {
        setSizeXDimension(x);
        setSizeYDimension(y);
    }

    public int getSizeXDimension() {
        return sizeXDimension;
    }

    public void setSizeXDimension(int sizeXDimension) {
        if (sizeXDimension < 1) {
            this.sizeXDimension = 1;
        } else
            this.sizeXDimension = sizeXDimension;
    }

    public int getSizeYDimension() {
        return sizeYDimension;
    }
    private void setupPlayers(int numberOfMonsters){
        //run once at start of new game
        monsters = new ArrayList<>();
        Player player = new Player();
        setupMonsters(numberOfMonsters);

    }
    private void setupMonsters(int number){
        //run once at start of new game
        //create one or many monsters
        for(int i = 0; i < number; i++){
            Monster monster = new Monster();
            monsters.add(monster);
        }
        numberOfMonsters = number;
    }

    public void setSizeYDimension(int sizeYDimension) {
        if (sizeYDimension < 1) {
            this.sizeYDimension = 1;
        } else {
            this.sizeYDimension = sizeYDimension;
        }

    }
    public int getNumberOfMonsters(){
        return numberOfMonsters;
    }
}
