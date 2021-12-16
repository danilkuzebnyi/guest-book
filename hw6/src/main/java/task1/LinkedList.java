package task1;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addElement("1");
        stringList.addElement("2");
        stringList.addElement("3");
        stringList.addElement("4");
        stringList.addElement("5");

        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.println("size = " + stringList.size);

        stringList.swapTwoElements(1, 3);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    private int size = 0;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public LinkedList() {
        lastNode = new Node<>(firstNode, null, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    public void addElement(T currentElement) {
        Node<T> previousElement = lastNode;
        lastNode = new Node<>(previousElement, currentElement, null);
        previousElement.setNextElement(lastNode);
        size++;
    }

    public void swapTwoElements(int indexOfFirstElement, int indexOfSecondElement) {
        if (indexOfFirstElement == indexOfSecondElement) {
            throw new IllegalArgumentException("you write the same indexes. Can't swap");
        }
        if (indexOfFirstElement < 0 || indexOfSecondElement >= size) {
            throw new IllegalArgumentException("indexes are outside the list size . Can't swap");
        }
        T firstElement = getElementByIndex(indexOfFirstElement);
        T secondElement = getElementByIndex(indexOfSecondElement);
        Node<T> firstElementNode = firstNode;
        Node<T> prevFirstElementNode = firstNode;
        Node<T> secondElementNode = firstNode;
        Node<T> prevSecondElementNode = firstNode;
        boolean firstSwap = false;
        boolean secondSwap = false;
        while (!(firstSwap && secondSwap)) {
            while (firstElementNode.currentElement != firstElement) {
                prevFirstElementNode = firstElementNode;
                firstElementNode = firstElementNode.nextElement;
                firstSwap = true;
            }
            while (secondElementNode.currentElement != secondElement) {
                prevSecondElementNode = secondElementNode;
                secondElementNode = secondElementNode.nextElement;
                secondSwap = true;
            }

            if (firstSwap && secondSwap) {
                Node<T> nextFirstElementNode = firstElementNode.nextElement;
                Node<T> nextSecondElementNode = secondElementNode.nextElement;

                prevFirstElementNode.nextElement = secondElementNode;
                secondElementNode.nextElement = nextFirstElementNode;
                prevSecondElementNode.nextElement = firstElementNode;
                firstElementNode.nextElement = nextSecondElementNode;

                if (nextFirstElementNode == secondElementNode) {
                    secondElementNode.nextElement = firstElementNode;
                } else if (nextSecondElementNode == firstElementNode) {
                    firstElementNode.nextElement = secondElementNode;
                }
            }
        }
    }

    public T getElementByIndex(int index) {
        Node<T> element = firstNode.getNextElement();
        for (int i = 0; i <= index; i++) {
            element = element.getNextElement();
        }
        return element.getCurrentElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return getElementByIndex(index++);
            }
        };
    }


    private static class Node<T> {
        private Node<T> previousElement;
        private T currentElement;
        private Node<T> nextElement;
        private int index;

        public Node(Node<T> previousElement, T currentElement, Node<T> nextElement) {
            this.previousElement = previousElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
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
