package MYProject.Yut.Play;

import java.util.ArrayList;

public class Board {
 private ArrayList<Player> players;

    public Board(ArrayList<Player> players) {
        this.players = players;
    }

    public void ShowAllMalsInBoard(){
        for(int i=0; i<players.size(); i++){
            players.get(i).ShowAllMalsInfo();
        }
    }
}
