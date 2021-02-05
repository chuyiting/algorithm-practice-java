package reverse_linked_list;

//https://leetcode.com/problems/reverse-linked-list/solution/
public class ReverseLinkedList {
    // recursive solution
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode reversedRest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedRest;
    }

    // iterative solution/ important !!!!!! => fast
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode list = head.next;
        ListNode prev = head;
        while (list != null) {
            ListNode tempNext = list.next;
            list.next = prev;
            prev = list;
            list = tempNext;
        }
        head.next = null;
        return prev;
    }



    public static void main(String[] args) {

        ListNode tailTail = new ListNode(4);
        ListNode tail = new ListNode(3, tailTail);
        ListNode center = new ListNode(2, tail);
        ListNode head = new ListNode(1, center);

        ListNode reversedList = reverseList2(head);
        while(reversedList != null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }

    }

}


