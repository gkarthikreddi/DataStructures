#include <iostream>
using namespace std;

#define MAX 7

struct stack {
    int items[MAX];
    int top = -1; // You shouldn't do this
};
typedef struct stack stack;

bool empty(stack &s) {
    return s.top == -1;
}

bool is_full(stack &s) {
    return s.top == MAX - 1;
}

void push(stack &s, int num) {
    if (!is_full(s)) {
        s.items[++s.top] = num;
        return;
    }
    cout << "Stack is full can't insert " << num <<endl;
}

int pop(stack &s) {
    if (!empty(s)) {
        return s.items[s.top--];
    }
    cout << "Stack is empty" <<endl;
    return -1;
}

int peek(stack &s) {
    if (!empty(s)) {
        return s.items[s.top];
    }
    cout << "Stack is empty" <<endl;
    return -1;
}

void display(stack &s) {
    if (!empty(s)) {
        cout << "Elements of stack: " <<endl;
        for (int i = 0; i <= s.top; i++) {
           cout<<s.items[i]<<endl; 
        }
    }
}

int main() {
    stack s;
    pop(s);
    push(s, 1);
    push(s, 2);
    push(s, 3);
    push(s, 4);
    display(s);
    pop(s);
    push(s, 5);
    push(s, 6);
    push(s, 7);
    push(s, 8);
    push(s, 0);
    pop(s);
    display(s);
}
