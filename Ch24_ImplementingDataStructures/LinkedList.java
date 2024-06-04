import java.util.NoSuchElementException; 
public class LinkedList<E>
{
   class Node<E>
   {
      E element;
      Node<E> next;
      
      public Node(E e)
      {
         this.element = e;
         this.next = null;
      }
      
      public E getElement(){ return this.element; }
      public Node getNext(){ return this.next; }
      public LinkedList getOwner(){ return LinkedList.this; }
   }
   
   private Node<E> head;
   private Node<E> tail;
   private int size;
   
   public Node<E> getHead(){ return this.head; }
   public Node<E> getTail(){ return this.tail; }
   public int getSize(){ return this.size; }
   public boolean isEmpty(){ return size == 0; }
   
   public Node<E> insertHead( E element ){
      Node<E> newNode = new Node<>(element);
      
      if( isEmpty() ){
         this.head = newNode;
         this.tail = newNode;
      }else{
         newNode.next = this.head;
         this.head = newNode;
      }
      
      size++;
      return newNode;   
   }
   
   public Node<E> insertTail( E element ){
      Node<E> newNode = new Node<>(element);
      
      if( isEmpty() ){
         this.head = newNode;
         this.tail = newNode;
      }else{
         this.tail.next = newNode;
         this.tail = newNode;
      }
      
      size++;
      
      return newNode;   
   }
   
   public Node<E> insertAfter( Node<E> node, E element ) throws IllegalArgumentException{
      
      if( node == null ){ throw new IllegalArgumentException("Argument 'element' must not be null"); }
      if( node.getOwner() != this ){ throw new IllegalArgumentException("Argument 'element' does not belong to this list"); }
            
      Node<E> newNode = new Node<>(element);
      
      if( tail == node ){
         node.next = newNode;
         this.tail = newNode;      
      }else{
         newNode.next = node.next;
         node.next = newNode;
      }
      
      size++;
      
      return newNode;
   }
   
   public E removeHead() throws NoSuchElementException{
      
      if( isEmpty() ){ throw new NoSuchElementException("Cannot remove from empty list"); }
      
      Node<E> oldHead = head;
      
      if( size == 1 ){
         this.head = null;
         this.tail = null;
      }else{
         this.head = this.head.next;
      }
      
      size--;
      
      return oldHead.element;      
   }
   
   public E removeAfter( Node<E> node ) throws IllegalArgumentException, NoSuchElementException{
   
      if( node == null ){ throw new IllegalArgumentException("Argument 'element' cannot be null"); }
      if( node.getOwner() != this ){ throw new IllegalArgumentException("Argument 'element' does not belong to this list"); }
      if( node.next == null ){ throw new IllegalArgumentException("Argument 'element' must have a non-null next element"); }
      
      Node<E> nodeToRemove = node.next;
      
      if( nodeToRemove == tail ){
         node.next = null;
         this.tail = node;
      }else{
         node.next = nodeToRemove.next;
      }
      
      size--;
      
      return nodeToRemove.element;       
   }
}