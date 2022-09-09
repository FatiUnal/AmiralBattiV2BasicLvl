import javax.swing.*;

public class btn extends JButton {
    private int row,col;
    private boolean Ship;

    public  btn(int row,int col){
        this.row = row;
        this.col = col;
        this.Ship = false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean Ship() {
        return Ship;
    }

    public void setShip(boolean ship) {
        this.Ship = ship;
    }
}
