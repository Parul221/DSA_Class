class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        if (a != null)
            curr.next = a;

        if (b != null)
            curr.next = b;

        return dummy.next;
    }
}