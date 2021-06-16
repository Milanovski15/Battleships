package battleships;

public class EnemyMatrix {

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

    public void selectEnemyMatrix(){
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
    }

    public int[][] getEnemySeaMatrix(){
        return pom;
    }
}
