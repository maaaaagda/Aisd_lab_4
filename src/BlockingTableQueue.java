/**
 * Created by Magdalena Polak on 15.03.2016.
 */


public class BlockingTableQueue implements  Queue
{

    private  Object [] tab = new Object[0];
    private  int _maxSize = 0;
    public BlockingTableQueue(Object[] tab, int _maxSize)
    {

        assert tab != null : "nie okreslono kolejki";
        assert _maxSize>0 : "maksyalny rozmiar ma byc dodatni";
        Object [] tab2 = new Object[_maxSize];
        for(int i = 0; i <_maxSize; i++)
        {
            if(i<tab.length)
                tab2[i] = tab[i];
            else{
                tab2[i] = null;
            }
        }
        this._maxSize = _maxSize;
        this.tab = tab2;




    }
    public BlockingTableQueue(Object[] tab)
    {
        this(tab, Integer.MAX_VALUE);
    }
    public void enqueue(Object value)
    {

            if (tab.length>_maxSize)
            {

                throw new FullQueueException(  "Queue is full. Please wait" );

            }
            else
            {
                for(int i = 0; i <_maxSize; i++)
                {
                    if(tab[i]== null)
                    {
                        tab[i] = value;
                        break;
                    }
                }

                }
    }

    public Object dequeue() throws EmptyQueueException
    {
        Object value;
        if(tab.length == 0)
            {
                System.out.println("Kolejka pusta");
                throw new EmptyQueueException();

            }
        else{
            value = tab[0];
            for(int i = 0; i <tab.length-1; i++)
            {
                    Object temp =  tab[i+1];
                    tab[i] = temp;
                    //temp = tab[i];
            }
           return  value;
            }

    }
    public void clear()
    {
        _maxSize = 0;
        Object [] empty = new Object [0];
        tab = empty;

    }
    public int size()
    {
         return  tab.length;

    }
    public boolean isEmpty()
    {
         return tab.length == 0;

    }
    public void printQueue()
    {
        for(int i = 0; i <tab.length; i++)
        {
            if(tab[i]!=null)
            System.out.println(tab[i]);

        }
    }
}
