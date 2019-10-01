package battleships;
import java.util.Scanner;

public class Battleships {

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
     
    public static void main(String[] args) {
       
        //int [ ] [ ] sea = new int [ 8 ] [ 8 ] ; 
        int sea1[][] = { {0,0,0,0,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0 }, 
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0} }; 
        int[][] pom = { {0,0,0,0,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0 }, 
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0} }; 
        
        int seaAIcombination1[][] = { {0,1,1,1,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0 }, 
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,1,1 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,1,0,0,0,0 },
                        {0,0,0,0,0,0,0,0} };
        
        int seaAIcombination2[][] = { {0,0,0,0,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0 }, 
                        {0,1,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,1,1,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,1,1,1,0,0,0} };
        
        int seaAIcombination3[][] = { {0,0,0,0,0,0,0,0}, 
                        {1,1,0,0,0,0,0,0 }, 
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,1,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,1,1,1,0 },
                        {0,0,0,0,0,0,0,0} };
        
        int seaAIcombination4[][] = { {0,0,0,0,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0 }, 
                        {0,0,1,1,1,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,1,0,0,0 },
                        {0,1,1,0,0,0,0,0} };
        
        int seaAIcombination5[][] = { {0,0,0,0,0,0,0,1}, 
                        {0,1,1,1,0,0,0,0 }, 
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,0,0,0 },
                        {0,0,0,0,0,1,1,0 },
                        {0,0,0,0,0,0,0,0} };
        
    
        printMatrix(sea1);
        
        
        System.out.print("Where do you want your ship to be placed? \n");
        System.out.println("Place one ship with one field, one ship with two fields and one ship with three fields");
        
        
        Scanner scan = new Scanner(System.in);
        
        //brod so edna kocka
        System.out.println("One field ship \n");
        System.out.print("Row: ");
        int rowMal = scan.nextInt();
        System.out.print("Column: ");
        int columnMal= scan.nextInt();
        while(true){
            if(rowMal < 0 || rowMal>7 || columnMal>7 || columnMal<0){
                System.out.println("Enter a number between 0 and 7");
                rowMal = scan.nextInt();
                columnMal= scan.nextInt();
            }else{
                break;
            }
        }
  
        
        sea1[rowMal][columnMal]=1;
        
        printMatrix(sea1);        

        

        //brod so dve kocki
        System.out.println("Two field ship \n");
        System.out.print("Row of the first field: ");
        int rowSreden = scan.nextInt();
        System.out.print("Column of the first field: ");
        int columnSreden = scan.nextInt();
        
                    //vtor blok od brod so dve kocki
        while(true){
            if(columnSreden >= 7 || rowSreden < 0 || rowSreden>7  || columnSreden<0  
               || (rowSreden== rowMal && columnSreden== columnMal) ||(rowSreden== rowMal && columnSreden+1== columnMal)){
                    System.out.println("Enter a number smaller than 7 or there is a boat in that field ");
                    rowSreden=scan.nextInt();
                    columnSreden=scan.nextInt();
            } else {
                break;
            }
        }
        sea1[rowSreden][columnSreden]=1;
        sea1[rowSreden][columnSreden+1]=1;
        
        printMatrix(sea1);

        //brod so tri kocki
        System.out.println("Three field ship  \n");
        System.out.print("Row of the first field: ");
        int rowGolem = scan.nextInt();
        System.out.print("Column of the first field: ");
        int columnGolem= scan.nextInt();
        
        while(true){
             if(columnGolem >=6  || rowGolem < 0 || rowGolem>7 || columnGolem<0
               || sea1[rowGolem][columnGolem]==1 || (columnGolem+1<=7 && sea1[rowGolem][columnGolem+1]==1) 
               || (columnGolem+2<=7 && sea1[rowGolem][columnGolem+2]==1) || (columnGolem+3<=7 && sea1[rowGolem][columnGolem+3]==1)){
                    System.out.println("Enter a number smaller than 6 or there is a ship in that field ");
                     printMatrix(sea1);
                    rowGolem=scan.nextInt();
                    columnGolem=scan.nextInt();
                }
            else {
                break;
            }
        }
    
        sea1[rowGolem][columnGolem]=1;
        sea1[rowGolem][columnGolem+1]=1;
        sea1[rowGolem][columnGolem+2]=1;
        
        printMatrix(sea1);
        
        
        int randSelection=(int)(Math.random()*5+1);
        
         switch (randSelection) {
             case 1:
                 for(int i=0; i<8; i++)
                     for(int j=0; j<8; j++)
                         pom[i][j]=seaAIcombination1[i][j];
                 break;
             case 2:
                 for(int i=0; i<8; i++)
                     for(int j=0; j<8; j++)
                         pom[i][j]=seaAIcombination2[i][j];
                 break;
             case 3:
                 for(int i=0; i<8; i++)
                     for(int j=0; j<8; j++)
                         pom[i][j]=seaAIcombination3[i][j];
                 break;
             case 4:
                 for(int i=0; i<8; i++)
                     for(int j=0; j<8; j++)
                         pom[i][j]=seaAIcombination4[i][j];
                 break;
             case 5:
                 for(int i=0; i<8; i++)
                     for(int j=0; j<8; j++)
                         pom[i][j]=seaAIcombination5[i][j];
                 break;
             default:
                 break;
         }
        
        System.out.println("BATTLESHIPS PLACED!!!");
        System.out.println("Choose the level of hardness 0-easy 1-hard");
        int choose=scan.nextInt();
        
        
            
        
        printMatrix(sea1);
        printMatrix(pom);
        
        
        int guessCounter=0;
        int guessCounterAI=0;
        
        /*int bullsEye;
        int bullsEye1;*/
        
        for( ; ; ){
            for( ; ; )
            {
                System.out.println("Where do you think that the AI has a ship?");
                
                
                int guessRow= scan.nextInt();
                int guessColumn=scan.nextInt();
                
                
                if(guessRow > 7 || guessColumn > 7 || guessRow <0 || guessColumn < 0){
                    System.out.println("Enter a number betwenn 0 and 7");
                }else{
                    if(pom[guessRow][guessColumn]==3){
                        System.out.println("You already guessed this field and missed");
                        continue;
                    }
                    if(pom[guessRow][guessColumn]==2){
                        System.out.println("You already guessed this field and hit");
                        continue;
                    }
                    if(pom[guessRow][guessColumn]==1)
                    {
                        System.out.println("You hit the AI boat!!! at ["+guessRow+","+guessColumn+"]");
                        guessCounter++;
                        pom[guessRow][guessColumn]=2;

                        System.out.println("Hits: "+guessCounter);
                        printMatrix(sea1);
                        printMatrix(pom);
                        if(guessCounter==6)
                        {
                            System.out.println("You win !!! ");
                            System.exit(0);
                        }
                        continue;

                    }else
                    {
                        pom[guessRow][guessColumn]=3;
                        System.out.println("You didnt hit anything :( ");
                        break;
                    }
                }
            }
            if(choose==0){
                for( ; ; ){
                    //daj mu da gagja random i napravi so trojkite
                    System.out.println("Ais guess");
                    int guessRowAI= (int)(Math.random()*8);
                    int guessColumnAI= (int)(Math.random()*8);
                    
                    if(sea1[guessRowAI][guessColumnAI]==2){
                        continue;
                    }
                     if(sea1[guessRowAI][guessColumnAI]==3){
                        continue;
                    }

                    if(sea1[guessRowAI][guessColumnAI]==1){ 
                        System.out.println("The AI hit your boat!!! at ["+guessRowAI+","+guessColumnAI+"]");
                        sea1[guessRowAI][guessColumnAI]=2;
                        printMatrix(sea1);
                        printMatrix(pom);
                        guessCounterAI++;
                        System.out.println(guessCounterAI);
                        if(guessCounterAI==6){
                            printMatrix(sea1);
                            printMatrix(pom);
                            System.out.println("The AI wins !!!");
                            System.exit(0);
                        }     
                        continue;
                    }
                    if(sea1[guessRowAI][guessColumnAI]==0){ 
                        System.out.println("The AI missed");
                         System.out.println("The AI guess your boat is at ["+guessRowAI+","+guessColumnAI+"]");
                        sea1[guessRowAI][guessColumnAI]=3;
                        printMatrix(sea1);
                        printMatrix(pom);
                        break;
                    }           
                }
            }
            if(choose == 1){
                for( ; ; )
                {
                    System.out.println("Ais guess");
                    int guessRowAI= (int)(Math.random()*8);
                    int guessColumnAI= (int)(Math.random()*8);

                    if(sea1[guessRowAI][guessColumnAI]==2){
                        continue;
                    }

                    int pom1=guessRowAI;
                    int pom2=guessColumnAI;
                    int dir=(int)(Math.random()*2);
                    
                    
                    if(sea1[guessRowAI][guessColumnAI]==3){
                        continue;
                    }
                    if(sea1[guessRowAI][guessColumnAI]==1)
                    {
                        System.out.println("The AI hit your boat!!! at ["+guessRowAI+","+guessColumnAI+"]");
                        sea1[guessRowAI][guessColumnAI]=2;
                        printMatrix(sea1);
                        printMatrix(pom);
                        guessCounterAI++;
                        while(true){
                            if(dir==0){
                                guessColumnAI++;
                            }else if(dir==1){
                                guessColumnAI--;
                            }else{
                                dir=0;
                            }
                            if(guessRowAI>7 || guessRowAI<0 || guessColumnAI>7 || guessColumnAI<0 || sea1[guessRowAI][guessColumnAI]==2){
                                dir++;
                                guessRowAI=pom1;
                                guessColumnAI=pom2;
                                break;
                            }
                            if(sea1[guessRowAI][guessColumnAI]==1){
                                System.out.println("The AI hit your boat!!! at ["+guessRowAI+","+guessColumnAI+"]");
                                sea1[guessRowAI][guessColumnAI]=2;
                                guessCounterAI++;
                                printMatrix(sea1);
                                printMatrix(pom);
                                continue;
                            }else if (sea1[guessRowAI][guessColumnAI]==0){
                                sea1[guessRowAI][guessColumnAI]=3;
                                System.out.println("The AI didnt hit anything.");
                                System.out.println("His try was at ["+guessRowAI+","+guessColumnAI+"]");
                               
                                printMatrix(sea1);
                                break;
                            }
                        }
                        if(guessCounterAI==6){
                            printMatrix(sea1);
                            printMatrix(pom);
                            System.out.println("The AI wins !!!");
                            System.exit(0);
                        }
                        break;
                    }else
                    {
                        sea1[guessRowAI][guessColumnAI]=3;
                        System.out.println("The AI didnt hit anything.");
                        System.out.println("His try was at ["+guessRowAI+","+guessColumnAI+"]");
                        printMatrix(sea1); 
                        printMatrix(pom);
                        break;
                    }
                }
            }
            
        }
        
    }
    
}
