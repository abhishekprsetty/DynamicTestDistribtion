import java.util.Arrays;
import java.util.List;
import java.util.Map;

import service.SimpleTestDistributor;
import service.TestDevice;
import service.TestDevices;
import service.TestDistributor;
import testrecord.CsvTestDataLoader;
import testrecord.TestDataLoader;

public class Main {

  public static void main(String[] args) {

    TestDataLoader testDataLoader = new CsvTestDataLoader();
    testDataLoader.loadData("src/main/resources/testData.csv");

    TestDistributor testDistributeService = new SimpleTestDistributor(testDataLoader);

    // run with specific devices
    TestDevices testDevices = new TestDevices(10, 10000);
    Map<TestDevice, List<Long>> result = testDistributeService.getDistribution(testDevices);
    System.out.println(result);

    // run with names
    result =
        testDistributeService.getDistribution(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), 3000);
    System.out.println(result);

    result =
        testDistributeService.getDistribution(
            Arrays.asList(
                "iPhone 8",
                "iPhone 7",
                "iPhone 6",
                "iPhone 5",
                "iPhone X"),
            3000);
    System.out.println(result);
  }
}
