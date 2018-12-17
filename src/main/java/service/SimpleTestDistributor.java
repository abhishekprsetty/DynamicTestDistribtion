package service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import testrecord.TestData;
import testrecord.TestDataLoader;

public class SimpleTestDistributor extends TestDistributor {

  public SimpleTestDistributor(TestDataLoader testDataLoader) {
    super(testDataLoader);
  }

  @Override
  public Map<TestDevice, List<Long>> getDistribution(TestDevices testDevices) {

    Map<String, Integer> testTimeMap = new HashMap<>();
    Map<String, Integer> testDataMap = new HashMap<>();

    for (Map.Entry<String, TestDevice> entry : testDevices.getAllDevices().entrySet()) {
      // System.out.println("Init Device " + entry.getKey());
      testTimeMap.put(entry.getKey(), 0);
    }

    for (TestData testData : testDataLoader.getAllData()) {
      testDataMap.put(testData.getId(), testData.getDuration());
      // System.out.println("Put : " + testData.getId() + " , " + testData.getDuration());
    }

    testDataMap = this.sortMapOrderBy(testDataMap, "DESC");

    for (Map.Entry<String, Integer> entry : testDataMap.entrySet()) {
      // Get the deviceName (shortest test time)
      testTimeMap = this.sortMapOrderBy(testTimeMap, "ASC");
      String shortestTimeDeviceName = testTimeMap.keySet().toArray()[0].toString();
      // Put this caseId (longest test time) into testDevice (shortest test time)
      testDevices.getDevice(shortestTimeDeviceName).addTestCase(Long.parseLong(entry.getKey()));
      // Add this caseId's test time into testDevice's expected test time
      testDevices.getDevice(shortestTimeDeviceName).addExpectedTestSecs(entry.getValue());
      // Add caseId's test time on testDevice
      testTimeMap.put(
          shortestTimeDeviceName, testTimeMap.get(shortestTimeDeviceName) + entry.getValue());
      // Show information
      String info =
          String.format(
              "Put (%s,%d) -> Device %s (Expected Test Time : %d) , CaseList : %s",
              entry.getKey(),
              entry.getValue(),
              shortestTimeDeviceName,
              testDevices.getDevice(shortestTimeDeviceName).getExpectedTestSecs(),
              testDevices.getDevice(shortestTimeDeviceName).getTestCases());
    }
    Map<TestDevice, List<Long>> resultMap = new HashMap<TestDevice, List<Long>>();
    for (String id : testTimeMap.keySet()) {
      resultMap.put(testDevices.getDevice(id), testDevices.getDevice(id).getTestCases());
    }
    return resultMap;
  }

  public Map<String, Integer> sortMapOrderBy(Map<String, Integer> map, String orderBy) {

    Comparator<Map.Entry<String, Integer>> order = Map.Entry.comparingByValue();

    switch (orderBy) {
      case "ASC":
        order = Map.Entry.comparingByValue();
        break;
      case "DESC":
        order = Map.Entry.<String, Integer>comparingByValue().reversed();
        break;
    }

    Map<String, Integer> sortedMap =
        map.entrySet()
            .stream()
            .sorted(order)
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    return sortedMap;
  }

  @Override
  public Map<TestDevice, List<Long>> getDistribution(List<String> deviceNames, int maxExecution) {
    return getDistribution(new TestDevices(deviceNames, maxExecution));
  }
}
