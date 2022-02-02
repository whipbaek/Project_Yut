package MYProject.Yut.Play;

public class Mal {
    private Location location;
    private boolean straight;
    private boolean strat;

    public Mal(Location location) {
        this.location = location;
        this.straight = true;
        this.strat = false;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isStraight() {
        return straight;
    }

    public void setStraight(boolean straight) {
        this.straight = straight;
    }

    public boolean isStrat() {
        return strat;
    }

    public void setStrat(boolean strat) {
        this.strat = strat;
    }
}
