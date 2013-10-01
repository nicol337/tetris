package leetetris;




public class Piece {

    public int[] xArray = new int[4]; //the x coordinates of the four blocks
    public int[] yArray = new int[4]; //the y coordinates of the four blocks
    public boolean dead = false; //tells if the piece has reached a position of being "stuck"
    public String color = "BLACK";
    public int rCount = 0;
    public int[] xTemp = new int[4];
    public int[] yTemp = new int[4];

    /*public Piece () {
        for (int i = 0; i < xArray.length; i++){
            xArray[i] = i + 3;
            yArray[i] = 1;
        }
        dead = false;

    }
     * 
     */

    void moveDown() {
        int checkCount = 0;
        for (int j = 0; j < yArray.length; j++) {
           if ((this.yArray[j]+1) < (Features.height-1)) {
                if (Features.Board[this.getXCoord(j)][this.getYCoord(j)+1]=='-') {
                    checkCount+=1;
                }
            }
        }//checks if the move is valid (no pieces block it)

        if (checkCount==4) {
            for (int j = 0; j < yArray.length; j++) {
                yArray[j] = yArray[j] + 1;
            }
        } //updates the coordinates that the piece stores

        if (checkCount!=4) {
            this.deactivate();
        }


    }

    void moveLeft() {
        int checkCount = 0;
        for (int j = 0; j < xArray.length; j++) {
            if ((xArray[j]-1) >=0){
                if (Features.Board[getXCoord(j)-1][getYCoord(j)]=='-') {
                checkCount+=1;
                }
            }
        }

        if (checkCount==4) {
            for (int j = 0; j < xArray.length; j++) {
                xArray[j] -= 1;
            }
        }
    }

    void moveRight() {
        int checkCount=0;
        

                 //check if the move is allowed within bounds of board
        for (int j = 0; j < xArray.length; j++) {
           if ((xArray[j]+1) <  (Features.width)){
                if (Features.Board[getXCoord(j) + 1][getYCoord(j)]=='-') {
                    checkCount+=1;
                }
            }

        }
        if (checkCount==4){
            for (int j = 0; j < xArray.length; j++) {
                xArray[j] += 1;
            }
        }
    }

    int[] getXArray() {
        return xArray;
    }

    int getXCoord(int index) {
        if ((0 <= index) && (index < 4)) {
            return this.xArray[index];
        }
        else {
            return -1;
        }
     }

    int getYCoord(int index) {
        if ((0 <= index) && (index < 4)) {
            return this.yArray[index];
        }
        else {
            return -1;
        }
    }
    int[] getYArray() {
        return yArray;
    }


    public boolean getDead() {
        return dead;
    }

    void deactivate() {
        dead=true;
    }
    
    public String getColor() {
        return color;
    }

    public void rotation() {
       rCount += 1;

       if (rCount==3) {
           rCount = -1;
       }
   }





}

/*


public class PieceJ extends Piece {

    xArray[0] = 3;
    yArray[0] = 1;

    xArray[1] = 3;
    yArray[1] = 2;

    xArray[2] = 4;
    yArray[2] = 2;

    xArray[3] = 5;
    yArray[3] = 2;
}

public class PieceI extends Piece {

    xArray[0] = 3;
    yArray[0] = 1;

    xArray[1] = 4;
    yArray[1] = 1;

    xArray[2] = 5;
    yArray[2] = 1;

    xArray[3] = 6;
    yArray[3] = 1;

    public void rotate() {


    }

}

public class PieceS extends Piece {

    xArray[0] = 4;
    yArray[0] = 2;

    xArray[1] = 5;
    yArray[1] = 1;

    xArray[2] = 5;
    yArray[2] = 2;

    xArray[3] = 6;
    yArray[3] = 1;
}

public class PieceZ extends Piece {

    xArray[0] = 3;
    yArray[0] = 1;

    xArray[1] = 4;
    yArray[1] = 1;

    xArray[2] = 4;
    yArray[2] = 2;

    xArray[3] = 5;
    yArray[3] = 2;

}

public class PieceT extends Piece {

    xArray[0] = 3;
    yArray[0] = 2;

    xArray[1] = 4;
    yArray[1] = 1;

    xArray[2] = 4;
    yArray[2] = 2;

    xArray[3] = 5;
    yArray[3] = 2;
}
}

 *
 */

