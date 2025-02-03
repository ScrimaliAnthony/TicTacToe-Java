package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        boolean isPlayerX = true;
        String gameState;
        Grid grid = new Grid();
        System.out.print(Display.grid(grid));
        while(running) {
            PlayerAction.playerTurn(sc, grid, isPlayerX);
            System.out.print(Display.grid(grid));
            gameState = GameState.getGameState(grid);
            System.out.println(gameState);
            isPlayerX = !isPlayerX;
            if(gameState.equals(Display.xWins()) || gameState.equals(Display.oWins()) || gameState.equals(Display.draw())) {
                running = false;
            }
        }
    }
}
