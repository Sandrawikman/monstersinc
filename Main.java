package MonstersInc;

public class Main {
    private Board board;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run(){
        createBoard(50, 50);
    }

    private void createBoard(int x, int y){
        board = new Board(x, y);
    }
}
