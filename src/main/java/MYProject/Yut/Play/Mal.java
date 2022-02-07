package MYProject.Yut.Play;

public class Mal {
    private Location location; // 말의 현재 위치
    private Location beforelocatoin; //전의 위치 & 말이 출발했는가
    private boolean straight; //직선으로 움직이는가
    private boolean arrive; // 말이 도착했는가
    private int group; // 해당 말이 그룹에 속해있는가(업혀 있는가)

    static public int group_num = 1;

    public Mal() {
        this.location = new Location(30, 30); //초기값은 시작점
        this.straight = true;
        this.arrive = false;
        this.group = 0;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setArrive(boolean arrive) {
        this.arrive = arrive;
    }
}
