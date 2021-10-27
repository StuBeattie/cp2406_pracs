import java.util.ArrayList;

public class Ch9p3 {

    public static void main(String[] args) {

        ListNode origList = new ListNode();
        origList.item = 1;
        ListNode i2 = new ListNode();
        i2.item = 2;
        ListNode i3 = new ListNode();
        i3.item = 3;
        ListNode i4 = new ListNode();
        i4.item = 4;

        origList.next = i2;
        i2.next = i4;
        i4.next = i3;

        printMyList(origList);
        ListNode newList = reverseOrder(origList);
        System.out.println("-----------------");
        printMyList(newList);

        System.out.println("-----------------");
        printMyList(origList);
    }

    private static ListNode reverseOrder(ListNode node) {
        ArrayList<ListNode> arr = new ArrayList<>();
        while (node != null) {
            ListNode newNode = new ListNode();
            newNode.item = node.item;
            newNode.next = node.next;

            //arr.add(node);
            arr.add(newNode);
            System.out.println("item = " + node.item);
            node = node.next;
        }
        ListNode first = null;
        ListNode nextNode;
        for (int i = 0; i < arr.size() - 1; i++) {
            node = arr.get(arr.size() - i - 1);
            nextNode = arr.get(arr.size() - (i+1) - 1);
            node.next = nextNode;
            if (first == null) {
                first = node;
            }
            if (i == arr.size() - 2) {
                nextNode.next = null;
            }
        }
        return  first;
    }

    private static void printMyList(ListNode node) {
        while (node != null) {
            System.out.println("item = " + node.item);
            node = node.next;
        }
    }

}
