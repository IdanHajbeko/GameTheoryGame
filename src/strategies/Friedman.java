package strategies;

public class Friedman extends Player{
    public Friedman() {
        super("Friedman");
    }

    private static boolean hasDefected = false;
    @Override
    public boolean playTurn(int turn, boolean opponentLastMove) {
        if (opponentLastMove) hasDefected = true;
        return hasDefected;
    }

    @Override
    public boolean firstMove() {
        return false;
    }
}
