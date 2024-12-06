import strategies.*;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    static void printResults(int rounds, int turn, boolean move1, boolean move2, Player player1, Player player2) {
        String move1Color = move1 ? RED : GREEN;
        String move2Color = move2 ? RED : GREEN;

        System.out.printf(
                YELLOW + "Turn %d:\n" + RESET +
                        " Player 1 move: " + move1Color + "%s" + RESET + "\n" +
                        " Player 2 move: " + move2Color + "%s" + RESET + "\n" +
                        " Scores: " + CYAN + "Player 1 = %d" + RESET + ", " + CYAN + "Player 2 = %d" + RESET + "\n",
                turn,
                move1 ? "Defect" : "Cooperate",
                move2 ? "Defect" : "Cooperate",
                player1.getPoints(),
                player2.getPoints()
        );
        if (rounds != turn) System.out.println(BLUE + "----------------------------------------------" + RESET);
    }

    static void play(int rounds, Player player1, Player player2) {
        boolean move1 = player1.firstMove();
        boolean move2 = player2.firstMove();

        System.out.println(CYAN + "Starting game simulation..." + RESET);
        System.out.println(GREEN + "Player 1: " + player1.name + " | Player 2: " + player2.name + RESET);
        System.out.println(BLUE + "==============================================" + RESET);

        if (move1 && move2) {
            player1.addPoints(1);
            player2.addPoints(1);
        } else if (move1) {
            player1.addPoints(5);
            player2.addPoints(0);
        } else if (move2) {
            player1.addPoints(0);
            player2.addPoints(5);
        } else {
            player1.addPoints(3);
            player2.addPoints(3);
        }

        printResults(rounds, 1, move1, move2, player1, player2);

        boolean lastMove1 = move1;
        boolean lastMove2 = move2;

        for (int turn = 2; turn <= rounds; turn++) {
            move1 = player1.playTurn(turn, lastMove2);
            move2 = player2.playTurn(turn, lastMove1);

            if (move1 && move2) {
                player1.addPoints(1);
                player2.addPoints(1);
            } else if (move1) {
                player1.addPoints(5);
                player2.addPoints(0);
            } else if (move2) {
                player1.addPoints(0);
                player2.addPoints(5);
            } else {
                player1.addPoints(3);
                player2.addPoints(3);
            }

            printResults(rounds, turn, move1, move2, player1, player2);

            lastMove1 = move1;
            lastMove2 = move2;
        }

        System.out.println(BLUE + "==============================================" + RESET);
        System.out.println(GREEN + "Final Scores:" + RESET);
    }

    public static void main(String[] args) {
        Player player1 = new ExampleStrategy();
        Player player2 = new Graaskamp();

        play(100, player1, player2);

        System.out.println(WHITE + player1.name + " scored: " + YELLOW + player1.getPoints() + RESET);
        System.out.println(WHITE + player2.name + " scored: " + YELLOW + player2.getPoints() + RESET);
    }
}
