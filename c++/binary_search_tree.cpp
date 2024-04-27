#include<iostream>
using namespace std;

struct node {
    int data;
    struct node *left;
    struct node *right;
    node (int data) {
        this->data = data;
        left = right = nullptr;
    }
};
typedef struct node node;

node* insert(node *root, int data) {
    if (root == nullptr)
        return new node(data);
    if (data < root->data)
        root->left = insert(root->left, data);
    if (data > root->data)
        root->right = insert(root->right, data);
    return root;
}

bool search(node *root, int data) {
    if (root == nullptr)
        return false;
    if (data == root->data)
        return true;
    if (data < root->data)
        return search(root->left, data);
    if (data > root->data)
        return search(root->right, data);
    cout<<data<<" not found";
    return false;
}

node* delete_node(node *root, int data) {
    if (root->data == data) {
        if (root->left == nullptr && root->right == nullptr)
            return nullptr;
        else if (root->left != nullptr && root->right != nullptr) {
            node *tmp = root->right;
            while(tmp->left != nullptr)
                tmp = tmp->left;
            root->data = tmp->data;
            root->right = delete_node(root->right, tmp->data);
        } else {
            if (root->left == nullptr)
                return root->right;
            if (root->right == nullptr)
                return root->left;
        }
    } else if (data < root->data)
        root->left =  delete_node(root->left, data);
    else
        root->right = delete_node(root->right, data);
    return root;
}

int main() {
    node *root  = new node(5);
    root->left = new node(4);
    root->left->left = new node(3);
    root->left->left->left = new node(2);
    root = delete_node(root, 2);
}
