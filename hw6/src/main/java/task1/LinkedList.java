package task1;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addElement("dog");
        stringList.addElement("cat");
        stringList.addElement("fog");
        stringList.addElement("horse");
        stringList.addElement("bear");

        for (String s : stringList) {
            System.out.println(s);
        }

        stringList.swapTwoElements(1, 3);
        System.out.println("\nLinked list after swapping 2 elements");
        for (String s : stringList) {
            System.out.println(s);
        }

        System.out.println("\nSorting by bubble sorting");
        stringList.bubbleSorting(String::compareTo, Direction.ASC, stringList);
        for (String s : stringList) {
            System.out.println(s);
        }

        System.out.println("\nSorting by insertion sorting");
        stringList.insertionSorting(String::compareTo, Direction.DESC, stringList);
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
        previousElement.nextElement = lastNode;
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
                prevSecondElementNode.nextElement = firstElementNode;
                firstElementNode.nextElement = nextSecondElementNode;
                secondElementNode.nextElement = nextFirstElementNode;
                firstElementNode.previousElement = prevSecondElementNode;
                secondElementNode.previousElement = prevFirstElementNode;
                if (nextFirstElementNode != null) {
                    nextFirstElementNode.previousElement = secondElementNode;
                } else if (nextSecondElementNode != null) {
                    nextSecondElementNode.previousElement = firstElementNode;
                }

                if (nextFirstElementNode == secondElementNode) {
                    secondElementNode.nextElement = firstElementNode;
                } else if (nextSecondElementNode == firstElementNode) {
                    firstElementNode.nextElement = secondElementNode;
                }
            }
        }
    }

    public LinkedList<String> bubbleSorting(Comparator<String> comparator,
                                            Direction direction,
                                            LinkedList<String> stringList) {
        LinkedList<String> sortedStringList;
        sortedStringList = stringList;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < sortedStringList.size; i++) {
                switch (direction) {
                    case ASC:
                        if (comparator.compare(sortedStringList.getElementByIndex(i - 1),
                                               sortedStringList.getElementByIndex(i)) > 0) {
                            sortedStringList.swapTwoElements(i - 1, i);
                            isSorted = false;
                        }
                        break;
                    case DESC:
                        if (comparator.compare(sortedStringList.getElementByIndex(i - 1),
                                               sortedStringList.getElementByIndex(i)) < 0) {
                            sortedStringList.swapTwoElements(i - 1, i);
                            isSorted = false;
                        }
                        break;
                }
            }
        }
        return sortedStringList;
    }

    public LinkedList<String> insertionSorting(Comparator<String> comparator,
                                               Direction direction,
                                               LinkedList<String> stringList) {
        LinkedList<String> sortedStringList;
        sortedStringList = stringList;
        for (int i = 1; i < sortedStringList.size; i++) {
            String currentElement = sortedStringList.getElementByIndex(i);
            int j = i;
            switch (direction) {
                case ASC:
                    while (j > 0 && comparator.compare(sortedStringList.getElementByIndex(j - 1), currentElement) > 0) {
                        swapTwoElements(j - 1, j);
                        j--;
                    }
                    break;
                case DESC:
                    while (j > 0 && comparator.compare(sortedStringList.getElementByIndex(j - 1), currentElement) < 0) {
                        swapTwoElements(j - 1, j);
                        j--;
                    }
                    break;
            }
        }
        return sortedStringList;
    }

    public T getElementByIndex(int index) {
        Node<T> element = firstNode.nextElement;
        for (int i = 0; i <= index; i++) {
            element = element.nextElement;
        }
        return element.currentElement;
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

        public Node(Node<T> previousElement, T currentElement, Node<T> nextElement) {
            this.previousElement = previousElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }
    }
}
