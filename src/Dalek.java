/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fostp4040
 */
public class Dalek {
    private int row;
    private int col;
    private boolean crashed;
    private boolean captured;
    public Dalek(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public void advanceTowards(Doctor doc){
        int docRow = doc.getRow();
        int docCol = doc.getCol();       
        if(row>docRow&&crashed==false&&captured==false){
            //if Who is to the left of Dalek, move Dalek to the left
            row--;
        }else if(row<docRow&&crashed==false&&captured==false){
            //if Who is to the left of Dalek, move Dalek to the right
            row++;
        }else if(row==docRow&&crashed==false&&captured==false){
            //if Who is in the same column as Dalek, Dalek stops going left or right
            row=row;
        }
        if(col>docCol&&crashed==false&&captured==false){
            //if Who is above Dalek, move Dalek upwards
            col--;
        }else if(col<docCol&&crashed==false&&captured==false){
            //if Who is below Dalek, move Dalek downwards
            col++;
        }else if(col==docCol&&crashed==false&&captured==false){
            //if Who is in the same row as Dalek, Dalek stops going up or down
            col=col;
        }
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void crash(){
        crashed=true;
        row=row;
        col=col;
    }
    public boolean hasCrashed(){
        if (crashed==true){
            row=row;
            col=col;
            return true;
        }else{
            return false;
        }
    }
    public void capture(){
        captured=true;
        row=row;
        col=col;
    }
    public boolean hasCaptured(){
        if(captured==true){
            row=row;
            col=col;
            return true;
        }else{
            return false;
        }
    }
}
