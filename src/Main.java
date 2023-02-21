import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("8");
        list.add("9");
        list.add("10");

        System.out.println(list.contains("7"));
        System.out.println(list.contains("2"));
        System.out.println(list.binarySearch("8"));
        System.out.println(list.indexOf("2"));

        MyArrayList<String> list2 = new MyArrayList<>();
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        list2.add("7");

        list.addAll(2, list2);
        list.addAll(list2);
        System.out.println(list);
    }
}
