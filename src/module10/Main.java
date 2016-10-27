package module10;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Task1
        try{
            throw new Exception("Test exception in the first try block of Main class");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Finally of the first try block of Main class");
        }


        //Task2
        try{
            throw new MyException1("Test2, MyException in the second try block of Main class");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Task3
        String testVar = null;
        try{
            testVar.compareTo("Test");
        }
        catch (Exception e){
            System.out.println("catch of the 3rd try block od Main class");
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        //Task4
        try {
            TestMethods.g();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            TestMethods.f();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Task5
        try {
            Random randomGenerator = new Random();
            for (int i=1; i < 10; i++ ){
                int randomInt = 3 + randomGenerator.nextInt(3);
                TestMethods.threeEx(randomInt);
            }
        }
        catch(MyException3 | MyException4 | MyException5 e){
            System.out.println(e.getMessage());
        }
    }
}

