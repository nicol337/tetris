package leetetris;

public class PieceJ extends Piece {

    public PieceJ() {

    color = "BLUE";
    
    xArray[0] = 3;
    yArray[0] = 0;

    xArray[1] = 3;
    yArray[1] = 1;

    xArray[2] = 4;
    yArray[2] = 1;

    xArray[3] = 5;
    yArray[3] = 1;
    }


    public void rotation() {
       rCount += 1;

       if (rCount==1) {

           int checker = 0;

            xTemp[0] = xArray[0] + 1;
            yTemp[0] = yArray[0] + 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1];

            xTemp[2] = xArray[2] - 1;
            yTemp[2] = yArray[2] + 1;

            xTemp[3] = xArray[3] - 2;
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

            xTemp[0] = xArray[0] - 1;
            yTemp[0] = yArray[0] + 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1];

            xTemp[2] = xArray[2] - 1;
            yTemp[2] = yArray[2] - 1;

            xTemp[3] = xArray[3] - 2;
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
            xArray[0] += 1;
            yArray[0] += 1;

            xArray[1] -= 1;
            yArray[1] += 1;

            xArray[2] = xArray[2];
            yArray[2] = yArray[2];

            xArray[3] -= 1;
            yArray[3] -= 1;
             *
             */

       }


       if (rCount==3) {

            int checker = 0;

            xTemp[0] = xArray[0] - 1;
            yTemp[0] = yArray[0] - 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1];

            xTemp[2] = xArray[2] + 1;
            yTemp[2] = yArray[2] - 1;

            xTemp[3] = xArray[3] + 2;
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

            xTemp[0] = xArray[0] + 1;
            yTemp[0] = yArray[0] - 1;

            xTemp[1] = xArray[1];
            yTemp[1] = yArray[1];

            xTemp[2] = xArray[2] + 1;
            yTemp[2] = yArray[2] + 1;

            xTemp[3] = xArray[3] + 2;
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
