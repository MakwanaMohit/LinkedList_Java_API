package OOPJ_MP;

import java.util.Iterator;

/**
 * This is a class to make a list with Dynamic data type you can store any type of data together in this list
 * You need to make an instance of OOPJ_MP.{@link Node} class and this element is inserted in this class
 * @author <a href = "https://codewithmk.site/" target="_blank">Mohit Makwana</a><a href = "https://codewithmk.site/" target="_blank">Neha Kavaiya</a>
 * @see OOPJ_MP.Node
 * @since 2024
 */
public class LinkedList implements Iterable<Node>{
    /**
     * This shows the length of the node available in the {@link LinkedList}
     */
    public int length;
    private Node First;
    /**
     *This variable show the Position at where you want to add the node
     */
    public static final int BEGINNING = -1, BEFORE = -2 , AFTER = -3 , END = -4;

    /**
     * default constructor
     */
    public LinkedList(){

    }


    /**
     *When you want to insert a Node in a specific Index then this method is used
     * @param Index In which Index you want to insert the node
     * @param New_Node New Node that inserted in the LinkedList
     * @return Index where the node is inserted
     * @throws IndexOutOfBoundsException When you enter an Invalid index then it throws {@link IndexOutOfBoundsException}
     */
    public int insertAt(int Index , Node New_Node) throws IndexOutOfBoundsException{
        if (0 < Index && Index< length) {
            Node save = First;
            for (int i = 0; i < length; i++) {
                if (i+1 == Index){
                    New_Node.setNext(save.getNext());
                    save.setNext(New_Node);
                    length += 1;
                }
                save = save.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException("The index is invalid");
        }
        return 0;
    }

    /**
     * This is methid that insert the node at beginning or at end
     * @param Position This is the Position in which you want to add the Node Note: you should use {@link LinkedList}.{@link #BEGINNING} OR {@link #END} for this parameter
     * @param New_Node This is the new Node Instance of OOPJ_MP.{@link Node} class and this is element that inserted in the LinkedList
     * @return Index at which the node is inserted
     * @throws IndexOutOfBoundsException if you provide Wrong Position then the method generate {@link IndexOutOfBoundsException}
     */
    public int insert(int Position,Node New_Node) throws IndexOutOfBoundsException{
        int index = 0;
        Node save = First;
        switch (Position){
            case (BEGINNING):
                New_Node.setNext(First);
                First = New_Node;
                length += 1;
                return index;
            case END:
                if (save != null) {
                    while (save.hasNext()){
                        save = save.getNext();
                        index  += 1;
                    }
                    save.setNext(New_Node);
                    length += 1;
                    return index;
                }else{
                    First = New_Node;
                    length += 1;
                }
                break;
            default:
                throw new IndexOutOfBoundsException("you must provide a specific Position from LinkedList.BEGINNING,BEFORE,AFTER,END");
        }
return 0;
    }

    /**
     * This method used to insert the node to Before a Node Or After a Node
     * @param Position This is the Position in which you want to add the Node Note: you should use {@link LinkedList}.{@link #BEFORE} OR {@link #AFTER}  for this parameter
     * @param New_Node This is the new Node Instance of OOPJ_MP.{@link Node} class and this is element that inserted in the LinkedList
     * @param Search_Node This is the node where you want to insert the node like before this Search_Node or After the Search_node
     * @return Index at which the node is inserted
     * @throws NodeNotFoundException if your given Search_Node doesn't found in the list then it throws the {@link NodeNotFoundException}
     */
    public int insert(int Position ,Node Search_Node, Node New_Node) throws NodeNotFoundException {
        boolean found = false;
        Node save = First;
        switch (Position){
            case BEGINNING:
                return insert(BEGINNING,New_Node);
            case END:
                return insert(END,New_Node);
            case BEFORE:
                if (save != null) {
                    found = false;
                    save = First;
                    while (save!= null){
                        Node next = save.getNext();
                        if(next.equals(Search_Node)){
                            New_Node.setNext(next);
                            save.setNext(New_Node);
                            found = true;
                            length += 1;
                            break;
                        }
                        save = save.getNext();
                    }
                    if (!found){
                        throw new NodeNotFoundException("the node not found in the LinkedList");
                    }
                }else{
                    throw new NodeNotFoundException("LinkedList is empty");
                }

                break;
            case AFTER:
                if (save != null) {
                    found = false;
                    save = First;
                    while (save!=null){
                        if(save.equals(Search_Node)){
                            New_Node.setNext(save.getNext());
                            save.setNext(New_Node);
                            found = true;
                            length += 1;
                            break;
                        }
                        save = save.getNext();
                    }
                    if (!found){
                        throw new NodeNotFoundException("the node not found in the LinkedList");
                    }
                }else{
                    throw new NodeNotFoundException("LinkedList is empty");
                }break;
        }
        return 0;
    }

    /**
     * This Method POP an element from list with given index The element is pop from list also
     * @param Index this is used to specify at which index you want to remove the node
     * @return the node which just you pop
     * @throws IndexOutOfBoundsException if the given index is not valid then it throws the {@link IndexOutOfBoundsException}
     * @throws EmptyLinkedListException if the List is empty then it throws the {@link EmptyLinkedListException}
     */
    public Node popNodeAt(int Index) throws IndexOutOfBoundsException,EmptyLinkedListException{
        Node save = First;
        if (Index < 0 || Index >=length){
            throw new IndexOutOfBoundsException("The index is invalid");
        }
        if(First == null){
            throw new EmptyLinkedListException("The Linked List is Empty");
        }
        if (Index == 0 ){
            First = save.getNext();
            length -=1;
            return save;
        }else{
            for (int i = 0; i < length; i++) {
                if ((Index - 1) == i){
                    Node temp = save.getNext();
                    save.setNext(temp.getNext());
                    length -= 1;
                    return temp;
                }
                save = save.getNext();
        }}
        return null;
    }

    /**
     * This method pop an element in respect to another node like pop: node before a node or pop node after the node
     * @param Position This is the Position in which you want to pop the node this parameter should pass from {@link LinkedList}.{@link #BEFORE} OR {@link #AFTER}
     * @param Search_Node This is the refrence Node in which respect you want to remove the node This should be OOPJ_MP.{@link Node} class instance
     * @return the element which is removed
     * @throws EmptyLinkedListException if the List is empty then it throws the {@link EmptyLinkedListException}
     * @throws NodeNotFoundException if the given Search Node in not found in the List then it throws {@link NodeNotFoundException}
     */
    public Node pop(int Position ,Node Search_Node) throws EmptyLinkedListException,NodeNotFoundException{
        Node save = First;
        switch (Position){
            case BEGINNING:
                return pop(BEGINNING);
            case END:
                return pop(END);
            case BEFORE:
                while (save.hasNext()){
                    Node t = save.getNext();
                    if (t.getNext().equals(Search_Node)){
                        save.setNext(t.getNext());
                        length -=1;
                        return t;
                    }
                    save = save.getNext();
                }
                throw new NodeNotFoundException("The Search node is not found in the List");
            case AFTER:
                while (save.getValue() != null){
                    Node t = save.getNext();
                    if (save.equals(Search_Node)){
                        if (!save.hasNext()){
                            throw new NodeNotFoundException("there is no node after the given node, cannot pop the element");
                        }
                        save.setNext(t.getNext());
                        length -=1;
                        return t;
                    }
                    save = save.getNext();
                }
                throw new NodeNotFoundException("The Search node is not found in the List");
        }
        return null;
    }

    /**
     * This method pop an element for given Position ie. pop first element from list of pop last element from list
     * @param Position This is the Position in which you want to pop the node this parameter should pass from {@link LinkedList}.{@link #BEGINNING} OR {@link #END}
     * @return the element which is removed
     * @throws EmptyLinkedListException if the List is empty then it throws the {@link EmptyLinkedListException}
     */
    public Node pop(int Position) throws EmptyLinkedListException{
        if(First == null){
            throw new EmptyLinkedListException("The Linked List is Empty");
        }
        Node save = First;
        switch (Position){
            case BEGINNING:
                First = save.getNext();
                length -= 1;
                return save;
            case END:
                while (save.hasNext()){
                    Node t  = save.getNext();
                    if (!t.hasNext()){
                        save.setNext(null);
                        length -=1;
                        return t;
                    }
                    save = save.getNext();
                }
        }
        return null;
    }

    /**
     * This method returns the Node which is at given Index Without removing it from list
     * @param Index you shold specify the index at which you want to access the Node
     * @return the Node that occur at given Index
     */
    public Node nodeAt(int Index){
        if (0 <= Index && Index < length){
            Node save = First;
            for (int i = 0; i < length; i++) {
                if (i == Index){
                    return save;
                }
                save = save.getNext();
            }
        }else {
            throw new IndexOutOfBoundsException("The index is invalid");
        }
    return null;
}

    /**
     * This method search the node is available in {@link LinkedList} or not if available then it returns the index of node in which the node is present
     * @param Search_Node This is the Node which you want to search in the {@link LinkedList}
     * @return it  the Index in which the Node is occurring
     * @throws NodeNotFoundException if the given node is not found in the {@link LinkedList} then it throws {@link NodeNotFoundException}
     */
    public int searchElement(Node Search_Node) throws NodeNotFoundException{
        Node save = First;
        for (int i = 0; i <length ; i++) {
            if (Search_Node.equals(save)){
                return i;
            }
            save = save.getNext();
        }
        throw new NodeNotFoundException("not is not available in the list");
}

    /**
     * This method return a {@link Node[]} array Containing all the element of {@link LinkedList}
     * @return the array of {@link Node} class
     */
    public Node[] toArray(){
        Node[] node = new Node[length];
        Node save = First;
        int index = 0;
    for (int i = 0; i < length; i++) {
        node[i] = save;
        save = save.getNext();
    }
    return node;
}

    /**
     * This {@link LinkedList} class is iterable so to iterate this class using for each loop this is the iterator method
     * @return returns the {@link Iterator<Node>}
     */
    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            Node save = First;
            Node next = First;
            @Override
            public boolean hasNext() {
                return save != null;
            }

            @Override
            public Node next() {
                Node t = save;
                save = save.getNext();
                return t;
            }
        };
    }
}