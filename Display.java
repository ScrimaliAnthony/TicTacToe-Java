package tictactoe;

class Display {

    private Display() {
        // Empêche l'instanciation
    }

    public static String displayGrid(Grid grid) {
        return "---------" + "\n"
                + "|" + " " + grid.getCell(0,0) + " " + grid.getCell(0,1) + " " + grid.getCell(0,2) + " " + "|" + "\n"
                + "|" + " " + grid.getCell(1,0) + " " + grid.getCell(1,1) + " " + grid.getCell(1,2) + " " + "|" + "\n"
                + "|" + " " + grid.getCell(2,0) + " " + grid.getCell(2,1) + " " + grid.getCell(2,2) + " " + "|" + "\n"
                + "---------" + "\n";
    }

    public static String displayResult(String gameState) {
        return gameState;
    }
}
