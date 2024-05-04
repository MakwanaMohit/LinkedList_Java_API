package OOPJ_MP;

public class exam {
    public static void main(String[] args) {
        Node i = new Node();
        NodeNotFoundException neee = new NodeNotFoundException("hello");
        EmptyLinkedListException d = new EmptyLinkedListException("hello");
    }
    public static void maiin(String[] args) throws NodeNotFoundException, EmptyLinkedListException {
        Node i = new Node();
        NodeNotFoundException neee = new NodeNotFoundException("hello");
        EmptyLinkedListException d = new EmptyLinkedListException("hello");
        LinkedList l = new LinkedList();
        l.insert(LinkedList.END,new Node<String>("hello this is string0"));
        l.insert(LinkedList.END,new Node<String>("hello this is string1"));
        l.insert(LinkedList.END,new Node<String>("hello this is string2"));
        l.insert(LinkedList.END,new Node<String>("hello this is string3"));
        l.insert(LinkedList.END,new Node<String>("hello this is string4"));
        l.insert(LinkedList.END,new Node<String>("hello this is string5"));
        l.insert(LinkedList.END,new Node<String>("hello this is string6"));
        l.insert(LinkedList.END,new Node<String>("hello this is string7"));
        l.insert(LinkedList.END,new Node<String>("hello this is string8"));
        l.insert(LinkedList.END,new Node<String>("hello this is string9"));
        System.out.println(l.pop(LinkedList.AFTER,l.NodeAt(6)).getValue());
        System.out.println("after pop the element");
        for(Node n : l.toArray()){
            System.out.println(n.getValue());

        }
        System.out.println("after the first print");System.out.println(l.pop(LinkedList.AFTER,l.NodeAt(6)).getValue());
        System.out.println("after pop the second time ");
        for(Node n : l.toArray()){
            System.out.println(n.getValue());
        }
    }
}
