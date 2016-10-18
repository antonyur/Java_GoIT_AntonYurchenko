package module8;

import java.util.Iterator;
import java.util.List;


public class UserDAOImpl extends AbstractDAOImpl<User> {

    @Override
    public User save(User u) {
        return super.save(u);
    }

    @Override
    public void delete(User u) {
        super.delete(u);
    }

    @Override
    public void deleteAll(List<User> userList) {
        super.deleteAll(userList);
    }

    @Override
    public void saveAll(List<User> userList) {
        super.saveAll(userList);
    }

    @Override
    public List<User> getList() {
        return super.getList();
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
