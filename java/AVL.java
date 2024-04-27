class AVL {
    static class node {
        int data, height;
        node left, right;

        node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    node root;

    AVL() {
        root = null;
    }

    void insert(int data) {
        root = insert_node(root, data);
    }

    void delete(int data) {
        root = delete_node(root, data);
    }

    node right_rotate(node root) {
        node tmp1 = root.left;
        node tmp2 = tmp1.right;
        root.left = tmp2;
        tmp1.right = root;
        //height
        root.height = 1 + max(height(root.left), height(root.right));
        tmp1.height = 1 + max(height(tmp1.left), height(tmp1.right));
        return tmp1;
    }
    node left_rotate(node root) {
        node tmp1 = root.right;
        node tmp2 = tmp1.left;
        root.right = tmp2;
        tmp1.left = root;
        //height
        root.height = 1 + max(height(root.left), height(root.right));
        tmp1.height = 1 + max(height(tmp1.left), height(tmp1.right));
        return tmp1;
    }

    int balance_factor(node root) {
        return height(root.left) - height(root.right);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int height(node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    node balance_tree(node root) {
        int bf = balance_factor(root);
        if (bf > 1) {
            if(balance_factor(root.left) >= 0)
                return right_rotate(root);
            else {
                root.left= left_rotate(root.left);
                return right_rotate(root);
            }
        }
        if (bf < -1) {
            if(balance_factor(root.right) <= 0)
                return left_rotate(root);
            else {
                root.right= right_rotate(root.right);
                return left_rotate(root);
            }
        }
        return root;
    }
    public node insert_node(node root, int data) {
        if (root == null)
            return new node(data);
        else if (data < root.data) 
            root.left = insert_node(root.left, data);
        else if (data > root.data)
            root.right = insert_node(root.right, data);
        else
            return root;
        root.height = 1 + max(height(root.left), height(root.right));
        return balance_tree(root);
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
        root.height = 1 + max(height(root.left), height(root.right));
        return balance_tree(root);
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
        AVL b = new AVL();
        b.insert(7);    
        b.insert(2);    
        b.insert(3);    
        b.insert(5);
        b.delete(7);
        System.out.println(b.search(2));
        b.inOrder();
    }
}

