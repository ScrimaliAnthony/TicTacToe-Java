package tictactoe;

class Grid {
    private char[][] grid = new char[3][3];

    public Grid() {
        int n = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grid[i][j] = ' ';
                n++;
            }
        }
    }

    public char[][] getGrid() {
        return this.grid;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(int row, int col, char value) {
        grid[row][col] = value;
    }
}
