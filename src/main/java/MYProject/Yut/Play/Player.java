package MYProject.Yut.Play;

public class Player {
    private Mal mal;

    public Player(Mal mal) { //말을 셋팅한다.
        this.mal = mal;
    }

    public Mal getMal() {
        return mal;
    }

    public void setMal(Mal mal) {
        this.mal = mal;
    }
}
