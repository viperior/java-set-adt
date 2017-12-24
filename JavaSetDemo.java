class JavaSetDemo {
   public static void main (String[] args) throws Exception {
     TestSuite unitTests = new TestSuite();
     unitTests.addUnitTest(true, false);
     unitTests.addUnitTest(true, true);
     unitTests.addUnitTest(5, 10);
     unitTests.addUnitTest(7, 7);
     unitTests.addUnitTest("hamburger", "taco");
     unitTests.addUnitTest("cheese", "cheese");
     unitTests.addUnitTest(27, 28);
     unitTests.displayResults();
   }
}
