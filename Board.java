package MonstersInc;

public class Board {
    private int sizeXDimension;
    private int sizeYDimension;

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


    public void setSizeYDimension(int sizeYDimension) {
        if (sizeYDimension < 1) {
            this.sizeYDimension = 1;
        } else {
            this.sizeYDimension = sizeYDimension;
        }
    }
}
