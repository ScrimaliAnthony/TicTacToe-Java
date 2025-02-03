package tictactoe;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static int x = 0;
    static int o = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grid grid = new Grid();
        System.out.print(Display.grid(grid));
        PlayerAction.playerTurn(sc, grid);
        System.out.println("Le jeu est terminé");
        System.out.println(Display.grid(grid));

//        char[][] turn = initiateTurn();
//        String gameState = gameState(turn);
//        boolean game = true;
//
//        while(1 == 1) {
//            System.out.print(Display.displayGrid(turn));
//            XPlayerAction.playerTurn(turn);
//            if(gameState.equals("X wins") || gameState.equals("O wins") || gameState.equals("Draw")) {
//                break;
//            }
//            System.out.print(Display.displayGrid(turn));
//            System.out.print(Display.displayResult(gameState));
//            OPlayerAction.playerTurn(turn);
//            if(gameState.equals("X wins") || gameState.equals("O wins") || gameState.equals("Draw")) {
//                break;
//            }
//            System.out.print(Display.displayResult(gameState));
//        }
//
//
//        System.out.print(Display.displayGrid(turn));
//        System.out.print(Display.displayResult(gameState));
//        turn = playerTurn(turn);
//        System.out.print(Display.displayGrid(turn));
    }

//    public static char[][] initiateTurn() {
//        int n = 0;
//
//        char[][] turn = new char[3][3];
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                turn[i][j] = ' ';
//                n++;
//            }
//        }
//
//        return turn;
//    }

    public static String gameState(char[][] turn) {
        String row1 = isXRowWin(turn, 0);
        String row2 = isXRowWin(turn, 1);
        String row3 = isXRowWin(turn, 2);

        String col1 = isXColWin(turn, 0);
        String col2 = isXColWin(turn, 1);
        String col3 = isXColWin(turn, 2);

        String diag = isXDiagWin(turn);

        int countXWin = countXWin(row1, row2, row3, col1, col2, col3, diag);
        int countOWin = countOWin(row1, row2, row3, col1, col2, col3, diag);

        if (countXWin > 0 && countOWin > 0) {
            return "Impossible\n";
        } else if(countXWin == 1) {
            return "X wins\n";
        } else if (countOWin == 1) {
            return "O wins\n";
        } else if (countXWin > 1 || countOWin > 1) {
            return "Impossible\n";
        }

        if (x > o && x - o > 1) {
            return "Impossible\n";
        } else if (o > x && o - x > 1) {
            return "Impossible\n";
        }

        if(x + o == 9) {
            return "Draw\n";
        } else if(x + o != 9){
            return "Game not finished\n";
        }

        return "erreur\n";
    }

    public static String isXRowWin(char[][] turn, int i) {
        int xRow = 0;
        int oRow = 0;

        for (int j = 0; j < 3; j++) {
            if(turn[i][j] == 'X'){
                xRow++;
                Main.x++;
            } else if (turn[i][j] == 'O') {
                oRow++;
                Main.o++;
            }

            if(xRow == 3) {
                return "X wins";
            }
            if (oRow == 3) {
                return "O wins";
            }
        }
        return "No wins";
    }

    public static String isXColWin(char[][] turn, int i) {
        int xCol = 0;
        int oCol = 0;

        for (int j = 0; j < 3; j++) {
            if(turn[j][i] == 'X') {
                xCol++;
            } else if (turn[j][i] == 'O') {
                oCol++;
            }

            if (xCol == 3) {
                return "X wins";
            } else if (oCol == 3) {
                return "O wins";
            }
        }
        return "No wins";
    }

    public static String isXDiagWin(char[][] turn) {
        if(turn[0][0] == turn[1][1] && turn[1][1] == turn[2][2]) {
            if(turn[0][0] == 'X') {
                return "X wins";
            } else if (turn[0][0] == 'O') {
                return "O wins";
            }
        } else if(turn[2][0] == turn[1][1] && turn[1][1] == turn[0][2]) {
            if(turn[2][0] == 'X') {
                return "X wins";
            } else if (turn[2][0] == 'O') {
                return "O wins";
            }
        }
        return "No wins";
    }

    public static int countXWin(String... conditions) {
        int count = 0;
        for (String condition : conditions) {
            if (Objects.equals(condition, "X wins")) {
                count++;
            }
        }
        return count;
    }

    public static int countOWin(String... conditions) {
        int count = 0;
        for (String condition : conditions) {
            if (Objects.equals(condition, "O wins")) {
                count++;
            }
        }
        return count;
    }

//    public static char[][] playerTurn(char[][] turn) {
//        Scanner sc = new Scanner(System.in);
//        String playerTurn;
//        boolean isPlay = true;
//
//        while(isPlay) {
//            System.out.print("C'est votre tour de jouer !\n");
//            playerTurn = sc.nextLine();
//            if(!playerTurn.matches("^\\d+(\\s\\d+)+$")) {
//                System.out.print("You should enter numbers!\n");
//                continue;
//            }
//            int[] playerAction = translatePlayerAction(playerTurn);
//            int moveA = playerAction[0];
//            int moveB = playerAction[1];
//            if (moveA + 1 < 1 || moveA + 1 > 3 || moveB + 1 < 1 || moveB + 1 > 3) {
//                System.out.print("Coordinates should be from 1 to 3!\n");
//                continue;
//            }
//            if (turn[moveA][moveB] == 'X' || turn[moveA][moveB] == 'O') {
//                System.out.print("This cell is occupied! Choose another one!\n");
//                continue;
//            }
//            turn[moveA][moveB] = 'X';
//            isPlay = false;
//        }
//        return turn;
//    }

//    public static int[] translatePlayerAction(String playerTurn) {
//        String[] toArray = playerTurn.split(" ");
//        int[] toIntArray = new int[2];
//        for(int i = 0; i < 2; i++) {
//            toIntArray[i] = Integer.parseInt(toArray[i]) - 1;
//        }
//        return toIntArray;
//    }
}
