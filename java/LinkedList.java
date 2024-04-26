class LinkedList {
    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }
    Node head;

    public void insert_begin(int num) {
        if (head == null) {
            head = new Node(num);
            return;
        }
        Node tmp = new Node(num);
        tmp.next = head;
        head = tmp;
    }

    public void insert_end(int num) {
        if (head == null) {
            head = new Node(num);
            return;
        }
        for(Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.next == null) {
                tmp.next = new Node(num);
                return;
            }
        }
    }

    public void insert_middle(int num, int pos) {
        int i = 1;
        if (pos == 0) {
            insert_begin(num);
            return;
        }
        for(Node curr = head; curr != null; curr = curr.next) {
            if (i == pos) {
                Node tmp = new Node(num);
                tmp.next = curr.next;
                curr.next = tmp;
                return;
            }
            i++;
        }
    }

    public void delete_begin() {
        head = head.next;
    }

    public void delete_end() {
        if (head.next == null) {
            head = null;
            return;
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.next.next == null) {
                curr.next = null;
            }
        }
    }

    public void delete_middle(int pos) {
        int i = 1;
        for (Node curr = head; curr != null; curr = curr.next) {
            if (i == pos - 1) {
                curr.next = curr.next.next;
                break;
            }
            i++;
        }
    }

    public void traverse() {
        for (Node curr = head; curr != null; curr = curr.next) {
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
