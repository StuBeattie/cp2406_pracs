import java.util.TreeMap;

public class Ch10p1_phoneDir {

    static TreeMap<String, PhoneEntry> map = new TreeMap<>();

    private static class  PhoneEntry {
        String name;
        String phoneNum;
        public PhoneEntry(String name, String phone) {
            this.name = name;
            this.phoneNum = phone;
        }
        public String toString(){
            return "name = " + name + ", phone = " + phoneNum;
        }
    }

    public static void main(String[] args) {
        PhoneEntry i1 = new PhoneEntry("aName", "111111");
        PhoneEntry i2 = new PhoneEntry("bName", "222222");
        PhoneEntry i3 = new PhoneEntry("cName", "333333");
        PhoneEntry i4 = new PhoneEntry("dName", "444444");

//        TreeMap<String, PhoneEntry> map = new TreeMap<>();
        map.put(i1.name, i1);
        map.put(i2.name, i2);
        map.put(i3.name, i3);
        map.put(i4.name, i4);

        PhoneEntry find1 = find("bName");
        System.out.println("found " + find1);

        String num1 = getNumber("bName");
        System.out.println("found number " + num1);

        find1 = find("bbName");
        System.out.println("found " + find1);

        putNumber("bbName", "33333333");
        find1 = find("bbName");
        System.out.println("found " + find1);
    }

    public  static void putNumber(String name, String number) {
        PhoneEntry item = new PhoneEntry(name, number);
        map.put(item.name, item);
    }

    public static String getNumber(String name) {
        PhoneEntry item = find(name);
        if (item == null) {
            return null;
        }
        return item.phoneNum;
    }

    public static PhoneEntry find(String name) {
        if (map.containsKey(name)){
            return map.get(name);
        }
        return  null;
    }

}
