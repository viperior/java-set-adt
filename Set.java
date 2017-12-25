class Set implements SetInterface {
  private static int MAX_ITEM_COUNT = 100;
  private int count;
  private Item[] items;
  private int number;

  public Set() {
    clear();
  }

  public void add(Item newItem) {
    if ( isFull() ) {
      System.out.println("This set already contains the maximum number of items.");
    }
    else {
      if ( !contains(newItem.getName()) ) {
        setItem(getCount(), newItem);
        incrementCount();
      }
    }
  }

  public void add(SetInterface foreignSet) {
    if ( (getCount() + foreignSet.getCount()) > MAX_ITEM_COUNT ) {
      System.out.println("These sets contain too many items to combine.");
    }
    else {
      SetInterface copyOfForeignSet;

      copyOfForeignSet = copy(foreignSet);

      while ( !copyOfForeignSet.isEmpty() ) {
        add(copyOfForeignSet.remove());
      }
    }
  }

  private void clear() {
    count = 0;
    items = new Item[MAX_ITEM_COUNT];
  }

  private SetInterface copy() {
    SetInterface copyOfSet, returnSet;

    copyOfSet = new Set();
    returnSet = new Set();

    while ( !isEmpty() ) {
      Item removedItem = remove();

      copyOfSet.add(removedItem);
      returnSet.add(removedItem);
    }

    while ( !copyOfSet.isEmpty() ) {
      add(copyOfSet.remove());
    }

    return returnSet;
  }

  private SetInterface copy(SetInterface foreignSet) {
    SetInterface copyOfForeignSet, returnSet;

    copyOfForeignSet = new Set();
    returnSet = new Set();

    while ( !foreignSet.isEmpty() ) {
      Item removedItem = foreignSet.remove();

      copyOfForeignSet.add(removedItem);
      returnSet.add(removedItem);
    }

    while ( !copyOfForeignSet.isEmpty() ) {
      foreignSet.add(copyOfForeignSet.remove());
    }

    return returnSet;
  }

  public boolean contains(String itemName) {
    return getIndexOfItem(itemName) != -1;
  }

  private void decrementCount() {
    setCount(getCount() - 1);
  }

  public SetInterface difference(SetInterface foreignSet) {
    SetInterface copyOfThisSet, differenceSet, intersectionSet;

    copyOfThisSet = copy();
    differenceSet = copy();
    intersectionSet = intersect(foreignSet);

    for (int i = 0; i < getCount(); i++) {
      String currentItemName;

      currentItemName = getItem(i).getName();

      if ( intersectionSet.contains(getItem(i).getName()) ) {
        differenceSet.remove(currentItemName);
      }
    }

    add(copyOfThisSet);

    return differenceSet;
  }

  public void displayContents() {
    System.out.println("");
    for (int i = 0; i < getCount(); i++) {
      System.out.println(getItem(i).getName());
    }
    System.out.println("");
  }

  public int getCount() {
    return count;
  }

  private int getIndexOfItem(String itemName) {
    boolean found;
    int i, index;

    found = false;
    i = 0;
    index = -1;

    if ( !isEmpty() ) {
      do {
        if ( getItem(i).getName().equals(itemName) ) {
          found = true;
          index = i;
        }

        i++;
      } while ( i < getCount() && !found );
    }

    return index;
  }

  private Item getItem(int index) {
    return items[index];
  }

  private void incrementCount() {
    setCount(getCount() + 1);
  }

  public SetInterface intersect(SetInterface foreignSet) {
    SetInterface intersectionSet = new Set();

    for (int i = 0; i < getCount(); i++) {
      Item currentItem;
      String currentItemName;

      currentItem = getItem(i);
      currentItemName = currentItem.getName();

      if ( foreignSet.contains(currentItemName) ) {
        intersectionSet.add(currentItem);
      }
    }

    return intersectionSet;
  }

  public boolean isEmpty() {
    return getCount() == 0;
  }

  public boolean isFull() {
    return getCount() == MAX_ITEM_COUNT;
  }

  public Item remove() {
    Item returnItem = new Item("empty");

    if ( isEmpty() ) {
      System.out.println("Cannot remove an item from an empty set.");
    }
    else {
      returnItem = getItem(getCount() - 1);
      decrementCount();
    }

    return returnItem;
  }

  public Item remove(String itemName) {
    Item returnItem = new Item("empty");

    if ( isEmpty() ) {
      System.out.println("Cannot remove an item from an empty set.");
    }
    else {
      if ( contains(itemName) ) {
        if ( getCount() > 1 ) {
          swapItems(getIndexOfItem(itemName), getCount() - 1);
        }

        returnItem = remove();
      }
      else {
        System.out.println(itemName + " not found in set.");
      }
    }

    return returnItem;
  }

  private void setCount(int number) {
    count = number;
  }

  private void setItem(int index, Item item) {
    items[index] = item;
  }

  private void swapItems(int indexA, int indexB) {
    Item tempItem;

    tempItem = getItem(indexA);
    setItem(indexA, getItem(indexB));
    setItem(indexB, tempItem);
  }

  public SetInterface union(SetInterface foreignSet) {
    SetInterface unionSet = new Set();

    unionSet.add(difference(foreignSet));
    unionSet.add(foreignSet.difference(this));
    unionSet.add(intersect(foreignSet));

    return unionSet;
  }
}
