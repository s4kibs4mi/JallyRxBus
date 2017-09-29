package ninja.sakib.pultusrxbus.text;

public class Cat {
    private String value;

    public Cat(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cat : " + value;
    }
}
