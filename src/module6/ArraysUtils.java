package module6;

import java.util.Arrays;

public final class ArraysUtils {
    public static void main(String[] args) {
        int[] a = {2,14,-3,18,-9,5,6,2};
        System.out.println(String.format("int array %s: ","{2,14,-3,18,-9,5,6,2}"));
        System.out.println(String.format("sum int %d",sum(a)));
        System.out.println(String.format("max int %d",max(a)));
        System.out.println(String.format("min int %d",min(a)));
        System.out.println(String.format("mult int %d",multiplication(a)));
        System.out.println(String.format("modulus int %d",modulus(a)));
        System.out.println(String.format("maxPositive int %d",maxPositive(a)));
        System.out.println(String.format("secondLargest int %d",secondLargest(a)));
        System.out.println("reverse int array: " + Arrays.toString(reverse(a)));
        System.out.println("findEvenElements: " + Arrays.toString(findEvenElements(a)));
    }

    public static int sum(int[] array) {
        int s = 0;
        for (int a : array) {
            s += a;
        }
        return s;
    }

    public static int min(int[] array)
    {
        int m = Integer.MAX_VALUE;
        for (int a : array) {
            if (a < m)
                m = a;
        }

        return m;
    }

    public static int max(int[] array)
    {
        int m = Integer.MIN_VALUE;
        for (int a : array) {
            if (a > m)
                m = a;
        }

        return m;
    }

    public static int maxPositive(int[] array)
    {
        int m = -1;
        for (int a : array) {
            if (a > 0 && a > m)
                m = a;
        }

        return m;
    }

    public static long multiplication(int[] array) {
        int m = 1;
        for (int a : array) {
            m *= a;
        }
        return m;
    }

    public static int modulus(int[] array) {
        int m;
        m = array[0] % array[array.length - 1];
        return m;
    }

    public static int secondLargest(int[] array) {
        int m = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;
        for (int a : array) {
            if (a > m) {
                if (m > Integer.MIN_VALUE)
                    sl = m;
                m = a;
            }
        }

        return sl;
    }

    public static int[] reverse(int[] array)
    {
        int[] reverse = new int[array.length];
        for (int i=0; i<array.length; i++)
            reverse[array.length-i-1]=array[i];

        return reverse;
    }

    public static int[] findEvenElements(int[] array){
        int[] temp = new int[array.length];
        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] % 2 == 0) {
                temp[count] = array[i];
                count++;
            }
        }

        int[] even = new int[count];
        even = Arrays.copyOfRange(temp, 0, count-1);
        return even;
    }
}
