package andrey019.interview.InitTests;


public class InitOrder {

    private static InitObj initObj = new InitObj("static field");
    private InitObj initObj1 = new InitObj("non-static field");

    static {
        InitObj initObj = new InitObj("static block");
    }
    {
        InitObj initObj = new InitObj("non-static block");
    }

    public InitOrder() {
        InitObj initObj = new InitObj("constructor");
    }

    public static void main(String args[]) {
        //BaseClass baseClass = new BaseClass();
        //ChildClass childClass = new ChildClass();
        //LowerChildClass lowerChildClass = new LowerChildClass();

        System.out.println("ololo");
        InitOrder initOrder = new InitOrder();
        
    }
}
