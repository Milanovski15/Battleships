package battleships;


public class Battleships {

    public static void main(String[] args) {

        MyMatrix mySeaMatrix = new MyMatrix();
        EnemyMatrix enemySeaMatrix = new EnemyMatrix();
        GameLogic gameLogic = new GameLogic();

        gameLogic.printMatrix(mySeaMatrix.getMySeaMatrix());

        System.out.println("THE GAME HAS STARTED CAPTAIN!");
        System.out.println("Where do you want your ships to be placed?");
        System.out.println("Place one small ship with one field, one medium ship with two fields and one big ship with three fields");

        mySeaMatrix.placeCoordinatesForSmallBoat();
        gameLogic.printMatrix(mySeaMatrix.getMySeaMatrix());

        mySeaMatrix.placeCoordinatesForMediumBoat();
        gameLogic.printMatrix(mySeaMatrix.getMySeaMatrix());

        mySeaMatrix.placeCoordinatesForBigBoat();
        gameLogic.printMatrix(mySeaMatrix.getMySeaMatrix());

        enemySeaMatrix.selectEnemyMatrix();
        gameLogic.printMatrix(enemySeaMatrix.getEnemySeaMatrix());


        gameLogic.chooseGameHardnesLevel();
        gameLogic.setMatrices(mySeaMatrix, enemySeaMatrix);
        gameLogic.playTheGame();
    }
}
