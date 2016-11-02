package andrey019.interview.InitTests;


public class BaseClass {

    static {
        InitObj initObj = new InitObj("base static code block upper");
    }
    {
        InitObj initObj = new InitObj("base non-static code block upper");
    }

    private static InitObj obj1 = new InitObj("base static field");
    private InitObj obj2 = new InitObj("base non-static field");
    private InitObj obj3;

    public BaseClass() {
        obj3 = new InitObj("base constructor field");
    }

    static {
        InitObj initObj = new InitObj("base static code block lower");
    }

    {
        InitObj initObj = new InitObj("base non-static code block lower");
    }
}
