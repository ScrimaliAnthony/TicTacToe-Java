package tictactoe;

class Display {

    private Display() {
        // Empêche l'instanciation
    }

    public static String grid(Grid grid) {
        return "---------" + "\n"
                + "|" + " " + grid.getCell(0,0) + " " + grid.getCell(0,1) + " " + grid.getCell(0,2) + " " + "|" + "\n"
                + "|" + " " + grid.getCell(1,0) + " " + grid.getCell(1,1) + " " + grid.getCell(1,2) + " " + "|" + "\n"
                + "|" + " " + grid.getCell(2,0) + " " + grid.getCell(2,1) + " " + grid.getCell(2,2) + " " + "|" + "\n"
                + "---------" + "\n";
    }

    public static String result(String gameState) {
        return gameState;
    }

    public static String yourTurn() {
        return "It's your turn to play!\n";
    }

    public static String isNotNumber() {
        return "You should enter numbers!\n";
    }

    public static String isNotBetweenOneAndThree() {
        return "Coordinates should be from 1 to 3!\n";
    }

    public static String isNotCellEmpty() {
        return "This cell is occupied! Choose another one!\n";
    }
}
