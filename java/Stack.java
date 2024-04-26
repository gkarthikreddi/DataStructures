class Stack {
    private int arr[], top, size;

    Stack(int len) {
        arr = new int[len];
        top = -1;
        size = len;
    }

    public Boolean isFull() {
        return top == size -1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (!isFull()) {
            arr[++top] = num;
            System.out.println("inserted:"+num);
            return;
        }
        System.out.println("Stack is full can't insert "+num);
    }

    public int pop() {
        if (!isEmpty()) {
            return arr[top--];
        }
        System.out.println("Stack is Empty");
        return -1;
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("Stack is Empty");
        return -1;
    }
    
    public void display() {
        if (!isEmpty()) {
            System.out.println("Elements of Stack");
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
            return;
        }
        System.out.println("Stack is empty nothing to display");
    }

    public static void main(String[] args) {
        Stack s = new Stack(7);
        s.pop();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.display();
        s.pop();
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(0);
        s.pop();
        s.display();
    }
}
