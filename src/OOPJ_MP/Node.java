package OOPJ_MP;

/**
 * This is a Node class that Used to Add data into OOPJ_MP.{@link LinkedList} class it is like Container that carry your any type of data
 * @param <Type> This class is dynamic so you can Store any type of data in this class . and you have to provide that class type in this parameter Type
 * @author <a href = "https://codewithmk.site/" target="_blank">Mohit Makwana</a>
 * @see OOPJ_MP.LinkedList
 * @since 2024
 */
public class Node<Type> {
    private Node Next;
    private Type value;

    /**
     * This constructor use to make a node with given Value Note :  the Value should be as type that you specify
     * @param value Value that you want to store in the {@link Node}
     */
    public Node(Type value ){
        this.value = value;
    }

    /**
     * This is Default constructor
     */
    public Node(){

    }

    /**
     * This method returns true if current Node has next Node reference
     * @return true if {@link Node} have reference of Next {@link Node}
     */
    public boolean hasNext(){
        return Next != null;
    }

    /**
     * This method returns the reference of next {@link Node}
     * @return {@link Node} that is next to current {@link Node}
     */
    public Node getNext() {
        return Next;
    }

    /**
     * This method gives the value that you store in this {@link Node}
     * @return Value that stores in this {@link Node}
     */
    public Type getValue() {
        return value;
    }

    /**
     * This method Set value to current {@link Node} so you can change the value of the Node at any time
     * @param value This is the value that you want to store in this {@link Node}
     */
    public void setValue(Type value) {
        if (value != null) {
            this.value = value;
        }
    }

    /**
     * This method that set link of next Node to current node
     * @param next next is new node that link next to current node
     */
     void setNext(Node next) {
        Next = next;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList){
            return this.getValue().equals(((Node) obj).getValue());
        }
        return super.equals(obj);
    }

}