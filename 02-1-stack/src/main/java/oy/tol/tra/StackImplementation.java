package oy.tol.tra;

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
public class StackImplementation<E> implements StackInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;
   private int top=-1;

   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException {
      // TODO: call the constructor with size parameter with default size of 10.
      this(DEFAULT_STACK_SIZE);   
   }
   
   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      this.capacity=capacity;
      
     
      if (capacity < 2) {
         throw new StackAllocationException("The capacity is too small");
     }
     
     try{
         itemArray = new Object[capacity];
     }
     catch(Exception e)
     {
      throw new StackAllocationException("Space cannot be allocated");
     }
   }
         
   

   @Override
   public int capacity() {
      // TODO: Implement this
      return capacity;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      // TODO: Implement this
         if(element==null)
         {
            throw new NullPointerException("Error");
         }
          if(top==capacity-1)
         {
            largeCapacity(capacity * 2); 
         }
         
            top++;
         itemArray[top] = element;
         currentIndex++;
         
              
   }
   private void largeCapacity(int Capacity1) {
      Object[] Array1 = new Object[Capacity1];
      for (int i = 0; i < capacity; i++) {
          Array1[i] = itemArray[i];
      }
      
      itemArray = Array1;
      capacity = Capacity1;
  }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if(top==-1)
      {
          throw new StackIsEmptyException("Stack is empty");
      }
      else{
       top--;
       currentIndex--;
      return (E)itemArray[top+1];
      }

   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if(top==-1)
      {
         throw new StackIsEmptyException("Stack is empty.");
      }
      else{
      return (E)itemArray[top];
   }
}

   @Override
   public int size() {
      // TODO: Implement this
      return top+1;
   }

   @Override
   public void clear() {
      // TODO: Implement this
      top=-1;
      currentIndex=-1;
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
     return (top==-1);
      
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
