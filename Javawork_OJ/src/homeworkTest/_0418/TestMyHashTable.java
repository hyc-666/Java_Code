package homeworkTest._0418;

public class TestMyHashTable {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        table.add(8);
        table.add(15);
        table.add(7);
        table.add(12);
        table.add(9);
        table.add(14);
        table.add(21);
        table.add(16);

        System.out.println(table);
        System.out.println("size = " + table.size);
        table.delete(9);
        table.delete(9);
        table.delete(9);
        System.out.println();
        System.out.println(table);
        System.out.println("size = " + table.size);
        System.out.println("+++++++++++++++++++++");
        System.out.println(table.get(14));
        System.out.println(table.contains(9));
        System.out.println(table.contains(7));
        System.out.println(table.contains(3));
        table.clear();
        System.out.println(table);
        System.out.println("size = " + table.size);
    }
}
