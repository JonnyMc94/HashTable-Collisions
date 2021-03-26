/* HashTable class which includes check method - checks if word at hash index matches
 word required
 If this returns true our find adn fill methods have been successful
*/

public class HashTable {
    private String [] hashTable;
    private int total = 0;

    public HashTable(String [] input) {
        hashTable = input;
    }

    public boolean check(int slot, String check) {
        if(hashTable[slot].equals(check)) {
            return true;
        } else {
            total++;
            return false;
        }
    }

    public int gettotal() {
        return total;
    }
}
