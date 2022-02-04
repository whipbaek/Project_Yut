package MYProject.Yut.Play;

import java.util.ArrayList;

public class WholeGame {
    private ArrayList<Player> players = new ArrayList<>();
    private Yut yut;
    int numofplayer;
    int numofmal;

    public WholeGame(int numofplayer, int numofmal) {
        this.numofplayer = numofplayer;
        this.numofmal = numofmal;
        MakeGame();
    }

    private void MakeGame(){ //말을 생성한다.
        for(int i=0; i<numofplayer; i++){
            players.add(i,new Player(numofmal));
        }
    }

    public void StartGame() { //Game processing

    }
}
