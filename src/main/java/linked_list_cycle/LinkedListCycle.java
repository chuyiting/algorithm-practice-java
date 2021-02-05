package linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while(head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
