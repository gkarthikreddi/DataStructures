class CircularQueue {
    private int items[], front, rear, size;

    CircularQueue(int len) {
        items = new int[len];
        front = -1;
        rear = -1;
        size = len;
    }

    public Boolean isFull() {
        if (front < rear)
            return front == 0 && rear == size - 1;
        else
            return rear + 1 == front;
    }

    public Boolean isEmpty() {
        return front == -1;
    }

    public void enQueue(int num) {
        if (!isFull()) {
            if(isEmpty())
                front = 0;
            rear = ++rear % size;
            items[rear] = num;
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
                front = ++front % size;
            }
            return num;
        }
        System.out.println("Queue is empty can't pop");
        return -1;
    }

    public void display() {
        if (!isEmpty()) {
            System.out.println("Elements of Queue are:");
            int tmp = front;
            if (front < rear) {
                for (; tmp <= rear; tmp++)
                    System.out.println(items[tmp]);
            } else {
                while (rear != tmp) {
                    System.out.println(items[tmp]);
                    tmp = ++tmp % size;
                }
                System.out.println(items[tmp]);
            }
        }
    }

    public static void main(String args[]) {
        CircularQueue q = new CircularQueue(5);
        q.enQueue(1);
        q.enQueue(2);
        q.display();
        q.deQueue();
    }
}
