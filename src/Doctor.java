/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fostp4040
 */
public class Doctor {
    private int row;
    private int col;
    private boolean captured;
    private boolean win;
    private int rand= (int)(Math.random()*12);
    public Doctor(int theRow, int theCol){
        this.row=theRow;
        this.col=theCol;
    }
    
    public void move(int newRow, int newCol){
        if(row-newRow==1&&captured==false&&win==false){
            //Doctor moves to selected space if it's right next to where the Doctor is
            row--;
        }else if(row-newRow==-1&&captured==false&&win==false){
            //Doctor moves to selected space if it's right next to where the Doctor is
            row++;
        }else if(row-newRow>=2||row-newRow<=-2&&captured==false&&win==false){
            //Doctor use the TARDIS to teleport to random space if it's not next to where the Doctor is
            row=rand;
        }else if(row-newRow==0&&captured==false&&win==false){
            //Doctor stays put if selected space is where the doctor is currently
            row=row;
        }
        if(col-newCol==1&&captured==false&&win==false){
            //Doctor moves to selected space if it's right next to where the Doctor is
            col--;
        }else if(col-newCol==-1&&captured==false&&win==false){
            //Doctor moves to selected space if it's right next to where the Doctor is
            col++;
        }else if(col-newCol>=2||col+newCol<=2&&captured==false&&win==false){
            //Doctor use the TARDIS to teleport to random space if it's not next to where the Doctor is
            col=rand;
        }else if(col-newCol==0&&captured==false&&win==false){
            //Doctor stays put if selected space is where the doctor is currently
            col=col;
        } 
        if(row-newRow==0&&col-newCol==0&&captured==false&&win==false){
            //Doctor stays put if selected space is where the doctor is currently
            row=row;
            col=col;
        }
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void capture(){
        captured=true;
        row=row;
        col=col;
    }
    public void win(){
        win=true;
        row=row;
        col=col;
    }
    public boolean gotCaptured(){
        if (captured==true){
            row=row;
            col=col;
            return true;
        }else{
            return false;
        }
    }
    public boolean won(){
        if (win==true){
            row=row;
            col=col;
            return true;
        }else{
            return false;
        }
    }
}
