public class TreeTraversal {
    static class node {
        int data;
        node left;
        node right;

        node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public void inOrder(node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+"->");
        inOrder(root.right);
    }

    public void preOrder(node root) {
        if (root == null)
            return;
        System.out.print(root.data+"->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"->");
    }

    public static void main(String args[]) {
        TreeTraversal t = new TreeTraversal();
        node root = new node(6);
        root.left = new node(7);
        root.right = new node(8);
        root.right.left = new node(1);
        root.right.right = new node(2);
        root.left.right = new node(9);
        root.left.left = new node(3);
        System.out.println("Inorder Traversal:");
        t.inOrder(root);
        System.out.println("\nPreorder Traversal:");
        t.preOrder(root);
        System.out.println("\nPostorder Traversal:");
        t.postOrder(root);
    }
}
