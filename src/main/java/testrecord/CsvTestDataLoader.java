package testrecord;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvTestDataLoader implements TestDataLoader {

  private List<TestData> testRecords;

  public CsvTestDataLoader() {
    testRecords = new ArrayList<TestData>();
  }

  @Override
  public List<TestData> getAllData() {
    return testRecords;
  }

  @Override
  public void addData(TestData record) {
    testRecords.add(0, record);
  }

  @Override
  public void filterData(String platform, String testResult) {
    throw new NotImplementedException();
  }

  @Override
  public void loadData(String filepath) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("src/main/resources/testData.csv"));
      String line = "";
      while ((line = br.readLine()) != null) {
        String[] content = line.split(",");
        TestData newRecord = new TestData(content[0], content[1]);
        this.addData(newRecord);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
