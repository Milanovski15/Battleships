package battleships;

import java.util.Scanner;

public class GameLogic extends MyMatrix{
    int guessCounter=0;
    int guessCounterComputer=0;
    int choose;

    MyMatrix mySeaMatrix;
    EnemyMatrix enemySeaMatrix;

    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) //rows
        {
            System.out.println(" ");
            for (int j = 0; j < mat[i].length; j++) //columns
            {
                System.out.print(mat[i][j] + " ");
            }

        }
        System.out.println("\n");
    }

    public void setMatrices(MyMatrix myMatrix, EnemyMatrix enemyMatrix){
        this.mySeaMatrix = myMatrix;
        this.enemySeaMatrix = enemyMatrix;
    }

    public void chooseGameHardnesLevel(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the level of hardness 0-easy 1-hard (not so hard actually :P )");
        choose=scan.nextInt();

        while(choose>1 || choose<0){
            System.out.println("The developer was not smart enough so he made only 2 levels, so please choose a number between 0 and 1 :)");
            choose=scan.nextInt();
        }

        if(choose==0){
            System.out.println("You chose the easy level - 0");
        }else if(choose==1){
            System.out.println("You chose the hard level - 1");
        }
    }

    public int playTheGame(){
        for( ; ; ){
            for( ; ; )
            {
                Scanner scan = new Scanner(System.in);
                System.out.print("Where do you think that the computer has a ship? \n");
                System.out.print("Row of enemy ship block: ");
                int guessRow= scan.nextInt();
                System.out.print("Column of enemy ship block: ");
                int guessColumn=scan.nextInt();

                if(guessRow > 7 || guessColumn > 7 || guessRow <0 || guessColumn < 0){
                    System.out.println("Enter a number betwenn 0 and 7");
                }else{
                    if(enemySeaMatrix.getEnemySeaMatrix()[guessRow][guessColumn]==3){
                        System.out.println("You already guessed this field and missed");
                        continue;
                    }
                    if(enemySeaMatrix.getEnemySeaMatrix()[guessRow][guessColumn]==2){
                        System.out.println("You already guessed this field and hit");
                        continue;
                    }
                    if(enemySeaMatrix.getEnemySeaMatrix()[guessRow][guessColumn]==1)
                    {
                        System.out.println("You hit the computers boat!!! at ["+guessRow+","+guessColumn+"]");
                        guessCounter++;
                        enemySeaMatrix.getEnemySeaMatrix()[guessRow][guessColumn]=2;

                        System.out.println("Hits: "+guessCounter);
                        printMatrix(mySeaMatrix.getMySeaMatrix());
                        printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                        if(guessCounter==6)
                        {
                            System.out.println("You win !!! ");
                            System.exit(0);
                        }
                        continue;

                    }else
                    {
                        enemySeaMatrix.getEnemySeaMatrix()[guessRow][guessColumn]=3;
                        System.out.println("You didnt hit anything :( ");
                        break;
                    }
                }
            }
            if(choose==0){
                for( ; ; ){
                    System.out.println("Computer's guess...");
                    int guessRowAI= (int)(Math.random()*8);
                    int guessColumnAI= (int)(Math.random()*8);

                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==2){
                        continue;
                    }
                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==3){
                        continue;
                    }

                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==1){
                        System.out.println("OH NO! The computer hit your boat!!! at ["+guessRowAI+","+guessColumnAI+"]");
                        mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=2;
                        printMatrix(mySeaMatrix.getMySeaMatrix());
                        printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                        guessCounterComputer++;
                        if(guessCounterComputer ==6){
                            System.out.println("My matrix:");
                            printMatrix(mySeaMatrix.getMySeaMatrix());
                            System.out.println("Enemy matrix:");
                            printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                            System.out.println("The computer wins !!!");
                            System.exit(0);
                        }
                        continue;
                    }
                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==0){
                        System.out.println("The computer missed");
                        System.out.println("The computer guessed that your boat is at ["+guessRowAI+","+guessColumnAI+"]");
                        mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=3;
                        System.out.println("My matrix: ");
                        printMatrix(mySeaMatrix.getMySeaMatrix());
                        System.out.println("Enemy matrix: ");
                        printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                        break;
                    }
                }
            }
            if(choose == 1){
                for( ; ; )
                {
                    System.out.println("Computer guess...");
                    int guessRowAI= (int)(Math.random()*8);
                    int guessColumnAI= (int)(Math.random()*8);

                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==2){
                        continue;
                    }

                    int pom1=guessRowAI;
                    int pom2=guessColumnAI;
                    int dir=(int)(Math.random()*2);


                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==3){
                        continue;
                    }
                    if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==1)
                    {
                        System.out.println("OH NO! The computer hit your boat!!! at ["+guessRowAI+","+guessColumnAI+"]");
                        mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=2;
                        System.out.println("My matrix: ");
                        printMatrix(mySeaMatrix.getMySeaMatrix());
                        System.out.println("Enemy matrix: ");
                        printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                        guessCounterComputer++;
                        while(true){
                            if(dir==0){
                                guessColumnAI++;
                            }else if(dir==1){
                                guessColumnAI--;
                            }else{
                                dir=0;
                            }
                            if(guessRowAI>7 || guessRowAI<0 || guessColumnAI>7 || guessColumnAI<0 || mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==2){
                                dir++;
                                guessRowAI=pom1;
                                guessColumnAI=pom2;
                                break;
                            }
                            if(mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==1){
                                System.out.println("OH NO! The computer hit your boat at ["+guessRowAI+","+guessColumnAI+"]");
                                mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=2;
                                guessCounterComputer++;
                                System.out.println("My matrix: ");
                                printMatrix(mySeaMatrix.getMySeaMatrix());
                                System.out.println("Enemy matrix: ");
                                printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                                continue;
                            }else if (mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]==0){
                                mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=3;
                                System.out.println("The computer didnt hit anything.");
                                System.out.println("His try was at ["+guessRowAI+","+guessColumnAI+"]");

                                printMatrix(mySeaMatrix.getMySeaMatrix());
                                System.out.println("--------------------------------------------");
                                break;
                            }
                        }
                        if(guessCounterComputer ==6){
                            System.out.println("My matrix:");
                            printMatrix(mySeaMatrix.getMySeaMatrix());
                            System.out.println("Enemy matrix:");
                            printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                            System.out.println("The computer wins !!!");
                            System.exit(0);
                        }
                        break;
                    }else
                    {
                        mySeaMatrix.getMySeaMatrix()[guessRowAI][guessColumnAI]=3;
                        System.out.println("The computer didnt hit anything.");
                        System.out.println("His try was at ["+guessRowAI+","+guessColumnAI+"]");
                        System.out.println("My matrix:");
                        printMatrix(mySeaMatrix.getMySeaMatrix());
                        System.out.println("Enemy matrix:");
                        printMatrix(enemySeaMatrix.getEnemySeaMatrix());
                        break;
                    }
                }
            }

        }
    }
}
