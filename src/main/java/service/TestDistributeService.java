package service;

import testrecord.TestDataLoader;

public class TestDistributeService {

  // Set test devices
  private TestDevices testDevices;

  // Set test records
  private TestDataLoader testDataLoader;

  // Set method
  private Method method;

  public TestDistributeService(
      TestDevices testDevices, TestDataLoader testDataLoader, Method method) {
    this.setTestDevices(testDevices);
    this.setTestDataLoader(testDataLoader);
    this.setMethod(method);
  }

  public void setTestDevices(TestDevices testDevices) {
    this.testDevices = testDevices;
  }

  public void setTestDataLoader(TestDataLoader testDataLoader) {
    this.testDataLoader = testDataLoader;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public void execute() {
    this.method.run(testDevices, testDataLoader);
  }
}
