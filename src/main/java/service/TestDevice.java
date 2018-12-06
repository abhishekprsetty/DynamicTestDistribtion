package service;

import java.util.ArrayList;
import java.util.List;

public class TestDevice {

  private String deviceName;
  private List<String> testCases;
  private Integer expectedTestSecs;
  private Integer maxExecutedSecs;

  public TestDevice(String deviceName, Integer maxExecutedSecs) {
    this.setDeviceName(deviceName);
    this.setTestCases(new ArrayList<>());
    this.setExpectedTestSecs(0);
    this.setMaxExecutedSecs(maxExecutedSecs);
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public List<String> getTestCases() {
    return testCases;
  }

  public void setTestCases(List<String> testCases) {
    this.testCases = testCases;
  }

  public void addTestCase(String testCase) {
    this.testCases.add(0, testCase);
  }

  public Integer getExpectedTestSecs() {
    return expectedTestSecs;
  }

  public void setExpectedTestSecs(Integer expectedTestSecs) {
    this.expectedTestSecs = expectedTestSecs;
  }

  public void addExpectedTestSecs(Integer addSecs) {
    this.expectedTestSecs = expectedTestSecs + addSecs;
  }

  public Integer getMaxExecutedSecs() {
    return maxExecutedSecs;
  }

  public void setMaxExecutedSecs(Integer maxExecutedSecs) {
    this.maxExecutedSecs = maxExecutedSecs;
  }
}
