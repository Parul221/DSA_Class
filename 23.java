class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        ListNode ans = null;

        for (ListNode list : lists) {
            ans = merge(ans, list);
        }

        return ans;
    }

    ListNode merge(ListNode a, ListNode b) {

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