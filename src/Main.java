/**
 * Created by Magdalena Polak on 14.03.2016.
 */

public class Main
{
    public static void main(String[] args) {

      //  LinkedList l = new LinkedList();
        int a = 5;
        int b = 6;
        int c = 28;
    /*    l.add(a);
        l.add(b);
        l.add(c);
        l.printList();
        l.delete(6);
        l.printList();
        l.insert(1, a);
        l.printList();
        ListFifoQueue q = new ListFifoQueue();
        q.enqueue(a);
        q.enqueue(b);
        q.enqueue(c);
        q.getq();
        */
        Page p1 = new Page("blue");
        Page p2 = new Page("red");
        Page p3 = new Page("green");
        Page []tab = new Page[]{p1, p2, p3};
        BlockingTableQueue t = new BlockingTableQueue(tab, 8);
        t.printQueue();
        t.enqueue(a);
        t.enqueue(b);
        t.enqueue(c);
        t.printQueue();


    }
}
