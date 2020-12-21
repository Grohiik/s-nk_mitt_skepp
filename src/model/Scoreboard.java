package model;

public class Scoreboard {
    private Player[] players;
    private int numberInBoard = 0;

    public Scoreboard(int size){
        players = new Player[size];
        addPlayer(new Player("Linnea", 50));
        addPlayer(new Player("Marcus", 40));

    }

    public boolean addPlayer(Player player){
        for (int i = 0; i < players.length; i++) {
            if(players[i] == null){
                players[i] = player;
                numberInBoard++;
                sortScoreBoard();
                return true;
            }
        }
        return false;
    }

    public String showScoreboard(){
        String out = "";
        for (int i = 0; i < players.length; i++){
            if(players[i] == null){
                break;
            }
            out += players[i].toString()+"\n";
        }
        return out;
    }

    private void sortScoreBoard(){
        int n = numberInBoard;
        Player temp;
        for(int i=0; i < n && i < 10; i++){
            for(int j=1; j < (n-i); j++){
                if(players[j-1].getScore() > players[j].getScore()){
                    temp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
}
