class DoubleLinkedList {
    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int d) {
            value = d;
            next = null;
            prev = null;
        }
    }
    Node head;
    Node tail;

    public void insert_begin(int num) {
        if (head == null) {
            head = new Node(num);
            tail = head;
            return;
        }
        Node tmp = new Node(num);
        tmp.next = head;
        head.prev = tmp;
        head = tmp;
    }

    public void insert_end(int num) {
        if (tail == null) {
            tail = new Node(num);
            head = tail;
            return;
        }
        tail.next = new Node(num);
        tail.next.prev = tail;
        tail = tail.next;
    }

    public void insert_middle(int num, int pos) {
        if (pos == 0) {
            insert_begin(num);
            return;
        }
        int i = 1;
        for(Node curr = head; curr != null; curr = curr.next) {
            if (i == pos) {
                if (curr.next == null) {
                    insert_end(num);
                }
                Node tmp = new Node(num);
                tmp.next = curr.next;
                curr.next.prev = tmp;
                tmp.prev = curr;
                curr.next = tmp;
                return;
            }
            i++;
        }
    }

    public void delete_begin() {
        head = head.next;
        head.prev = null;
    }

    public void delete_end() {
        if (tail.prev == null) {
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void delete_middle(int pos) {
        if (pos == 0) {
            delete_begin();
            return;
        }
        int i = 1;
        for (Node curr = head; curr != null; curr = curr.next) {
            if (i == pos) {
                if (curr == tail) {
                    delete_end();
                    return;
                }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            i++;
        }
    }

    public void traverse() {
        for (Node curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.value+"->");
        }
        System.out.println();
        for (Node curr = tail; curr != null; curr = curr.prev) {
            System.out.print(curr.value+"->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert_begin(7);
        ll.insert_begin(1);
        ll.insert_begin(2);
        ll.traverse();
        ll.insert_end(3);
        ll.insert_end(4);
        ll.traverse();
        ll.insert_middle(8, 0);
        ll.insert_middle(8, 4);
        ll.traverse();
        ll.delete_begin();
        ll.traverse();
        ll.delete_end();
        ll.traverse();
        ll.delete_middle(3);
        ll.traverse();
    }
}
