package module8;

public class Main {
    public static void main(String[] args) {
        AbstractDAOImpl<String> daoStr = new AbstractDAOImpl<>();
        for(int i=0; i<10; i++)
            daoStr = new AbstractDAOImpl<>();
        for(int i=0; i<10; i++)
            daoStr.save("name"+i);
        System.out.println("first 10: "+daoStr);
        for(int i=0; i<5; i++)
            daoStr.save("name"+i);
        System.out.println("first 10 + saved equal: " + daoStr);
        for(int i=5; i<10; i++)
            daoStr.delete("name"+i);
        System.out.println("delete half of list: "+ daoStr);

        AbstractDAOImpl<Integer> daoInt = new AbstractDAOImpl<>();
        for(int i=0; i<10; i++)
            daoInt.save(i);
        System.out.println("first 10: "+daoInt);
        for(int i=0; i<5; i++)
            daoInt.save(i);
        System.out.println("first 10 + saved equal: " + daoInt);
        for(int i=5; i<10; i++)
            daoInt.delete(i);
        System.out.println("delete half of list: "+ daoInt);
    }
}
