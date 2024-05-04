package OOPJ_MP;

/**
 * This Exception is thow when The {@link LinkedList} is empty
 * @author <a href = "https://codewithmk.site/" target="_blank">Mohit Makwana</a>
 * @see java.lang.Exception
 * @since 2024
 *
 */

public class EmptyLinkedListException extends Exception{
    /**
     * This is the Exception that is useless for now
     * @param msg This is the message that shows with the Exception
     */
    public EmptyLinkedListException(String msg){
        super(msg);
    }

}
