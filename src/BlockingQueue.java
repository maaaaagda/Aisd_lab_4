/**
 * Created by Magdalena Polak on 14.03.2016.
 */
public class BlockingQueue implements  Queue
{
    private final Object _mutex = new Object();
    private final Queue _queue = null;

    private final Object [] tab = new Object[0];
    private final int _maxSize = 0;
    public BlockingQueue(Queue queue, int _maxSize)
    {
        assert queue != null : "nie okreslono kolejki";
        assert _maxSize>0 : "maksyalny rozmiar ma byc dodatni";

    }
    public BlockingQueue(Queue queue)
    {
        this(queue, Integer.MAX_VALUE);
    }
    public void enqueue(Object value)
    {
        synchronized(_mutex){
            while(size()==_maxSize)
            {
                waitForNotification();
            }
            _queue.enqueue(value);
            _mutex.notifyAll();
        }
    }
    private void waitForNotification()
    {
        try{
            _mutex.wait();
        }
        catch (InterruptedException e){

        }
    }

    public Object dequeue() throws EmptyQueueException {
        synchronized (_mutex)
        {
            while(isEmpty())
            {
                waitForNotification();
            }
            Object value = _queue.dequeue();
            _mutex.notifyAll();
            return  value;
        }
    }
    public void clear()
    {
        synchronized (_mutex)
        {
            _queue.clear();
            _mutex.notifyAll();
        }
    }
    public int size()
    {
        synchronized (_mutex)
        {
            return  _queue.size();
        }
    }
    public boolean isEmpty()
    {
        synchronized (_mutex)
        {
            return _queue.isEmpty();
        }
    }
}
