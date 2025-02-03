package tictactoe;

import java.util.Objects;

public class GameState {
    static int x = 0;
    static int o = 0;

    private GameState() {
        // Empêche l'instanciation
    }

    public static String getGameState(Grid grid) {
        x = 0;
        o = 0;
        String row1 = isXRowWin(grid, 0);
        String row2 = isXRowWin(grid, 1);
        String row3 = isXRowWin(grid, 2);

        String col1 = isXColWin(grid, 0);
        String col2 = isXColWin(grid, 1);
        String col3 = isXColWin(grid, 2);

        String diag = isXDiagWin(grid);

        int countXWin = countXWin(row1, row2, row3, col1, col2, col3, diag);
        int countOWin = countOWin(row1, row2, row3, col1, col2, col3, diag);

        if (countXWin > 0 && countOWin > 0) {
            return Display.impossibleGameState();
        } else if(countXWin == 1) {
            return Display.xWins();
        } else if (countOWin == 1) {
            return Display.oWins();
        } else if (countXWin > 1 || countOWin > 1) {
            return Display.impossibleGameState();
        }

        if (x > o && x - o > 1) {
            return Display.impossibleGameState();
        } else if (o > x && o - x > 1) {
            return Display.impossibleGameState();
        }

        if(x + o == 9) {
            return Display.draw();
        } else if(x + o != 9){
            return Display.continueGameState();
        }
        return "erreur";
    }

    public static String isXRowWin(Grid grid, int i) {
        int xRow = 0;
        int oRow = 0;

        for (int j = 0; j < 3; j++) {
            if(grid.getCell(i, j) == 'X'){
                xRow++;
                x++;
            } else if (grid.getCell(i, j) == 'O') {
                oRow++;
                o++;
            }

            if(xRow == 3) {
                return Display.xWins();
            }
            if (oRow == 3) {
                return Display.oWins();
            }
        }
        return Display.noWinsGameState();
    }

    public static String isXColWin(Grid grid, int i) {
        int xCol = 0;
        int oCol = 0;

        for (int j = 0; j < 3; j++) {
            if(grid.getCell(j, i) == 'X') {
                xCol++;
            } else if (grid.getCell(j, i) == 'O') {
                oCol++;
            }

            if (xCol == 3) {
                return Display.xWins();
            } else if (oCol == 3) {
                return Display.oWins();
            }
        }
        return Display.noWinsGameState();
    }

    public static String isXDiagWin(Grid grid) {
        if(grid.getCell(0,0) == grid.getCell(1,1) && grid.getCell(1,1) == grid.getCell(2,2)) {
            if(grid.getCell(0,0) == 'X') {
                return Display.xWins();
            } else if (grid.getCell(0,0) == 'O') {
                return Display.oWins();
            }
        } else if(grid.getCell(2,0) == grid.getCell(1,1) && grid.getCell(1,1) == grid.getCell(0,2)) {
            if(grid.getCell(2,0) == 'X') {
                return Display.xWins();
            } else if (grid.getCell(2,0) == 'O') {
                return Display.oWins();
            }
        }
        return Display.noWinsGameState();
    }

    public static int countXWin(String... conditions) {
        int count = 0;
        for (String condition : conditions) {
            if (Objects.equals(condition, Display.xWins())) {
                count++;
            }
        }
        return count;
    }

    public static int countOWin(String... conditions) {
        int count = 0;
        for (String condition : conditions) {
            if (Objects.equals(condition, Display.oWins())) {
                count++;
            }
        }
        return count;
    }
}
