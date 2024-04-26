#include<iostream>
using namespace std;

#define MAX 4

struct queue {
    int items[MAX];
    int front = -1, rear = -1; // this is not the best practice
};
typedef struct queue queue;

bool is_full(queue &q) {
    return q.rear == MAX - 1;
} 

bool empty(queue &q) {
    return q.front == -1;
} 

void enqueue(queue &q, int num) {
    if (!is_full(q)) {
        if(empty(q)) {
            q.front = 0;
        }
        q.items[++q.rear] = num;
        cout<<"Inserted: "<<num<<endl;
        return;
    }
    cout << "Queue is Full can't insert: "<<num<<endl;
}

int dequeue(queue &q) {
    if (!empty(q)) {
        int num = q.items[q.front];
        if (q.front == q.rear) {
            q.front = -1;
            q.rear = -1;
        } else {
            q.front++;
        }
        cout<<"dequed: "<<num<<endl;;
        return num;
    }
    cout<<"Queue is empty"<<endl;
    return -1;
}

void display(queue &q) {
    if (!empty(q)) {
        cout<<"Elemensts of Queue\n";
        for (int i = q.front; i <= q.rear; i++) {
            cout<<q.items[i]<<endl;
        }
    }
}

int main() {
    queue q;
    enqueue(q, 1);
    enqueue(q, 2);
    dequeue(q);
    display(q);
}
