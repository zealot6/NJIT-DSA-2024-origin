package oy.tol.tra;
import java.util.ArrayList;
/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * 
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.
 * - StackImplementation(int size), which allocates an array of Object's with size.
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class QueueImplementation<E> implements QueueInterface<E> {
   private ArrayList<E> arr;
   private Object [] itemArray;
   private int first;
   private int next;
   private int size;
   private int capacity;
   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public QueueImplementation(int capacity) throws QueueAllocationException {
      // TODO: call the constructor with size parameter with default size of 10.
      first = 0;
      next =-1;  
      this.arr = new ArrayList<>(capacity);
      size = 0;
      this.capacity = capacity;
   }
   

   
         
   private void reallocate(int newCapacity) {
      ArrayList<E> newArray = new ArrayList<>(newCapacity);
     
      for (int i = 0; i < size; i++) {
          int index = (first + i) % capacity;
          newArray.add(arr.get(index));
      }
  
      arr = newArray;
      first = 0;
      next = size - 1;
      capacity = newCapacity;
  }

   @Override
   public int capacity() {
      // TODO: Implement this
      return capacity;
   }

   @Override
   public void enqueue(E element) throws QueueAllocationException, NullPointerException {
      // TODO: Implement this
      if (element == null) {
         throw new NullPointerException("the element is wrong");
     }
     if (size == capacity) {
         reallocate(capacity * 2);
     }
     next = (next + 1) % capacity;
     if (next == arr.size()) {
         arr.add(element);
     }
     else{
         arr.set(next, element);
     }
     size++;
   }


   @SuppressWarnings("unchecked")
   @Override
   public E dequeue() throws QueueIsEmptyException {
      if (isEmpty()) {
         throw new QueueIsEmptyException("Queue is empty.");
     }

     E item = arr.get(first);
     first = (first + 1) % capacity;
     size--;
     

     if (size == 0) {
         first = 0;
         next = -1;
     }

     return item;

   }

   @SuppressWarnings("unchecked")
   @Override
   public E element() throws QueueIsEmptyException {
      if (next == -1) {
         throw new QueueIsEmptyException("Queue is empty.");
     }
     return arr.get(first);
}


   @Override
   public void clear() {
      first = 0;
      next = -1;
      size = 0;
  }

   @Override
   public boolean isEmpty() {
      return (size == 0);
      
   }

   public int size() {
      return size;
  }
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (int i = 0; i < size; i++) {
          int index = (i + first) % capacity;
          builder.append(arr.get(index));
          if (i < size - 1) {
              builder.append(", ");
          }
      }
      builder.append("]");
      return builder.toString();
  }
   }

