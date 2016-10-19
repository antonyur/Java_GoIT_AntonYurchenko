package module8;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        for(int i=0; i<10; i++)
            userDAO.saveUser(new User(i, "Name"+i));
        System.out.println("first 10: "+userDAO);
        for(int i=0; i<5; i++)
            userDAO.saveUser(new User(i, "Name"+i));
        System.out.println("first 5 + saved equal: " + userDAO);
        for(int i=8; i<10; i++)
            userDAO.deleteUser(new User(i, "Name"+i));
        System.out.println("delete last 2 of list: "+ userDAO);
        for(int i=8; i<10; i++)
            userDAO.deleteUser(userDAO.get(i));
        System.out.println("delete the same last 2 of list: "+ userDAO);
        for(int i=5; i<8; i++)
            userDAO.deleteById(i);
        System.out.println("delete by id last 3 of list: "+ userDAO);

        userDAO.deleteById(1);
        userDAO.deleteById(3);
        System.out.println("after all deletes: "+ userDAO);

        /*AbstractDAOImpl<String> daoStr = new AbstractDAOImpl<>();

        for(int i=0; i<10; i++)
            daoStr.save("name"+i);
        System.out.println("first 10: "+daoStr);
        for(int i=0; i<5; i++)
            daoStr.save("name"+i);
        System.out.println("first 5 + saved equal: " + daoStr);
        for(int i=5; i<10; i++)
            daoStr.delete("name"+i);
        System.out.println("delete half of list: "+ daoStr);

        AbstractDAOImpl<Integer> daoInt = new AbstractDAOImpl<>();
        for(int i=0; i<10; i++)
            daoInt.save(i);
        System.out.println("first 10: "+daoInt);
        for(int i=0; i<5; i++)
            daoInt.save(i);
        System.out.println("first 5 + saved equal: " + daoInt);
        for(int i=5; i<10; i++)
            daoInt.delete(i);
        System.out.println("delete half of list: "+ daoInt);*/
    }
}
