package MYProject.Yut.Play;

public class Mal implements Mal_I{
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

    public void initializeMal(Mal mal){ //말이 상대방에게 잡혔을때 관련 정보들으 초기화해주는 메소드
        mal.getLocation().setX(30);
        mal.getLocation().setY(30);
        
        mal.setStraight(true);
        mal.setArrive(false);

        mal.setBeforelocatoin(null);
        mal.setGroup(0);
    }

    @Override
    public boolean isExistMalInField(){ //말이 필드에 존재하는가?
        if(this.getBeforelocatoin() != null && !this.isArrive()) return true;
        return false;
    }

    @Override
    public boolean isSameGroup(Mal mal){ //말의 그룹이 같은가? (업혀있는가?)
        if(this.getGroup() == mal.getGroup()) return true;
        return false;
    }

    @Override
    public boolean isSameLocation (Mal mal1, Mal mal2){ //두 말의 위치가 같은가? (잡기시에 사용)
        if(isSamePosition(mal1.getLocation(),mal2.getLocation())) return true;
        return false;
    }

    @Override
    public boolean isSamePosition(Location location1, Location location2){ //두 location이 같은가?
        if(location1.getX() == location2.getX() && location1.getY() == location2.getY()) return true;
        return false;
    }

    @Override
    public boolean isMalArrive(int count){
        if(this.getBeforelocatoin() != null &&
           this.getLocation().getX()==30 && this.getLocation().getY()==30 &&
           count > 0) {
            this.setArrive(true);
            return true;
        }
        return false;
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
