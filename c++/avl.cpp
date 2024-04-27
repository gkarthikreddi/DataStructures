#include<iostream>
using namespace std;

struct node {
    int data, height;
    struct node *left, *right;
    node(int data) {
        this->data = data;
        this->height = 1;
        left = right = nullptr;
    }
};
typedef struct node node;

int height(node *root) {
    if (root == nullptr)
        return 0;
    return root->height;
}

int max(int a, int b) {
    return (a>b) ? a : b;
}

node* right_rotate(node *root) {
    node *tmp1 = root->left;
    node *tmp2 = tmp1->right;
    root->left = tmp2;
    tmp1->right = root;
    //height
    root->height = 1 + max(height(root->left), height(root->right));
    tmp1->height = 1 + max(height(tmp1->left), height(tmp1->right));
    return tmp1;
}

node* left_rotate(node *root) {
    node *tmp1 = root->right;
    node *tmp2 = tmp1->left;
    root->right = tmp2;
    tmp1->left = root;
    //height
    root->height = 1 + max(height(root->left), height(root->right));
    tmp1->height = 1 + max(height(tmp1->left), height(tmp1->right));
    return tmp1;
}

int balance_factor(node *root) {
    return height(root->left) - height(root->right);
}

node* balance_tree(node *root) {
    int bf = balance_factor(root);
    if (bf > 1) {
        if(balance_factor(root->left) >= 0)
            return right_rotate(root);
        else {
            root->left= left_rotate(root->left);
            return right_rotate(root);
        }
    }
    if (bf < -1) {
        if(balance_factor(root->right) <= 0)
            return left_rotate(root);
        else {
            root->right= right_rotate(root->right);
            return left_rotate(root);
        }
    }
    return root;
}

node* insert(node *root, int data) {
    if (root == nullptr)
        return new node(data);
    else if (data < root->data)
        root->left = insert(root->left, data);
    else if (data > root->data)
        root->right = insert(root->right, data);
    else
        return root; // while inserting same element into the tree don't allow

    root->height = 1 + max(height(root->left), height(root->right));
    return balance_tree(root);
}

node* delete_node(node *root, int data) {
    if (root->data == data) {
        if (root->left == nullptr && root->right == nullptr)
            return nullptr;
        else if (root->left != nullptr && root->right != nullptr) {
            node *tmp = root;
            while(tmp->left != nullptr)
                tmp = tmp->left;
            root = delete_node(root, tmp->data);
            root->data = tmp->data;
        } else {
            if (root->left == nullptr)
                root = root->right;
            if (root->right == nullptr)
                root = root->left;
        }
    } else if (data < root->data)
        root->left =  delete_node(root->left, data);
    else
        root->right = delete_node(root->right, data);

    root->height = 1 + max(height(root->left), height(root->right));
    return balance_tree(root);
}

int main() {
    node *root = new node(5);
    root = insert(root, 6);
    root = insert(root, 7);
    root = insert(root, 3);
    root = insert(root, 4);
    root = insert(root, 1);
    root = delete_node(root, 6);
    cout<<root->data;
    cout<<root->left->data;
    cout<<root->right->data;

}
