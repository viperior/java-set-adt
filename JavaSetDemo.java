import java.util.*;
import java.io.*;

class JavaSetDemo {
  public static void main (String[] args) throws Exception {
    Item item;
    Scanner sc;
    Set setA, setB, setC, setD;
    TestSuite unitTests;

    setA = new Set();
    setB = new Set();
    setC = new Set();
    setD = new Set();
    unitTests = new TestSuite();

    sc = new Scanner(new File("set1.txt"));
    while (sc.hasNextLine())
    {
      setA.add(new Item(sc.nextLine()));
    }

    sc = new Scanner(new File("set2.txt"));
    while (sc.hasNextLine())
    {
      setB.add(new Item(sc.nextLine()));
    }

    System.out.println();
    System.out.println("There are " + setA.getCount() + " items in Set 1.");
    System.out.println("There are " + setB.getCount() + " items in Set 2.");

    System.out.println();
    System.out.println("Give name of item to remove from Set 1");
    sc = new Scanner(System.in);
    item = setA.remove(sc.nextLine());

    System.out.println();
    System.out.println("Give name of item to remove from Set 2");
    sc = new Scanner(System.in);
    item = setB.remove(sc.nextLine());

    System.out.println();
    System.out.println("There are " + setA.getCount() + " items in Set 1.");
    System.out.println("There are " + setB.getCount() + " items in Set 2.");

    System.out.println();
    System.out.println("There are " + setA.union(setB).getCount() + " items in S1 union S2.");
    System.out.println("There are " + setA.intersect(setB).getCount() + " items in S1 intersect S2.");
    System.out.println("There are " + setA.difference(setB).getCount() + " items in S1 minus S2.");
    System.out.println("There are " + setB.difference(setA).getCount() + " items in S2 minus S1.");

    setC.add(new Item("apple"));
    setC.add(new Item("banana"));
    setC.add(new Item("coffee"));
    setC.add(new Item("doughnut"));
    setC.add(new Item("apple"));
    setC.add(new Item("banana"));
    setC.add(new Item("eggs"));
    setC.add(new Item("flour"));
    setD.add(new Item("apple"));
    setD.add(new Item("banana"));
    setD.add(new Item("coffee"));
    setD.add(new Item("apple"));
    setD.add(new Item("banana"));
    setD.add(new Item("coffee"));
    setD.add(new Item("grapes"));
    setD.add(new Item("honey"));
    setC.remove("apple");
    setD.remove("banana");

    unitTests.addUnitTest("Set C Item Count", 5, setC.getCount());
    unitTests.addUnitTest("Set D Item Count", 4, setD.getCount());
    unitTests.addUnitTest("Union Item Count", 8, setC.union(setD).getCount());
    unitTests.addUnitTest("Intersect Item Count", 1, setC.intersect(setD).getCount());
    unitTests.addUnitTest("Difference Item Count #1", 4, setC.difference(setD).getCount());
    unitTests.addUnitTest("Difference Item Count #2", 3, setD.difference(setC).getCount());

    unitTests.displayResults();
  }
}
