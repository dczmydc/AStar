import java.util.Comparator;

public class NodeComparator implements Comparator<Node>
{
    @Override
    public int compare(Node x, Node y)
    {
        if (x.getF() > y.getF()) return 1;
        if (x.getF() < y.getF()) return -1;
        else return 0;
    }
}
