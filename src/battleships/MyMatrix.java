package battleships;

import java.util.Scanner;

public class MyMatrix {
    Scanner scan = new Scanner(System.in);

    public int sea1[][] = { {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0 },
            {0,0,0,0,0,0,0,0} };

    int[] rowAndColumnOfTheSmallBoatArr;

    public int[][] getMySeaMatrix(){
        return sea1;
    }

    public void placeCoordinatesForSmallBoat(){
        System.out.println("One field ship (small) \n");
        System.out.print("Row: ");
        int rowMal = scan.nextInt();
        System.out.print("Column: ");
        int columnMal= scan.nextInt();
        while(true){
            if(rowMal < 0 || rowMal>7 || columnMal>7 || columnMal<0){
                System.out.println("\nEnter a number between 0 and 7");
                System.out.print("Row of small ship: ");
                rowMal = scan.nextInt();
                System.out.print("Column of small ship: ");
                columnMal= scan.nextInt();
            }else{
                break;
            }
        }
        sea1[rowMal][columnMal]=1;
        rowAndColumnOfTheSmallBoatArr = new int[]{rowMal, columnMal};
        System.out.println("Small boat placed captain!");
    }


    public void placeCoordinatesForMediumBoat(){
        System.out.println("Two field ship (medium) \n ");
        System.out.print("Row of the first field: ");
        int rowSreden = scan.nextInt();
        System.out.print("Column of the first field: ");
        int columnSreden = scan.nextInt();

        while(true){
            if(columnSreden >= 7 || rowSreden < 0 || rowSreden>7  || columnSreden<0
                    || (rowSreden==rowAndColumnOfTheSmallBoatArr[0] && columnSreden== rowAndColumnOfTheSmallBoatArr[1]) ||(rowSreden== rowAndColumnOfTheSmallBoatArr[0] && columnSreden+1== rowAndColumnOfTheSmallBoatArr[1])){
                System.out.println("\nEnter a number smaller than 7 or there is a boat in that field ");
                System.out.print("Row of the first field: ");
                rowSreden=scan.nextInt();
                System.out.print("Column of the first field: ");
                columnSreden=scan.nextInt();
            } else {
                break;
            }
        }
        sea1[rowSreden][columnSreden]=1;
        sea1[rowSreden][columnSreden+1]=1;
        System.out.println("Medium boat placed captain!");
    }

    public void placeCoordinatesForBigBoat(){
        System.out.println("Three field ship (big) \n");
        System.out.print("Row of the first field: ");
        int rowGolem = scan.nextInt();
        System.out.print("Column of the first field: ");
        int columnGolem= scan.nextInt();

        while(true){
            if(columnGolem >=6  || rowGolem < 0 || rowGolem>7 || columnGolem<0
                    || sea1[rowGolem][columnGolem]==1 || (columnGolem+1<=7 && sea1[rowGolem][columnGolem+1]==1)
                    || (columnGolem+2<=7 && sea1[rowGolem][columnGolem+2]==1) || (columnGolem+3<=7 && sea1[rowGolem][columnGolem+3]==1)){
                System.out.println("\nEnter a number smaller than 6 or there is a ship in that field ");
                //printMatrix(mySeaMatrix.getMySeaMatrix());
                System.out.print("Row of the first field: ");
                rowGolem=scan.nextInt();
                System.out.print("Column of the first field: ");
                columnGolem=scan.nextInt();
            }
            else {
                break;
            }
        }

        sea1[rowGolem][columnGolem]=1;
        sea1[rowGolem][columnGolem+1]=1;
        sea1[rowGolem][columnGolem+2]=1;
        System.out.println("Big boat placed captain!");
    }
}
