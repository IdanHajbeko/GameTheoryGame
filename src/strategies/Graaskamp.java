package strategies;

public class Graaskamp extends Player{
    public Graaskamp() {
        super("Graaskamp");
    }

    @Override
    public boolean playTurn(int turn, boolean opponentLastMove) {
        return turn == 50 || turn == 100 || opponentLastMove;
    }

    @Override
    public boolean firstMove() {
        return false;
    }
}
