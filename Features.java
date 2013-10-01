package leetetris;



import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;

public class Features extends JFrame {
    
    
    public final static int width = 10;
    public final static int height = 23;
    public static int deleted = 0;

    static char[][] Board = new char[width][height];//the one updated at the end of the piece
                                                    // when the piece becomes a part of the board


    static char[][] Grid = new char[width][height]; //the one used for the piece's life as it moves

    static int[] RowChecker = new int[height];

    static boolean stop = false;

   
   public static Piece RandomPiece() {

        Piece ThePiece;

        Random random = new Random();
        int r = random.nextInt(7);
        switch (r) {
            case 0: {
                ThePiece = new PieceL();
                return ThePiece;
            }
            case 1: {
                ThePiece = new PieceO();
                return ThePiece;
            }
            case 2: {
                ThePiece = new PieceJ();
                return ThePiece;
            }
            case 3: {
                ThePiece = new PieceI();
                return ThePiece;
            }
            case 4: {
                ThePiece = new PieceS();
                return ThePiece;
            }
            case 5: {
                ThePiece = new PieceT();
                return ThePiece;
            }
            default: {
                ThePiece = new PieceZ();
                return ThePiece;
            }

        }
    }//end of RandomPiece

   public static void clearRows(int row) {
        deleted +=1; 
           for (int col = 0; col < width; col++) {
                   for (int k=row; k > 0; k--) {
                       Board[col][k] = Board[col][k-1];
                       }
           }
       }
    

   public static void clearRowsInBoard() {



       for (int row = (height-1); row >= 0; row--) {
           RowChecker[row] = 0;
       }//reset all the element of RowChecker to zero

       for (int row = (height-1); row >= 0; row--) {
           for (int col = 0; col < width; col++){
               if (Board[col][row]=='X') {
                   RowChecker[row]+=1;
               }
           }
       }//scans each column square of each row to see if there are 10 Xs

       for (int row = (height-1); row > 0; row--){
           if (RowChecker[row]==width) {
               for (int col = 0; col < width; col++) {
                   Board[col][row]='O';

                   
                   }
               
                        }
                   
                }
       for (int row = (height-1); row > 0; row--){

               while (Board[0][row]=='O') {

                   clearRows(row);
                   
           }
       }
      

       

   }//to be done after the piece has settled after Board is updated


   public static void topOut() {
       
       if (RowChecker[1]!=0) {
           System.out.println("GAME OVER");
           stop = true;
           JOptionPane.showMessageDialog(null, "GAME OVER!", "The End", JOptionPane.INFORMATION_MESSAGE);
           System.exit(0);
           

           //end program statement
       }
      
   }
   
   public static void updateGrid(Piece ThePiece) {
       
      for (int i=0; i  < width; i++) {
           for (int j=0; j < height; j++) {
               Grid[i][j] = Board[i][j];
           }
      }//redraws the whole array as if there is ThePiece

      for (int i=0; i < ThePiece.xArray.length; i++) {
           Grid[ThePiece.getXCoord(i)][ThePiece.getYCoord(i)] = 'X';
      }//redraws the whole array with the existence of ThePiece after an action

    }//end of updateGrid (to be done after each movement has been confirmed)
   
   public static void updateBoard(Piece ThePiece) {
       
       //if(ThePiece.dead==true) {
           for (int i=0; i  < width; i++) {
               for (int j=0; j < height; j++) {
                   Board[i][j] = Grid[i][j];
               }
           }
       //}
   }//end of updateBoard (to be done after ThePiece is dead)

   public static void printBoard() {

        for (int i=2; i < (height - 1); i++) {
                for (int j=0; j < width; j++) {
                    
                        System.out.print(Board[j][i]);
                }
                System.out.println();
     }//prints the grid

        System.out.println();
        }

   public static void printGrid() {

        for (int i=2; i < (height - 1); i++) {
            for (int j=0; j < width; j++) {

                System.out.print(Grid[j][i]);
            }
            System.out.println();
        }//prints the grid

    System.out.println();
}
   public static String getDeleted() {
       String str = (new Integer(deleted)).toString();
       return str;
   }

   


   

    //while (row above the grid is clear and while ThePiece.dead = false
    //if ThePiece is dead redeclare a new piece randomly and assign it to ThePiece
   //so it can be controlled
}//end of Features

