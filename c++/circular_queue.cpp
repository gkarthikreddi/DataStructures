#include<iostream>
using namespace std;

#define MAX 5

struct queue {
    int items[MAX];
    int front = -1, rear = -1;
};
typedef struct queue queue;

bool is_full(queue &q) {
    if (q.front < q.rear) {
        return q.front == 0 && q.rear == MAX - 1;
    } else {
        return q.rear + 1 == q.front;
    }
} 

bool empty(queue &q) {
    return q.rear == -1 && q.front == -1;
} 

void enqueue(queue &q, int num) {
    if (!is_full(q)) {
        if(empty(q)) {
            q.front = 0;
        }
        q.rear = ++q.rear % MAX;
        q.items[q.rear] = num;
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
            q.front = ++q.front % MAX;
        }
        return num;
    }
    cout<<"Queue is empty"<<endl;
    return -1;
}

void display(queue &q) {
    if (!empty(q)) {
        cout<<"Elemensts of Queue\n";
        int tmp = q.front;
        if (q.front < q.rear) {
            for (; tmp <= q.rear; tmp++)
                cout<<q.items[tmp]<<endl;
        } else {
            while (q.rear != tmp) {
                cout<<q.items[tmp]<<endl;
                tmp = ++tmp % MAX;
           }
            cout<<q.items[tmp]<<endl;
        }
    }
}

int main() {
    queue q;
    enqueue(q, 1);
    enqueue(q, 2);
    display(q);
    enqueue(q, 3);
    enqueue(q, 4);
    enqueue(q, 5);
    display(q);
    dequeue(q);
    dequeue(q);
    display(q);
    enqueue(q, 1);
    enqueue(q, 2);
    display(q);
}
