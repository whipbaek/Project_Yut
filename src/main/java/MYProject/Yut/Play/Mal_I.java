package MYProject.Yut.Play;

public interface Mal_I {

    public void initializeMal(Mal mal);
    public boolean isExistMalInField();
    public boolean isSameGroup(Mal mal1, Mal mal2);
    public boolean isSameLocation (Mal mal1, Mal mal2);
    public boolean isSamePosition(Location location1, Location location2);
    public boolean isMalArrive(int count);

    }
