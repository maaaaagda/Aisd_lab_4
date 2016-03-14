/**
 * Created by Magdalena Polak on 14.03.2016.
 */

    /**
     * zwyk³a kolejka FIFO bazuj¹ca na liœcie wi¹zanej
     */
    public class ListFifoQueue implements Queue {
        private final List _list;

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
            return _list.delete(0);
        }
        public void clear()
        {  _list.clear(); }

        public int size()
        {  return _list.size(); }

        public boolean isEmpty()
        {  return _list.isEmpty(); }

        public void getq()
        {
            for(int i = 0; i<_list.size(); i++)
            {
                System.out.println(_list.get(i));
            }
        }
        public String toString()
        { return _list.toString();}
    }


