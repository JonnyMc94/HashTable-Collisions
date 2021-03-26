
// This class contains 2 methods - find and fill

public class Solution {

    // This method finds the word requested in the hashtable
    public int find(int size, HashTable mytable, String word){

        long hashCode = 0;

        // This loops through the word and generates a hash code for each character

        for(double j = 0; j<word.length(); j++) {
            long initialNum = ((long)(word.charAt((int)j) * Math.pow(129.0, j)) % size);
            hashCode += (initialNum % size);
        }

        // Moduloing it by the specified size of the hashtable keeps the index in range
        hashCode %= size;

        // If the check method returns true the word has been found and it returns the hashcode cast to an int
        if(mytable.check((int)hashCode, word))
            return (int)hashCode;
        // If not found it increases the index value by one until found
        else{
            while(!(mytable.check((int) hashCode, word ))){
                hashCode = (hashCode + 1) % size;
            }
            return (int) hashCode;
        }


    }

    // This method populates the hashtable with an array of strings

    public String[] fill(int size, String[] array){

        String[] hashtable = new String[size];


        for (String s : array) {
            long hashCode = 0;
            String str = s;

            // This loops through the word and generates a hash code for each character
            for (double j = 0; j < str.length(); j++) {
                long initialNum = ((long) (str.charAt((int) j) * Math.pow(129.0, j)) % size);
                hashCode += (initialNum % size);
            }
            // Moduloing it by the specified size of the hashtable keeps the index in range
            hashCode %= size;

            // If the index is null (empty) it inserts the string at this index
            if (hashtable[(int) hashCode] == null)
                hashtable[(int) hashCode] = s;
            // Otherwise it increases the index by one until an empty slot is found
            else {
                //long nextStep = 1;
                while (hashtable[(int) hashCode] != null) {
                    hashCode = (hashCode + 1) % size;
                }
                hashtable[(int) hashCode] = s;
            }
        }
        return hashtable;

    }
}
