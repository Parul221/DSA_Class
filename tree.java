import java.util.*;

class Main {

    static Node buildTree(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length) {
                current.left = new Node(arr[i++]);
                queue.add(current.left);
            }
            if (i < arr.length) {
                current.right = new Node(arr[i++]);
                queue.add(current.right);
            }
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

}