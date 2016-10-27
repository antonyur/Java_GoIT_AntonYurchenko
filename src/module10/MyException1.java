package module10;

public class MyException1 extends Exception{
    //private String message1;

    public MyException1(String message) {
        //message1 = message;
        //System.out.println("Exception message inside constructor \"" + message1 +"\"");
        super(message);
    }

    //public String getMessage1() {
    //    return message1;
    //}
}
