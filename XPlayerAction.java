package tictactoe;

import java.util.Scanner;

public class XPlayerAction {

    public static char[][] playerTurn(char[][] turn) {
        Scanner sc = new Scanner(System.in);
        String playerTurn;
        boolean isPlay = true;

        while(isPlay) {
            System.out.print("C'est votre tour de jouer !\n");
            playerTurn = sc.nextLine();
            if(!playerTurn.matches("^\\d+(\\s\\d+)+$")) {
                System.out.print("You should enter numbers!\n");
                continue;
            }
            int[] playerAction = Main.translatePlayerAction(playerTurn);
            int moveA = playerAction[0];
            int moveB = playerAction[1];
            if (moveA + 1 < 1 || moveA + 1 > 3 || moveB + 1 < 1 || moveB + 1 > 3) {
                System.out.print("Coordinates should be from 1 to 3!\n");
                continue;
            }
            if (turn[moveA][moveB] == 'X' || turn[moveA][moveB] == 'O') {
                System.out.print("This cell is occupied! Choose another one!\n");
                continue;
            }
            turn[moveA][moveB] = 'X';
            isPlay = false;
        }
        return turn;
    }
}
