#include <iostream>
using namespace std;

struct node {
    int data;
    node* next;
    node* prev;
};
typedef struct node node;

node* create_node(int data) {
    node* new_node = new node();
    new_node->data = data;
    new_node->next = new_node->prev = nullptr;
    return new_node;
}

void insert_begin(node** head, node** tail, int data) {
    node* new_node = create_node(data);
    if (*head == nullptr) {
        *head = *tail = new_node;
    } else {
        new_node->next = *head;
        (*head)->prev = new_node;
        *head = new_node;
    }
}

void insert_end(node** head, node** tail, int data) {
    node* new_node = create_node(data);
    if (*head == nullptr) {
        *head = *tail = new_node;
    } else {
        new_node->prev = *tail;
        (*tail)->next = new_node;
        *tail = new_node;
    }
}

void insert_middle(node** head, node** tail, int data, int pos) {
    node *new_node = create_node(data);
    int i = 1;
    for (node *curr = *head; curr != nullptr; curr = curr->next) {
        if (i == pos) {
            if (curr->next == nullptr) {
                insert_end(head, tail, data);
            } 
            new_node->next = curr->next;
            new_node->prev = curr;
            curr->next = new_node;
            new_node->next->prev = new_node;
            return;
        }
    }
}

void delete_begin (node** head) {
    *head = (*head)->next;
    (*head)->prev = nullptr;
}

void delete_end (node** tail) {
    *tail = (*tail)->prev;
    (*tail)->next = nullptr;
}

void traverse(node* head, node* tail) {
    cout<<"Forward Traversal:\n";
    for (node *tmp = head; tmp != nullptr; tmp = tmp->next) {
        cout<<tmp->data<<"->";
    }
    cout<<"\nBackward Traversal:\n";
    for (node *tmp = tail; tmp != nullptr; tmp = tmp->prev) {
        cout<<tmp->data<<"<-";
    }
    cout<<"\n";
}

int main() {
    node* head = nullptr;
    node* tail = nullptr;
    insert_begin(&head, &tail, 3);
    insert_begin(&head, &tail, 4);
    traverse(head, tail);
    insert_middle(&head, &tail, 6, 1);
    traverse(head, tail);
    delete_begin(&head);
    delete_end(&tail);
    traverse(head, tail);
    return 0;
}
