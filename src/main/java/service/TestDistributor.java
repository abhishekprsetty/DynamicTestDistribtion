package service;

import java.util.List;
import java.util.Map;

import testrecord.TestDataLoader;

public abstract class TestDistributor {

  // Set test records
  protected TestDataLoader testDataLoader;

  public TestDistributor(TestDataLoader testDataLoader) {
    this.setTestDataLoader(testDataLoader);
  }

  public void setTestDataLoader(TestDataLoader testDataLoader) {
    this.testDataLoader = testDataLoader;
  }

  public abstract Map<TestDevice, List<Long>> getDistribution(TestDevices testDevices);
  
  //public abstract Map<TestDevice, List<Long>> getDistribution(List<TestDevice> testDevices);

  public abstract Map<TestDevice, List<Long>> getDistribution(
      List<String> deviceNames, int maxExecution);
}
