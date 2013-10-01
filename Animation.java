/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Animation extends JFrame {
    
    //Animation constructor
     //public static Piece ThePiece = Features.RandomPiece();
     public static Piece ThePiece = Features.RandomPiece();

     public static int xPix = 20;
     public static int yPix = 20;
     public static int winWidth = 300;
     public static int winHeight = 520;

     public static int rotation = 0;
      public static TetrisPanel tetrisPanel = new TetrisPanel();
//
     public Animation () {
        add(tetrisPanel);
        tetrisPanel.setFocusable(true);

    }
  
    public static void main(String[] args) {

       JFrame frame = new Animation();
       frame.setTitle("Tetris");
       frame.setSize(winWidth,winHeight);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);

}
//beginning of keyboardPanel
   

    
    

   //end of KeyboardPanel
    



    static class TetrisPanel extends JPanel{




        /*static class KeyboardPanel extends JPanel {




     public KeyboardPanel() {


         *
         */


        public TetrisPanel() {
            Timer timer = new Timer(500, new TimerListener());
            timer.start();
            

            for (int i=0; i < Features.width; i++) {
                for (int j=0; j < Features.height; j++)
                    Features.Board[i][j] = '-';
            }
            for (int i=0; i < Features.width; i++) {
                for (int j=0; j < Features.height; j++)
                    Features.Grid[i][j] = '-';
            }

            addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {


          switch (e.getKeyCode()) {

            case KeyEvent.VK_DOWN: {
                if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.clearRowsInBoard();
                        Features.topOut();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        
                    }
                repaint();
                ThePiece.moveDown();
                Features.updateGrid(ThePiece);
                //Features.printGrid();
                //Features.clearRowsInBoard();//initializes RowChecker
                Features.topOut();//makes sure the move is initially valid
                repaint();
                break;
            }

            case KeyEvent.VK_UP:
                
                ThePiece.rotation();
                //System.out.print(rotation);
                
                if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.clearRowsInBoard();
                        Features.topOut();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        

                    }
                //rotate the piece
                break;

            case KeyEvent.VK_LEFT: {
               


                if (Features.stop==false) {
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    ThePiece.moveLeft();
                    Features.updateGrid(ThePiece);
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    //Features.printGrid();
                    repaint();


                    if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.topOut();
                        Features.clearRowsInBoard();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        

                    }

                }
            
            break;
            }

            case KeyEvent.VK_RIGHT:
            {


                if (Features.stop==false) {
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    ThePiece.moveRight();
                    Features.updateGrid(ThePiece);
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    //Features.printGrid();
                    repaint();


                    if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.topOut();
                        Features.clearRowsInBoard();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        
                    }

                }
            
                
                break;
            }

            default: {


                if (Features.stop==false) {
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    ThePiece.moveDown();
                    Features.updateGrid(ThePiece);
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    //Features.printGrid();
                    repaint();


                    if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.topOut();
                        Features.clearRowsInBoard();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        
                    }

                }
                break;
            }
          }

        }

      });
         
     
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
             for (int i=0; i < Features.width; i++) {
                for (int j=2; j < Features.height-1; j++)
                    if(Features.Grid[i][j] == 'X') {
                        
                        if (ThePiece.getColor() == "CYAN")
                            g.setColor(Color.CYAN);
                        if (ThePiece.getColor() == "MAGENTA")
                            g.setColor(Color.MAGENTA);
                        if (ThePiece.getColor() == "RED")
                            g.setColor(Color.RED);
                        if (ThePiece.getColor() == "BLUE")
                            g.setColor(Color.BLUE);
                        if (ThePiece.getColor() == "YELLOW")
                            g.setColor(Color.YELLOW);
                        if (ThePiece.getColor() == "GREEN")
                            g.setColor(Color.GREEN);
                        if (ThePiece.getColor() == "ORANGE")
                            g.setColor(Color.ORANGE);

                        g.fillRect(50 + i*xPix, 30 + j*yPix, xPix, yPix);
                        g.setColor(Color. WHITE);
                        g.drawRect(50 + i*xPix, 30 + j*yPix, xPix, yPix);
                    }
            }
            g.setColor(Color.black);
            g.drawRect(50, 70, 200, 400);
            
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(String.valueOf(Features.deleted), winWidth/2, 50);




        }

        

        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                if (Features.stop==false) {
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    ThePiece.moveDown();
                    Features.updateGrid(ThePiece);
                    //Features.clearRowsInBoard();//initializes RowChecker
                    Features.topOut();//makes sure the move is initially valid
                    //Features.printGrid();
                    repaint();


                    if (ThePiece.getDead()==true) {
                        Features.updateBoard(ThePiece);
                        Features.topOut();
                        Features.clearRowsInBoard();
                        ThePiece = Features.RandomPiece();
                        rotation = 0;
                        

                    }

                }
            }//end of actionPerformed
        }//end of TimerListener

    }//end of TetrisPanel
}//end of Animation
