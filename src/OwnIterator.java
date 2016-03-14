/**
 * Created by Magdalena Polak on 14.03.2016.
 */
public interface OwnIterator
{
    public void first();
    public void next();
    public boolean isDone();
    public Object current() throws IteratorOutOfBoundsException;

}
