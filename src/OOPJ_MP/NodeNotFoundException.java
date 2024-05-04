package OOPJ_MP;

/**
 * This Exception is thow when you try to Find the Node that dosen't exits
 * @author <a href = "https://codewithmk.site/" target="_blank">Mohit Makwana</a>
 * @see java.lang.Exception
 * @since 2024
 *
 */
public class NodeNotFoundException extends Exception{
    /**
     * This is base constructor used to generate a Exception
     * @param msg this is a message that want to pass with Exception
     */
    public NodeNotFoundException(String msg){
        super(msg);
    }
}
