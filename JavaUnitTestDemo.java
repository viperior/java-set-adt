class JavaUnitTestDemo {
   public static void main (String[] args) throws Exception {
     TestSuite unitTests = new TestSuite();
     unitTests.addUnitTest("Different booleans", true, false);
     unitTests.addUnitTest("Matching booleans", true, true);
     unitTests.addUnitTest("Different integers #1", 5, 10);
     unitTests.addUnitTest("Matching integers", 7, 7);
     unitTests.addUnitTest("Different strings", "hamburger", "taco");
     unitTests.addUnitTest("Matching strings", "cheese", "cheese");
     unitTests.addUnitTest("Different integers #2", 27, 28);
     unitTests.displayResults();
   }
}
