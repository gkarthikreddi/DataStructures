class Queue {
    private int items[], front, rear, size;

    Queue(int len) {
        items = new int[len];
        front = -1;
        rear = -1;
        size = len;
    }

    public Boolean isFull() {
        return rear == size - 1;
    }

    public Boolean isEmpty() {
        return front == -1;
    }

    public void enQueue(int num) {
        if (!isFull()) {
            if(isEmpty())
                front = 0;
            items[++rear] = num;
            System.out.println("Inserted: "+num);
            return;
        }
        System.out.println("Queue is full can't insert: "+num);
    }
    public int deQueue() {
        if (!isEmpty()) {
            int num = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return num;
        }
        System.out.println("Queue is empty can't pop");
        return -1;
    }

    public void display() {
        if (!isEmpty()) {
            System.out.println("Elements of queueu are:");
            for (int i = front; i <=rear; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.enQueue(1);
        q.enQueue(2);
        q.deQueue();
        q.display();
    }
}
