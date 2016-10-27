package module8;


import java.util.List;

public interface UserDAO {
    User saveUser(User u);

    void deleteUser(User u);

    void deleteAllFromList(List<User> userList);

    void saveAllFromList(List<User> userList);

    List<User> getUserList();

    void deleteUserById(long id);

    User findById(long id);
}
