public class SinglyLinkedList<E>
{
   private Node<E> head;
   private Node<E> tail;
   private int size;
   
   public int size(){ return this.size; }
   public boolean isEmpty(){ return this.size == 0; }
   
   public Node<E> insertHead( E element )
   {
      Node<E> newNode = new Node<>(element);    //next is null by default
      
      if( isEmpty() )
      {
         this.head = newNode;
         this.tail = newNode;
      }else
      {
         newNode.next = head;       //update next from null to current head of list
         this.head = newNode;       //set head to newNode
      }
      
      this.size++;
      return newNode;
   }
   
   public Node<E> insertTail( E element )
   {
      Node<E> newNode = new Node<>(element);    //next is null by default
      
      if( isEmpty() )
      {
         this.head = newNode;
         this.tail = newNode;
      }else
      {
         this.tail.next = newNode;  //update next from null to newNode
         this.tail = newNode;       //update tail to newNode
      }
      
      this.size++;
      return newNode;
   }
   
   public Node<E> removeHead()
   {
      Node<E> oldHead = this.head;  //save the current head
      
      if( isEmpty() )
         return null;
      else
         this.head = this.head.next;
         
      this.size--;      
      return oldHead;
   }
   
   public Node<E> insertAfter( Node<E> node, E element )
   {
      Node<E> newNode = new Node<E>(element);
      
      if( isEmpty() )
         insertHead(element);
      else
      {
         if( node == tail )
         {
            insertTail( element );
         }else
         {
            newNode.next = node.next;
            node.next = newNode;
            this.size++;
         }  
      }    
      return newNode;
   }
   
   public Node<E> removeAfter( Node<E> node )
   {
      if( isEmpty() )
         return null;
      else
      {
         if( node == tail )
            return null;
         else
         {
            Node<E> removedNode = node.next;
            node.next = removedNode.next;
            return removedNode;
         }
      }
          
   }
     
   class Node<E>
   {
      //data fields
      E element;
      Node<E> next;     //reference to next Node
      
      public Node( E elem )
      {
         this.element = elem;
         this.next = null;
      }
      
      public E getElement(){ return this.element; }
      public Node<E> getNext(){ return this.next; }
   }
}