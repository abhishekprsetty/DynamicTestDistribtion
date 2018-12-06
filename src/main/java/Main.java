import service.Method;
import service.Method1;
import service.TestDevices;
import service.TestDistributeService;
import testrecord.CsvTestDataLoader;
import testrecord.TestDataLoader;

public class Main {

  public static void main(String[] args) {

    TestDataLoader testDataLoader = new CsvTestDataLoader();
    testDataLoader.loadData("src/main/resources/testData.csv");

    TestDevices testDevices = new TestDevices(10, 10000);

    Method method = new Method1();

    TestDistributeService testDistributeService =
        new TestDistributeService(testDevices, testDataLoader, method);

    testDistributeService.execute();
  }
}
