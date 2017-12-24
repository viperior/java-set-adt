class TestSuite {
  private static int MAX_TEST_COUNT = 100;
  private int failCount;
  private int passCount;
  private int testCount;
  private UnitTest[] unitTests;

  public TestSuite() {
    unitTests = new UnitTest[MAX_TEST_COUNT];
    setFailCount(0);
    setPassCount(0);
    setTestCount(0);
  }

  public void addUnitTest(boolean expected, boolean actual) {
    if ( getTestCount() >= MAX_TEST_COUNT ) {
      displayUnitTestMaxCountReachedError();
    }
    else {
      UnitTest test = new UnitTest(expected, actual);
      setUnitTest(getTestCount(), test);
      incrementTestCount();
    }
  }

  public void addUnitTest(int expected, int actual) {
    if ( getTestCount() >= MAX_TEST_COUNT ) {
      displayUnitTestMaxCountReachedError();
    }
    else {
      UnitTest test = new UnitTest(expected, actual);
      setUnitTest(getTestCount(), test);
      incrementTestCount();
    }
  }

  public void addUnitTest(String expected, String actual) {
    if ( getTestCount() >= MAX_TEST_COUNT ) {
      displayUnitTestMaxCountReachedError();
    }
    else {
      UnitTest test = new UnitTest(expected, actual);
      setUnitTest(getTestCount(), test);
      incrementTestCount();
    }
  }

  private void determineFailCount() {
    setFailCount(0);

    for (int i = 0; i < getTestCount(); i++) {
      if ( !getUnitTest(i).getMatch() ) {
        incrementFailCount();
      }
    }
  }

  private void determinePassCount() {
    setPassCount(0);

    for (int i = 0; i < getTestCount(); i++) {
      if ( getUnitTest(i).getMatch() ) {
        incrementPassCount();
      }
    }
  }

  private void displayFailCount() {
    System.out.println("Failures: " + getFailCount());
  }

  private void displayPassCount() {
    System.out.println("Passes: " + getPassCount());
  }

  public void displayResults() {
    determinePassCount();
    determineFailCount();
    System.out.println("Test Suite Results");
    System.out.println("Test count: " + getTestCount());
    displayPassCount();
    displayFailCount();
  }

  private void displayUnitTestMaxCountReachedError() {
    System.out.println("Maximum number of unit tests added to test suite (" + getTestCount() + ").");
  }

  private int getFailCount() {
    return failCount;
  }

  private int getPassCount() {
    return passCount;
  }

  private int getTestCount() {
    return testCount;
  }

  private UnitTest getUnitTest(int index) {
    UnitTest test = new UnitTest();

    if ( index < 0 || index >= getTestCount() ) {
      System.out.println("Invalid unit test index (" + index + ")");
    }
    else {
      test = unitTests[index];
    }

    return test;
  }

  private void incrementFailCount() {
    setFailCount(getFailCount() + 1);
  }

  private void incrementPassCount() {
    setPassCount(getPassCount() + 1);
  }

  private void incrementTestCount() {
    setTestCount(getTestCount() + 1);
  }

  private void setFailCount(int count) {
    failCount = count;
  }

  private void setPassCount(int count) {
    passCount = count;
  }

  private void setTestCount(int count) {
    testCount = count;
  }

  private void setUnitTest(int index, UnitTest test) {
    if ( index < 0 || index >= MAX_TEST_COUNT ) {
      System.out.println("Invalid unit test index (" + index + ")");
    }
    else {
      unitTests[index] = test;
    }
  }
}
