import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class userBoard extends JFrame implements MouseListener {
    btn[][] board = new btn[10][10];
    Random rand = new Random();
    int shipSize = 5;
    int randRow,randCol;
    HashSet<String> coordinate = new HashSet<>();
    btn b;
    static int finish = 0;
    static int totalShip=0;
    boolean isfinish = false;


    public userBoard() {
        setTitle("Amiral Battı");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 10));
        coordinate.add("12341");  // bunu def olarak bi tane olsun diye yaptık

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                b = new btn(row, col);
                b.addMouseListener(this);
                b.setText("*");
                add(b);
                board[row][col] = b;

            }
        }

        generateShip();
        showShip();
        cordinaateList();



        setVisible(true);

    }
    public void isFinish(){
        if (finish == totalShip){
            System.out.println("kazandınız");
        }
    }

    public int singOrDoub() {
        int x = rand.nextInt(2);
        return x;
    }

    public void showShip(){
        for (int row = 0;row<10;row++){
            for (int col = 0; col<10;col++){
                if (board[row][col].Ship()){
                    totalShip++;
                }
            }
        }
    }

    public void generateShip() {
        int i = 0;
        while (i < 5) {
            if (singOrDoub() % 2 == 0) {
                horizontalShip();
            } else {
                verticalShip();
            }
            shipSize--;
            i++;
        }
    }



    public void horizontalShip(){
        HashSet<String> tempArr = new HashSet<>();
        boolean sameCordinate = false;

        randRow = rand.nextInt(10);
        randCol = rand.nextInt(10-shipSize);
        int tempRandCol = randCol; // ana dizide var mı diye randcolu geciciye aktarırız ki olursa eğer randcol u kaybetmeyelim diye
        int i = 0;
        while (i<shipSize){  // control mekanizması
            String strTempCoordinate = randRow+" "+tempRandCol;
            System.out.println("temprandcol: "+strTempCoordinate);
            Iterator<String> itr = coordinate.iterator();
            while (itr.hasNext()){
                if (itr.next() == strTempCoordinate){
                    sameCordinate = true;
                    tempArr.clear();
                    break;
                }else{
                    tempArr.add(strTempCoordinate);
                    sameCordinate = false;
                    tempRandCol++;
                }
            }
            i++;
        }

        if (sameCordinate == true){
            horizontalShip();
        }else {
            coordinate.addAll(tempArr);
        }
        int k = 0;
        while(k<shipSize){
            board[randRow][randCol].setShip(true);
            System.out.println("kordinat: "+randRow+" "+randCol);
            System.out.println("k: "+k);
            k++;
            randCol++;
        }


    }


    public void verticalShip(){
        HashSet<String> tempArr = new HashSet<>();
        boolean sameCordinate = false;
        randRow = rand.nextInt(10-shipSize);
        randCol = rand.nextInt(10);

        int tempRandRow = randRow;
        int i = 0;
        while (i<shipSize){  // control mekanizması
            String strTempCoordinate = tempRandRow+" "+randCol;
            Iterator<String> itr = coordinate.iterator();
            while (itr.hasNext()){
                if (itr.next() == strTempCoordinate){
                    sameCordinate = true;
                    tempArr.clear();
                    break;
                }else{
                    tempArr.add(strTempCoordinate);
                    sameCordinate = false;
                    tempRandRow++;
                }
            }
            i++;
        }


        if (sameCordinate == true){
            verticalShip();
        }else {
            coordinate.addAll(tempArr);
        }
        int k = 0;
        while(k<shipSize){
            board[randRow][randCol].setShip(true);
            System.out.println("kordinat: "+randRow+" "+randCol);
            System.out.println("k: "+k);
            k++;
            randRow++;
        }
    }

    public void cordinaateList(){
        for (String a:coordinate) {
            System.out.println(a);
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        btn b = (btn) e.getComponent();

        if (e.getButton() == 1) {
            if (b.Ship()) {
                System.out.println("Gemiyi vurdun");
                finish++;
                isFinish();
                b.setEnabled(false);
                b.setText("<>");
            } else {
                System.out.println("Kaçırdın");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
