package model;

public class Player {
    private String name;
    private int score;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name+ ": "+score;
    }

    public int getScore() {
        return score;
    }
}
