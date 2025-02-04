package tictactoe;

import java.util.Scanner;

class PlayerAction {

    private PlayerAction() {
        // Empêche l'instanciation
    }

    public static void playerTurn(Scanner sc, Grid grid, boolean isPlayerX) {
        String playerTurn;
        int[] playerAction;
        boolean waitTheAnswer = true;
        int moveA = -1;
        int moveB = -1;

        System.out.print(Display.yourTurn());

        while(waitTheAnswer) {
            playerTurn = sc.nextLine();
            if(!isNumber(playerTurn)) {
                System.out.print(Display.isNotNumber());
                continue;
            };

            playerAction = translatePlayerAction(playerTurn);
            moveA = playerAction[0];
            moveB = playerAction[1];

            if(!isBetweenOneAndThree(moveA, moveB)) {
                System.out.print(Display.isNotBetweenOneAndThree());
                System.out.print(moveA);
                System.out.print(moveB);
                continue;
            };

            if(!isCellEmpty(grid, moveA, moveB)) {
                System.out.print(Display.isNotCellEmpty());
                continue;
            }
            waitTheAnswer = false;
        }

        grid.setCell(moveA, moveB, whoIsPlaying(isPlayerX));
    }

    public static int[] translatePlayerAction(String playerTurn) {
        String[] toArray = playerTurn.split(" ");
        int[] toIntArray = new int[2];
        for(int i = 0; i < 2; i++) {
            toIntArray[i] = Integer.parseInt(toArray[i]) - 1;
        }
        return toIntArray;
    }

    public static boolean isNumber(String playerTurn) {
        return playerTurn.matches("\\d \\d");
    }

    public static boolean isBetweenOneAndThree(int moveA, int moveB) {
        return (moveA >= 0 && moveA <= 2) && (moveB >= 0 && moveB <= 2);
    }

    public static boolean isCellEmpty(Grid grid, int moveA, int moveB) {
        return grid.getCell(moveA, moveB) == ' ';
    }

    public static char whoIsPlaying(boolean isPlayerX) {
        if(isPlayerX) {
            return 'X';
        } else {
            return 'O';
        }
    }
}
