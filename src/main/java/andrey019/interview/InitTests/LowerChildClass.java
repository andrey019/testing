package andrey019.interview.InitTests;


public class LowerChildClass extends ChildClass {

    static {
        InitObj initObj = new InitObj("lower child static code block upper");
    }
    {
        InitObj initObj = new InitObj("lower child non-static code block upper");
    }

    private static InitObj obj1 = new InitObj("lower child static field");
    private InitObj obj2 = new InitObj("lower child non-static field");
    private InitObj obj3;

    public LowerChildClass() {
        obj3 = new InitObj("lower child constructor field");
    }

    static {
        InitObj initObj = new InitObj("lower child static code block lower");
    }

    {
        InitObj initObj = new InitObj("lower child non-static code block lower");
    }
}
