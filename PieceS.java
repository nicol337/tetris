/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetetris;

/**
 *
 * @author nicolelee
 */
public class PieceS extends Piece {

    public PieceS () {

        color = "RED";
        
        xArray[0] = 4;
        yArray[0] = 1;

        xArray[1] = 5;
        yArray[1] = 0;

        xArray[2] = 5;
        yArray[2] = 1;

        xArray[3] = 6;
        yArray[3] = 0;
    }

    public void rotation() {
       rCount += 1;

       if (rCount==1) {

           int checker = 0;

            xTemp[0] = xArray[0] + 1;
            yTemp[0] = yArray[0] - 1;

            xTemp[1] = xArray[1] + 1;
            yTemp[1] = yArray[1] + 1;

            xTemp[2] = xArray[2];
            yTemp[2] = yArray[2];

            xTemp[3] = xArray[3];
            yTemp[3] = yArray[3] + 2;

            for (int i = 0; i < 4; i++ ) {
                if (Features.Board[xTemp[i]][yTemp[i]]=='-') {
                    checker += 1;
                }
            }

            if (checker==4) {
                for (int i = 0; i < 4; i++ ) {
                    xArray[i] = xTemp[i];
                    yArray[i] = yTemp[i];
                }
            }

       }

       if (rCount==2) {

           int checker = 0;

            xTemp[0] = xArray[0] + 2;
            yTemp[0] = yArray[0] + 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1] + 1;

            xTemp[2] = xArray[2] + 1;
            yTemp[2] = yArray[2];

            xTemp[3] = xArray[3] - 1;
            yTemp[3] = yArray[3];

            for (int i = 0; i < 4; i++ ) {
                if (Features.Board[xTemp[i]][yTemp[i]]=='-') {
                    checker += 1;
                }
            }

            if (checker==4) {
                for (int i = 0; i < 4; i++ ) {
                    xArray[i] = xTemp[i];
                    yArray[i] = yTemp[i];
                }
            }




       }


       if (rCount==3) {

            int checker = 0;

            xTemp[0] = xArray[0] - 1;
            yTemp[0] = yArray[0] + 1;

            xTemp[1] = xArray[1] - 1;
            yTemp[1] = yArray[1] - 1;

            xTemp[2] = xArray[2];
            yTemp[2] = yArray[2];

            xTemp[3] = xArray[3];
            yTemp[3] = yArray[3] - 2;

            for (int i = 0; i < 4; i++ ) {
                if (Features.Board[xTemp[i]][yTemp[i]]=='-') {
                    checker += 1;
                }
            }

            if (checker==4) {
                for (int i = 0; i < 4; i++ ) {
                    xArray[i] = xTemp[i];
                    yArray[i] = yTemp[i];
                }
            }
            /*
            xArray[0] -= 1;
            yArray[0] += 1;

            xArray[1] -= 1;
            yArray[1] -= 1;

            xArray[2] = xArray[2];
            yArray[2] = yArray[2];

            xArray[3] += 1;
            yArray[3] -= 1;
             *
             */
       }

       if (rCount==4) {

            rCount=0;
            int checker = 0;

            xTemp[0] = xArray[0] - 2;
            yTemp[0] = yArray[0] - 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1] - 1;

            xTemp[2] = xArray[2] - 1;
            yTemp[2] = yArray[2];

            xTemp[3] = xArray[3] + 1;
            yTemp[3] = yArray[3];

            for (int i = 0; i < 4; i++ ) {
                if (Features.Board[xTemp[i]][yTemp[i]]=='-') {
                    checker += 1;
                }
            }

            if (checker==4) {
                for (int i = 0; i < 4; i++ ) {
                    xArray[i] = xTemp[i];
                    yArray[i] = yTemp[i];
                }
            }

            /*
            xArray[0] -= 1;
            yArray[0] -= 1;

            xArray[1] += 1;
            yArray[1] -= 1;

            xArray[2] = xArray[2];
            yArray[2] = yArray[2];

            xArray[3] += 1;
            yArray[3] += 1;
             *
             */
       }

   }
}
