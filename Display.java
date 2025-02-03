package tictactoe;

class Display {

    private Display() {
        // Empêche l'instanciation
    }

    public static String displayGrid(char[][] turn) {
        return "---------" + "\n"
                + "|" + " " + turn[0][0] + " " + turn[0][1] + " " + turn[0][2] + " " + "|" + "\n"
                + "|" + " " + turn[1][0] + " " + turn[1][1] + " " + turn[1][2] + " " + "|" + "\n"
                + "|" + " " + turn[2][0] + " " + turn[2][1] + " " + turn[2][2] + " " + "|" + "\n"
                + "---------" + "\n";

    }

    public static String displayResult(String gameState) {
        return gameState;
    }
}
