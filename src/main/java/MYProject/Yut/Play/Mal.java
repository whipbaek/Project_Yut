package MYProject.Yut.Play;

public class Mal {
    private Location location;
    private Location beforelocatoin;
    private boolean straight;


    public Mal() {
        this.location = new Location(30,30);
        this.straight = true;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getBeforelocatoin() {
        return beforelocatoin;
    }

    public void setBeforelocatoin(Location beforelocatoin) {
        this.beforelocatoin = beforelocatoin;
    }

    public boolean isStraight() {
        return straight;
    }

    public void setStraight(boolean straight) {
        this.straight = straight;
    }

}
