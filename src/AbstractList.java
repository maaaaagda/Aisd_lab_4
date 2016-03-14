/**
 * Created by Magdalena Polak on 14.03.2016.
 */


// zestaw metod u�atwiaj�cych implementacj� list
public abstract class AbstractList implements List
{
    // wydruk wszystkich element�w listy
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        if (!isEmpty()) {
            OwnIterator i = (OwnIterator) iterator();
            for (i.first(); !i.isDone(); i.next())
                buffer.append(i.current()).append(", ");
            buffer.setLength(buffer.length() - 2);
        }
        buffer.append(']');
        return buffer.toString();
    }

    // ^ - bitowa r�nica symetryczna
    public int hashCode() {
        int hashCode = 0;
        OwnIterator i = (OwnIterator) iterator();
        for (i.first(); !i.isDone(); i.next())
            hashCode ^= i.current().hashCode();
        return hashCode;
    }

    public boolean equals(Object object) {
        return object instanceof List ? equals((List) object) : false;
    }

    public boolean equals(List other) {
        if (other == null || size() != other.size())
            return false;
        else { OwnIterator i = (OwnIterator) iterator();
            OwnIterator j = (OwnIterator) other.iterator();
            for(i.first(),j.first();!i.isDone() && !j.isDone() &&
                    i.current().equals(j.current()); i.next(), j.next());
            return i.isDone() && j.isDone();
        }
    }

}