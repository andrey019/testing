package andrey019.interview.InitTests;


public class ChildClass extends BaseClass {

    static {
        InitObj initObj = new InitObj("child static code block upper");
    }
    {
        InitObj initObj = new InitObj("child non-static code block upper");
    }

    private static InitObj obj1 = new InitObj("child static field");
    private InitObj obj2 = new InitObj("child non-static field");
    private InitObj obj3;

    public ChildClass() {
        obj3 = new InitObj("child constructor field");
    }

    static {
        InitObj initObj = new InitObj("child static code block lower");
    }

    {
        InitObj initObj = new InitObj("child non-static code block lower");
    }
}
