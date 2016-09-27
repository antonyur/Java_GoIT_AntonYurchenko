package module6;

public class UserUtils {
    public static User[] uniqueUsers(User[] users)
    {
        User[] unique = new User[users.length];
        int countUnique = 0;
        for (User user : users) {
            boolean found = false;
            for (User user1 : unique) {
                if (user1 == null)
                    break;
                if (user1.equals(user))
                {
                    found = true;
                    break;
                }
            }

            if (!found){
                unique[countUnique] = user;
                countUnique++;
            }
        }

        User[] result = new User[countUnique];
        for(int i=0; i<countUnique; i++)
            result[i] = unique[i];

        return result;
    }

    public static User[] usersWithContitionalBalance(User[] users, int balance)
    {
        User[] temp = new User[users.length];
        int count = 0;
        for (User user : users){
            if (user != null && user.getBalance() >= balance) {
                temp[count] = user;
                count++;
            }
        }

        User[] result = new User[count];
        for (int i = 0; i < count; i++)
                result[i] = temp[i];
        return result;
    }

    public static final User[] paySalaryToUsers(User[] users)
    {
        for (User user : users){
            if (user != null)
                user.setBalance(user.getBalance()+user.getSalary());
        }

        return users;
    }
    public static final long[] getUsersId(User[] users)
    {
        long[] ids = new long[users.length];
        for (int i=0;i<users.length;i++){
           if (users[i] != null)
              ids[i] = users[i].getId();
        }

        return ids;
    }
    public static User[] deleteEmptyUsers(User[] users)
    {
        User[] temp = new User[users.length];
        int count = 0;
        for (User user : users){
            if (user != null) {
                temp[count] = user;
                count++;
            }
        }

        User[] result = new User[count];
        for (int i=0;i<count;i++){
            result[i] = temp[i];
        }

        return result;
    }
}
