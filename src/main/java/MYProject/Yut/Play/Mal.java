package MYProject.Yut.Play;

public class Mal {
    private Location location;
    private Location beforelocatoin;
    private boolean straight;
    private boolean arrive;


    public Mal() {
        this.location = new Location(30,30);
        this.straight = true;
        this.arrive = false;
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

    public boolean isArrive() {
        return arrive;
    }

    public void setArrive(boolean arrive) {
        this.arrive = arrive;
    }
}
