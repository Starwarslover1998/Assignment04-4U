
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fostp4040
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int randDoc= (int)(Math.random()*12);
        int randDalek1= (int)(Math.random()*12);
        int randDalek2= (int)(Math.random()*12);
        int randDalek3= (int)(Math.random()*12);
        //create game board
        Board board = new Board(12,12);
        //Who's 'peg'
        Doctor who= new Doctor(randDoc,randDoc);
        board.putPeg(Color.green,randDoc,randDoc);
        //Dalek1's 'peg'
        Dalek d1= new Dalek(randDalek1,randDalek1);
        board.putPeg(Color.black,randDalek1,randDalek1);
        //Dalek2's 'peg'
        Dalek d2= new Dalek(randDalek2,randDalek2);
        board.putPeg(Color.black,randDalek2,randDalek2);
        //Dalek3's 'peg'
        Dalek d3= new Dalek(randDalek3,randDalek3);
        board.putPeg(Color.black,randDalek3,randDalek3);
        //put a message on the board
        board.displayMessage("please click the board");
        while (true){
            Coordinate click =board.getClick();
            //The Doctor moves
            board.removePeg(who.getRow(),who.getCol());
            who.move(click.getRow(),click.getCol());
            board.putPeg(Color.green, who.getRow(), who.getCol());
            //Dalek1 moves
            board.removePeg(d1.getRow(),d1.getCol());
            d1.advanceTowards(who);
            board.putPeg(Color.black,d1.getRow(),d1.getCol());
            //Dalek2 moves
            board.removePeg(d2.getRow(),d2.getCol());
            d2.advanceTowards(who);
            board.putPeg(Color.black,d2.getRow(),d2.getCol());
            //Dalek3 moves
            board.removePeg(d3.getRow(),d3.getCol());
            d3.advanceTowards(who);
            board.putPeg(Color.black,d3.getRow(),d3.getCol());
            who.gotCaptured();
            d1.hasCaptured();
            d1.hasCrashed();
            d2.hasCaptured();
            d2.hasCrashed();
            d3.hasCaptured();
            d3.hasCrashed();
            //if dalek1 hits dalek2
            if(d1.getRow()==d2.getRow()&&d1.getCol()==d2.getCol()||
                    d2.getRow()==d1.getRow()&&d2.getCol()==d1.getCol()){
                board.removePeg(d1.getRow(),d1.getCol());
                board.putPeg(Color.red,d1.getRow(),d1.getCol());
                d1.crash();
                board.removePeg(d2.getRow(),d2.getCol());
                board.putPeg(Color.red,d2.getRow(),d2.getCol());
                d2.crash();
            }
            //if dalek1 hits dalek3
            if(d1.getRow()==d3.getRow()&&d1.getCol()==d3.getCol()||
                    d3.getRow()==d1.getRow()&&d3.getCol()==d1.getCol()){
                board.removePeg(d1.getRow(),d1.getCol());
                board.putPeg(Color.red,d1.getRow(),d1.getCol());
                d1.crash();
                board.removePeg(d3.getRow(),d3.getCol());
                board.putPeg(Color.red,d3.getRow(),d3.getCol());
                d3.crash();
            }
            //if dalek2 hits dalek3
            if(d2.getRow()==d3.getRow()&&d2.getCol()==d3.getCol()||
                    d3.getRow()==d2.getRow()&&d3.getCol()==d2.getCol()){
                board.removePeg(d2.getRow(),d2.getCol());
                board.putPeg(Color.red,d2.getRow(),d2.getCol());
                d2.crash();
                board.removePeg(d3.getRow(),d3.getCol());
                board.putPeg(Color.red,d3.getRow(),d3.getCol());
                d3.crash();
            }
            if(d1.getRow()==who.getRow()&&d1.getCol()==who.getCol()||
                    d2.getRow()==who.getRow()&&d2.getCol()==who.getCol()||
                    d3.getRow()==who.getRow()&&d3.getCol()==who.getCol()){
                board.putPeg(Color.yellow, who.getRow(), who.getCol());
                who.capture();
                d1.capture();
                d2.capture();
                d3.capture();
                board.displayMessage("The Daleks has captured The Doctor. Game Over.");
                
            }
            if(d2.getRow()==d3.getRow()&&d2.getCol()==d3.getCol()&&
                    d1.getRow()==d2.getRow()&&d1.getCol()==d2.getCol()&&
                    d3.getRow()==d1.getRow()&&d3.getCol()==d1.getCol()){
                board.removePeg(d1.getRow(),d1.getCol());
                board.putPeg(Color.red,d1.getRow(),d1.getCol());
                d1.crash();
                board.removePeg(d2.getRow(),d2.getCol());
                board.putPeg(Color.red,d2.getRow(),d2.getCol());
                d2.crash();
                board.removePeg(d3.getRow(),d3.getCol());
                board.putPeg(Color.red,d3.getRow(),d3.getCol());
                d3.crash();
                board.displayMessage("All Daleks have crashed. You win.");
                
            }
        }
        
    }
}
