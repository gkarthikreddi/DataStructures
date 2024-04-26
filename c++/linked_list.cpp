#include<iostream>
using namespace std;

struct node {
    int data;
    struct node *next;
};
typedef struct node node;

node* insert_begin(node *n, int num) {
    node *tmp = new node();
    tmp->data = num;
    tmp->next = n;
    cout<<"Inserted "<<num<<" at the begining\n";
    return tmp;
}

void insert_end(node *n, int num) {
    node *tmp = new node();
    tmp->data = num;
    tmp->next = nullptr;
    for (node *curr = n; curr != nullptr; curr = curr->next) {
        if (curr->next == nullptr) {
            curr->next = tmp;
            cout<<"Inserted "<<num<<" at the end\n";
            break;
        }
    }
}

void insert_middle(node *n, int num, int pos) {
    node *tmp = new node();
    tmp->data = num;
    int i = 1;
    for (node *curr = n; curr != nullptr; curr = curr->next) {
        if (i == pos) {
            tmp->next = curr->next;
            curr->next = tmp;
            cout<<"Inserted "<<num<<" after "<<pos<<" node\n";
            break;
        }
        i++;
    }
}

node* delete_begin(node *n) {
    cout<<"Deleted "<<n->data<<endl;
    node *tmp = n->next;
    return tmp;
}

void delete_end(node *n) {
    for (node *curr = n; curr != nullptr; curr = curr->next) {
        if(curr->next->next == nullptr) {
            cout<<"Deleted "<<curr->next->data<<endl;
            curr->next = nullptr;
            break;
        }
    }
}

void delete_middle(node *n, int pos) {
    int i = 2;
    for (node *curr = n; curr != nullptr; curr = curr->next) {
        if (i == pos) {
            cout<<"Deleted "<<curr->next->data<<endl;
            curr->next = curr->next->next;
            break;
        }
        i++;
    }
}

void traverse(node *n) {
    cout<<"Elements of Linked List"<<endl;
    for (node *curr = n; curr != nullptr; curr = curr->next) {
        cout<<curr->data<<endl;
    }
}

int main() {
    node *head = nullptr;
    head = insert_begin(head, 1);
    head = insert_begin(head, 7);
    insert_end(head, 3);
    insert_middle(head, 4, 2);
    traverse(head);
    head = delete_begin(head);
    delete_middle(head, 2);
    delete_end(head);
    traverse(head);
}
