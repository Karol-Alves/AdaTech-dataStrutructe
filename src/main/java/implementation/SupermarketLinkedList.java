package implementation;

public class SupermarketLinkedList implements Supermarket {

    private Node head;
    private int size;

    public SupermarketLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(final String item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void print() {
        System.out.println("======================================");
        if (head == null) {
            System.out.println("Lista de supermercado vazia");
        } else {
            Node current = head;
            int index = 0;
            while (current != null) {
                System.out.println(index + " - " + current.item);
                current = current.next;
                index++;
            }
        }
        System.out.println("======================================");
    }

    @Override
    public void delete(final int index) {
        if (index < 0 || index >= size) {
            System.err.println("Índice inválido");
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            Node previous = null;
            int currentIndex = 0;
            while (currentIndex < index) {
                previous = current;
                current = current.next;
                currentIndex++;
            }
            previous.next = current.next;
        }
        size--;
    }
}
