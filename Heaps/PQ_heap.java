public class PQ_heap <E extends Comparable<E>>
{
    // Internal heap object used for priority queue operations
    private Heap<E> heap = new Heap<>();

    // Constructor method
    PQ_heap() {}

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
        // Return Statement
        return heap.isEmpty();
    }

    // Return true if priority queue is full; otherwise return false
    public boolean is_full() {
        // Return Statement
        return heap.isFull();
    }

    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front() {
        // Return Statement
        return heap.peek();
    }

    // return number of elements in the queue
    public int size() {
        // Return Statement
        return heap.getSize();
    }

    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue() {
        // Return Statement
        return heap.remove();
    }

    // Inserts the 'value' into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value) {
        // Return Statement
        heap.add(value);
    }

    // Return full heap list (used for display in menu)
    public java.util.ArrayList<E> getHeapList() {
        return heap.getList();
    }
};
