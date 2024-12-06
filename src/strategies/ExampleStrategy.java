package strategies;

public class ExampleStrategy extends Player {
    // true - defection
    // false - corporation
    public ExampleStrategy() {
        super("name");
    }

    @Override
    public boolean playTurn(int turn, boolean opponentLastMove) {
        // your strategy here
        return turn % 10 == 0; // this simple strategy will do defection one every 10 times and will corporate the other 9
    }

    @Override
    public boolean firstMove() {
        // choose your first move here
        return true;
    }
}
