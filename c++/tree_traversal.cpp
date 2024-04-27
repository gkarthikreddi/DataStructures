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

void inorder(node *root) {
    if (root == nullptr)
        return;
    inorder(root->left);
    cout<<root->data<<"->";
    inorder(root->right);
}

void preorder(node *root) {
    if (root == nullptr)
        return;
    cout<<root->data<<"->";
    preorder(root->left);
    preorder(root->right);
}

void postorder(node *root) {
    if (root == nullptr)
        return;
    postorder(root->left);
    postorder(root->right);
    cout<<root->data<<"->";
}

int main() {
    node *root = new node(5);
    root->left = new node(7);
    root->right = new node(8);
    root->right->left = new node(1);
    root->right->right = new node(2);
    root->left->right = new node(9);
    root->left->left = new node(3);
    cout<<"Inorder Traversal:\n";
    inorder(root);
    cout<<"\nPreOrder Traversal:\n";
    preorder(root);
    cout<<"\nPostOrder Traversal:\n";
    postorder(root);
}
