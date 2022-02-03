package MYProject.Yut.Play;

public enum Yut_Grade {
    도(1),개(2),걸(3),윷(4),모(5),백도(1);

    private final int value;

    Yut_Grade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
