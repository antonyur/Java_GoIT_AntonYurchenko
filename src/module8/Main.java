package module8;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        for(int i=0; i<10; i++)
            userDAOImpl.saveUser(new User(i, "Name"+i));
        System.out.println("first 10: "+userDAOImpl);
        for(int i=0; i<5; i++)
            userDAOImpl.saveUser(new User(i, "Name"+i));
        System.out.println("first 5 + saved equal: " + userDAOImpl);
        for(int i=8; i<10; i++)
            userDAOImpl.deleteUser(new User(i, "Name"+i));
        System.out.println("delete last 2 of list: "+ userDAOImpl);
        for(int i=8; i<10; i++)
            userDAOImpl.deleteUser(userDAOImpl.findById(i));
        System.out.println("delete the same last 2 of list: "+ userDAOImpl);
        for(int i=5; i<8; i++)
            userDAOImpl.deleteUserById(i);
        System.out.println("delete by id last 3 of list: "+ userDAOImpl);

        userDAOImpl.deleteUserById(1);
        userDAOImpl.deleteUserById(3);
        System.out.println("after all deletes: "+ userDAOImpl);
    }
}
