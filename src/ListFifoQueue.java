/**
 * Created by Magdalena Polak on 14.03.2016.
 */


    public class ListFifoQueue //implements Queue
{
    private static class Element
    {
        private Element _next;
        private Object _value;
        public Element(Object value)
        {
            set_value(value);
        }
        public void set_value(Object value)
        {
            _value = value;

        }
        public Object get_value()
        {
            return _value;
        }
        public Element get_next()
        {
            return _next;
        }
        public Element set_next(Element next)
        {
            return _next = next;
        }
    }
    private int _size;
    private Element _first = new Element(null);

    public void enqueue(Object value)
    {
        Element e = new Element(value);
        if(_first.get_value()== null)
        {
            _first = e;
              e._next = null;
            _size++;
        }
        else
        {
            Element f = _first;
            while (f.get_next() != null)
            {
                f = f.get_next();
            }
            ++_size;
            f.set_next(new Element(value));
        }
    }

    public Object dequeue() throws EmptyQueueException
    {
        if(_first.get_value() == null)
        {
            throw new EmptyQueueException();
        }
        else if(_first.get_next()== null)
        {
            --_size;
            return _first;

        }
        else
        {
            Element f = _first;
            _first = _first.get_next();
               --_size;
            return f.get_value();
        }

    }

    public void clear()
    {
        _size = 0;
        _first = new Element(null);
    }

    public int size()
    {
        return  _size;
    }

    public boolean isEmpty()
    {
        return false;
    }
    public void printList()
    {
        Element temp =_first;
        while (temp != null)
        {
            System.out.println(temp.get_value());
            temp = temp.get_next();
        }
        System.out.println(" ");
    }
     /*   private final List _list;

        public ListFifoQueue() {
            this(new LinkedList());
        }
        public ListFifoQueue(List list)
        {  _list = list; }

        public void enqueue(Object value)
        {  _list.add(value); }

        public Object dequeue() throws EmptyQueueException {
            if (isEmpty()) {
                throw new EmptyQueueException();
            }
          else {

                _list.delete(0);
                return 1;
            }

        }
        public void clear()
        {  _list.clear(); }

        public int size()
        {  return _list.size(); }

        public boolean isEmpty()
        {  return _list.isEmpty(); }

        public void printFifoQueue()
        {
            for(int i = 0; i<_list.size(); i++)
            {
                System.out.println(_list.get(i));
            }
        }
        public String toString()
        { return _list.toString();}
        */
    }


