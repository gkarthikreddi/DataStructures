class BinarySearchTree {
    static class node {
        int data;
        node left, right;

        node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insert_node(root, data);
    }

    void delete(int data) {
        root = delete_node(root, data);
    }

    public node insert_node(node root, int data) {
        if (root == null)
            return new node(data);
        else if (data < root.data) 
            root.left = insert_node(root.left, data);
        else if (data > root.data)
            root.right = insert_node(root.right, data);
        return root;
    }

    public node delete_node(node root, int data) {
        if (root == null)
            return null;
        if (root.data == data) {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left != null && root.right != null) {
                node tmp = root.right;
                while (tmp.left != null)
                    tmp = tmp.left;
                root.data = tmp.data;
                root.right = delete_node(root.right, tmp.data);
            } else {
                if (root.left == null)
                    return root.right;
                if (root.right == null)
                    return root.left;
            }
        }
        else if (data < root.data)
            root.left = delete_node(root.left, data);
        else if (data > root.data)
            root.right = delete_node(root.right, data);
        else
            return root;
        return root;
    }

    Boolean search(int data) {
       return search_node(root, data);
    }

    public Boolean search_node(node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        else if (root.data > data)
            return search_node(root.left, data);
        else if (root.data < data)
            return search_node(root.right, data);
        return false;
    }

    void inOrder() {
        inOrder_node(root);
    }

    public void inOrder_node(node root) {
        if (root == null)
            return;
        inOrder_node(root.left);
        System.out.print(root.data+".");
        inOrder_node(root.right);
    }

    public static void main(String args[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(7);    
        b.insert(2);    
        b.insert(3);    
        b.insert(5);
        b.delete(7);
        System.out.println(b.search(2));
        b.inOrder();
    }
}
