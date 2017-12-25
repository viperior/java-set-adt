class UnitTest {
  private boolean actualBoolean;
  private int actualInteger;
  private String actualString;
  private boolean expectedBoolean;
  private int expectedInteger;
  private String expectedString;
  private String label;
  private boolean match;
  private String type;

  public UnitTest() {
    clear();
  }

  public UnitTest(String testName, boolean expected, boolean actual) {
    clear();
    setType("boolean");
    setLabel(testName);
    setExpectedBoolean(expected);
    setActualBoolean(actual);
    determineMatch();
  }

  public UnitTest(String testName, int expected, int actual) {
    clear();
    setType("integer");
    setLabel(testName);
    setExpectedInteger(expected);
    setActualInteger(actual);
    determineMatch();
  }

  public UnitTest(String testName, String expected, String actual) {
    clear();
    setType("string");
    setLabel(testName);
    setExpectedString(expected);
    setActualString(actual);
    determineMatch();
  }

  private void clear() {
    setMatch(false);
    setType("");
    setActualBoolean(false);
    setActualInteger(0);
    setActualString("");
    setExpectedBoolean(false);
    setExpectedInteger(0);
    setExpectedString("");
  }

  private void determineMatch() {
    if ( getType().equals("boolean") ) {
      setMatch( getExpectedBoolean() == getActualBoolean() );
    }
    else if ( getType().equals("integer") ) {
      setMatch( getExpectedInteger() == getActualInteger() );
    }
    else if ( getType().equals("string") ) {
      setMatch( getExpectedString().equals(getActualString()) );
    }
  }

  public void displayResult() {
    String outputText, passFailText;

    outputText = "";
    passFailText = "";

    if (getMatch()) {
      passFailText = "PASS";
    }
    else {
      passFailText = "FAIL";
    }

    outputText = passFailText + ": " + getLabel() + " (";

    if ( getType().equals("boolean") ) {
      outputText += getExpectedBoolean() + ", " + getActualBoolean();
    }
    else if ( getType().equals("integer") ) {
      outputText += getExpectedInteger() + ", " + getActualInteger();
    }
    else if ( getType().equals("string") ) {
      outputText += getExpectedString() + ", " + getActualString();
    }

    outputText += ")";

    System.out.println(outputText);
  }

  private boolean getActualBoolean() {
    return actualBoolean;
  }

  private int getActualInteger() {
    return actualInteger;
  }

  private String getActualString() {
    return actualString;
  }

  private boolean getExpectedBoolean() {
    return expectedBoolean;
  }

  private int getExpectedInteger() {
    return expectedInteger;
  }

  private String getExpectedString() {
    return expectedString;
  }

  private String getLabel() {
    return label;
  }

  public boolean getMatch() {
    return match;
  }

  private String getType() {
    return type;
  }

  private void setActualBoolean(boolean bool) {
    actualBoolean = bool;
  }

  private void setActualInteger(int value) {
    actualInteger = value;
  }

  private void setActualString(String text) {
    actualString = text;
  }

  private void setExpectedBoolean(boolean bool) {
    expectedBoolean = bool;
  }

  private void setExpectedInteger(int value) {
    expectedInteger = value;
  }

  private void setExpectedString(String text) {
    expectedString = text;
  }

  private void setLabel(String text) {
    label = text;
  }

  private void setMatch(boolean status) {
    match = status;
  }

  private void setType(String text) {
    type = text;
  }
}
