package andrey019.interview.InitTests;


public class InitObj {

    private int someValue;

    public InitObj() {}

    public InitObj(int someValue) {
        this.someValue = someValue;
    }

    public InitObj(String text) {
        System.out.println(text);
    }

    public int getSomeValue() {
        return someValue;
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }

    @Override
    public String toString() {
        return Integer.toString(someValue);
    }
}
