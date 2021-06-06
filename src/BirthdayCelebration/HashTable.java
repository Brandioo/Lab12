package BirthdayCelebration;

public class HashTable {

    public static final int tableSize = 1000;
    public static final int pKey = 31;
    public static final int MaxLen = 10;

    public static int hash(String key, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + key.charAt(i));
        }
        return res % tableSize;
    }

    public static int computeHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash % tableSize; // SIZE = 100 in example
    }

    public static int hash(String key)
    {

        int res = 0, len = Math.min(key.length(), MaxLen);

        for (int i = 0; i < len; i++) {
            res = (pKey * res + key.charAt(i)) % tableSize;
        }
        if (res < 0) {
            res += tableSize; // if overflows
        }

        return res;
    }


}
