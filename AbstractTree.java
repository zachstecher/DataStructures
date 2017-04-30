
public abstract class AbstractTree<E> implements Tree<E>
{
	public boolean isInternal(Position<E> p) {return numChildren(p) > 0;}
	public boolean isExternal(Position<E> p) {return numChildren(p) == 0;}
	public boolean isRoot(Position<E> p) {return p == root();}
	public boolean isEmpty() {return size() == 0;}
	
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot)
	{
		snapshot.add(0, p);
		for(Position<E> c : children(p))
		{
			preorderSubtree(c, snapshot);
		}
	}
	public Iterable<Position<E>> preorder()
	{
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
		{
			preorderSubtree(root(), snapshot);
		}
		return (Iterable<Position<E>>) snapshot;
	}
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot)
	{
		for (Position<E> c: children(p))
		{
			postorderSubtree(c, snapshot);
		}
		snapshot.add(0,  p);
	}
	public Iterable<Position<E>> postorder()
	{
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
		{
			postorderSubtree(root(), snapshot);
		}
		return (Iterable<Position<E>>) snapshot;
	}
}
