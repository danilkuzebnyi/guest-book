package task1;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addElement("dog");
        stringList.addElement("cat");
        System.out.println(stringList.size);
        System.out.println(stringList.getElementByIndex(0));
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public LinkedList() {
        firstNode = new Node<>(null, null, lastNode);
        lastNode = new Node<>(firstNode, null, null);
    }

    public void addElement(T el) {
        if (size != 0) {
            Node<T> last = lastNode;
            last.setCurrentElement(el);
            lastNode = new Node<>(last, el, null);
            last.setNextElement(lastNode);
            firstNode = new Node<>(null, el, last);
            last.setPreviousElement(firstNode);
        }
        else {
            lastNode = new Node<>(firstNode, null, null);
            firstNode = lastNode;
        }
        size++;
    }

    public T getElementByIndex(int index) {
        Node<T> element = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            element = getNextElement(element);
        }
        return element.getCurrentElement();
    }

    private Node<T> getNextElement (Node<T> current) {
        return current.getNextElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }
            @Override
            public T next() {
                return getElementByIndex(counter++);
            }
        };
    }

    private static class Node<T> {
        Node<T> previousElement;
        T currentElement;
        Node<T> nextElement;

        public Node(Node<T> previousElement, T currentElement, Node<T> nextElement) {
            this.previousElement = previousElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        public void setPreviousElement(Node<T> previousElement) {
            this.previousElement = previousElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPreviousElement() {
            return previousElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }
    }
}
