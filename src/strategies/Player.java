package strategies;

public abstract class Player {
    private int points;
    public final String name;

    Player(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public abstract boolean playTurn(int turn, boolean opponentMove);

    public abstract boolean firstMove();
}

