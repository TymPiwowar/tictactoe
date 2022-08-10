import java.util.Scanner;


public class Tictactoe {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Boolean[][] cellOccupied = new Boolean[3][3]; //matrix checking if cell is occupied
        char[][] matrix = new char[3][3]; // matrix with X and O

        createCellOccupied(cellOccupied); //create matrix with false at every field

        createEmptyMatrix(matrix); //creating empty matrix for better visual effect in tests

        finalResult(matrix, cellOccupied); // final result

    }

    public static void finalResult(char[][] matrix, Boolean[][] cellOccupied) {
        printMap(matrix);
        int i = 1; // X starts and then goes O
        while (currentResult(matrix).equals("Game not finished")) { //checking game status
            if (i % 2 != 0) {
                putCharX(matrix, cellOccupied); //put X on field if it is not occupied
                i += 1;
            } else {
                putCharO(matrix, cellOccupied); //put O on field if it is not occupied
                i += 1;
            }
            printMap(matrix); // printing map after every move
        }
        System.out.println(currentResult(matrix)); // printing result - who wins
    }

    public static void createCellOccupied(Boolean[][] cellOccupied) { //create matrix with false at every field
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellOccupied[i][j] = false;
            }
        }
    }

    public static void createEmptyMatrix(char[][] matrix) { //creating empty matrix for better visual effects
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public static void putCharX(char[][] matrix, Boolean[][] cellOccupied) {
        boolean good = false;
        while (!good) {
            String x = scanner.next();
            String y = scanner.next();
            if (!isNumeric(x)) { //checking if string is number
                System.out.println("You should enter numbers!");
            } else {
                if (Integer.parseInt(x) > 3 || Integer.parseInt(x) < 1 || Integer.parseInt(y) > 3 || Integer.parseInt(y) < 1) { //checking if coordinates are valid
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (cellOccupied[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1]) { //checking if field is occupied
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    cellOccupied[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] = true; //filling cellOccupied matrix with true on proper field
                    matrix[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] = 'X'; //putting X on field
                    good = true;
                }
            }
        }
    }

    public static void putCharO(char[][] matrix, Boolean[][] cellOccupied) { //same with X
        boolean good = false;
        while (!good) {
            String x = scanner.next();
            String y = scanner.next();
            if (!isNumeric(x)) {
                System.out.println("You should enter numbers!");
            } else {
                if (Integer.parseInt(x) > 3 || Integer.parseInt(x) < 1 || Integer.parseInt(y) > 3 || Integer.parseInt(y) < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (cellOccupied[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1]) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    cellOccupied[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] = true;
                    matrix[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] = 'O';
                    good = true;
                }
            }
        }
    }

    public static boolean isNumeric(String strNum) { //function checking if string is numeric
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void printMap(char[][] matrix) { //printing map
        System.out.println("---------");
        System.out.println("| " + matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + " |");
        System.out.println("| " + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + " |");
        System.out.println("| " + matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2] + " |");
        System.out.println("---------");
    }


    public static String currentResult(char[][] matrix) { //checking current result on map
        boolean impossible = false;
        boolean xWin = false;
        boolean oWin = false;
        boolean notFinished = false;
        boolean draw = false;
        int numOfX = 0;
        int numOfO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'X') {
                    numOfX += 1;
                } else if (matrix[i][j] == 'O') {
                    numOfO += 1;
                }
            }
        }

        if (Math.abs(numOfO - numOfX) != 1 && Math.abs(numOfO - numOfX) != 0) {
            impossible = true;
        } else {
            if (matrix[0][0] == 'X' && matrix[0][1] == 'X' && matrix[0][2] == 'X') {
                xWin = true;
            } else if (matrix[1][0] == 'X' && matrix[1][1] == 'X' && matrix[1][2] == 'X') {
                xWin = true;
            } else if (matrix[2][0] == 'X' && matrix[2][1] == 'X' && matrix[2][2] == 'X') {
                xWin = true;
            } else if (matrix[0][0] == 'X' && matrix[1][0] == 'X' && matrix[2][0] == 'X') {
                xWin = true;
            } else if (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') {
                xWin = true;
            } else if (matrix[0][1] == 'X' && matrix[1][1] == 'X' && matrix[2][1] == 'X') {
                xWin = true;
            } else if (matrix[0][2] == 'X' && matrix[1][2] == 'X' && matrix[2][2] == 'X') {
                xWin = true;
            } else if (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X') {
                xWin = true;
            }
            if (matrix[0][0] == 'O' && matrix[0][1] == 'O' && matrix[0][2] == 'O') {
                oWin = true;
            } else if (matrix[1][0] == 'O' && matrix[1][1] == 'O' && matrix[1][2] == 'O') {
                oWin = true;
            } else if (matrix[2][0] == 'O' && matrix[2][1] == 'O' && matrix[2][2] == 'O') {
                oWin = true;
            } else if (matrix[0][0] == 'O' && matrix[1][0] == 'O' && matrix[2][0] == 'O') {
                oWin = true;
            } else if (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') {
                oWin = true;
            } else if (matrix[0][1] == 'O' && matrix[1][1] == 'O' && matrix[2][1] == 'O') {
                oWin = true;
            } else if (matrix[0][2] == 'O' && matrix[1][2] == 'O' && matrix[2][2] == 'O') {
                oWin = true;
            } else if (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O') {
                oWin = true;
            } else if (numOfX + numOfO < 9) {
                notFinished = true;
            } else {
                draw = true;
            }
        }
        if (oWin && xWin || impossible) {
            return "Impossible";
        } else if (oWin) {
            return "O wins";
        } else if (xWin) {
            return "X wins";
        } else if (notFinished) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }
}