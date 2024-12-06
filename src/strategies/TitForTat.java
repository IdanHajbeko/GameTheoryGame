package strategies;

public class TitForTat extends Player {
    public TitForTat() {
        super("tit for tat");
    }

    @Override
    public boolean playTurn(int turn, boolean opponentLastMove) {
        return opponentLastMove;
    }

    @Override
    public boolean firstMove() {
        return false;
    }
}
