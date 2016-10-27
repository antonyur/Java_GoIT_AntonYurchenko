package module10;


public class TestMethods {
    public static void g() throws MyException1{
        throw new MyException1("MyException1 in the g() method of TestMethods class");
    }

    public static void f() throws MyException2{
        try{
            g();
        }
        catch(MyException1 e) {
            throw new MyException2("MyException2 in the f() method of TestMethods class");
        }
    }

    public static void threeEx(int exNumber) throws MyException3, MyException4, MyException5{
        switch(exNumber){
            case 3: throw new MyException3("MyException3 in the threeEx method of TestMethods class");
            case 4: throw new MyException4("MyException4 in the threeEx method of TestMethods class");
            case 5: throw new MyException5("MyException5 in the threeEx method of TestMethods class");
            default: break;
         }
    }
}
