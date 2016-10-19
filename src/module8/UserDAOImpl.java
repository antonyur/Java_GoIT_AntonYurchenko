package module8;

import java.util.Iterator;
import java.util.List;


public class UserDAOImpl extends AbstractDAOImpl<User> {

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

    @Override
    public void deleteById(long id) {
        List<User> users = getList();
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()) {
            User user = itr.next();
            if (user.getId() == id) {
                delete(user);
                break;
            }
        }
    }

    @Override
    public User get(long id) {
        List<User> users = getList();
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }

        return null;
    }
}
