package MonstersInc;

import java.util.ArrayList;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    private Board board;
    private ArrayList<Monster> monsters;
    private Player player;
    private Terminal terminal;

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.run();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private void run() throws InterruptedException{
        createBoard(30, 30);
        setupGame(4);
        playGame();
    }
    private boolean playerHasDied(){
        for(Monster monster : monsters){
            if(monster.getxPos() == player.getxPos() && monster.getyPos() == player.getyPos()){
                return true;
            }
        }
        return false;
    }
    private void endGame(){
        //TODO: print message 'Game over'
        terminal.clearScreen();
        System.exit(0);
    }

    private void playGame ()throws InterruptedException {
        terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
      //  terminal.applyBackgroundColor(Terminal.Color.GREEN);
        terminal.applyForegroundColor(Terminal.Color.GREEN);
        while (true) {
            drawBoard();
            if(playerHasDied()){
                endGame();
                break;
            }
//Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);            //väntar på kommando
            //System.out.println(key.getCharacter() + " " + key.getKind());

            switch(key.getKind())
            {
                case ArrowDown:
                    if (player.getyPos() < board.getSizeYDimension()){
                        player.setyPos(1);
                    } else {
                        player.setyPos(0);
                    }
                    break;
                case ArrowUp:
                    if (player.getyPos() > 0){
                        player.setyPos(-1);
                    } else {
                        player.setyPos(0);
                    }
                    break;
                case ArrowLeft:
                    if (player.getxPos() > 0){
                        player.setxPos(-1);
                    } else {
                        player.setxPos(0);
                    }
                    break;
                case ArrowRight:
                    if (player.getxPos() < board.getSizeXDimension()){
                        player.setxPos(1);
                    } else {
                        player.setxPos(0);
                    }
                    break;
            }
            monstersMove();


        }
    }

    private void createBoard(int x, int y){
        board = new Board(x, y);
    }
    private void monstersMove(){
        for(Monster monster : monsters){
            monsterMove(monster);
        }
    }
    private void monsterMove(Monster monster){
        if(Math.abs(monster.getxPos() - player.getxPos()) > Math.abs(monster.getyPos() - player.getyPos())){
            monster.setxPos( monster.getxPos() > player.getxPos() ? - 1 : 1);
        } else {
            monster.setyPos( monster.getyPos() > player.getyPos() ? - 1 : 1);
        }
    }
    private void drawBoard(){
        terminal.clearScreen();
        terminal.moveCursor(player.getxPos(), player.getyPos());
        terminal.putCharacter(player.getLook());

        for(Monster monster : monsters){
            terminal.moveCursor(monster.getxPos(), monster.getyPos());
            terminal.putCharacter(monster.getLook());
        }
    }

    private void setupGame(int numberOfMonsters){
        //run once at start of new game
        monsters = new ArrayList<>();
        player = new Player(10, 10, '\u2021');
        setupMonsters(numberOfMonsters);
    }

    private void setupMonsters(int number) {
        Random rand = new Random();
        //run once at start of new game
        //create one or many monsters
        for (int i = 0; i < number; i++) {
            Monster monster = new Monster(rand.nextInt(board.getSizeXDimension() + 1), rand.nextInt(board.getSizeYDimension() + 1));
            monsters.add(monster);
        }
    }
}
