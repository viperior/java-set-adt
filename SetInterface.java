public interface SetInterface {
   abstract public void add(Item x);
   abstract public void add(SetInterface s);
   abstract public boolean contains(String s);
   abstract public SetInterface difference(SetInterface s);
   abstract public void displayContents();
   abstract public int getCount();
   abstract public SetInterface intersect(SetInterface s);
   abstract public boolean isEmpty();
   abstract public boolean isFull();
   abstract public Item remove();
   abstract public Item remove(String s);
   abstract public SetInterface union(SetInterface s);
}
