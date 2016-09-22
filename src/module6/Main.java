package module6;


import java.util.Arrays;

public class Main {
    final static int maxLength = 10;

    public static void main(String[] args) {
        User[] users = new User[maxLength];
        for(int i=0; i<maxLength; i++){
            if (i % 2 == 1) {
                users[i] = new User(i,"Name"+i,"LastName"+i,1000*i,5000*i);
            }
        }

        users[0] = users[1];

        System.out.println("Initial users = " + Arrays.deepToString(users));
        User[] result = UserUtils.deleteEmptyUsers(users);
        System.out.println("Not empty users = " + Arrays.deepToString(result));
        result = UserUtils.uniqueUsers(users);
        System.out.println("Unique users = " + Arrays.deepToString(result));
        result = UserUtils.paySalaryToUsers(result);
        System.out.println("paySalaryToUsers result = " + Arrays.deepToString(result));
        result = UserUtils.usersWithContitionalBalance(result, 20000);//>=20000
        System.out.println("usersWithContitionalBalance = " + Arrays.deepToString(result));
        long[] ids = UserUtils.getUsersId(users);
        System.out.println("ids = " + Arrays.toString(ids));
    }
}
