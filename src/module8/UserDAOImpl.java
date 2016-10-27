package module8;

import java.util.Iterator;
import java.util.List;


public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    public User saveUser(User u) {
        return save(u);
    }

    public void deleteUser(User u) {
        delete(u);
    }

    public void deleteAllFromList(List<User> userList) {
        deleteAll(userList);
    }

    public void saveAllFromList(List<User> userList) {
        saveAll(userList);
    }

    public List<User> getUserList() {
        return getList();
    }

    public void deleteUserById(long id) {
        deleteById(id);
    }

    public User findById(long id) {
        return get(id);
    }
}
