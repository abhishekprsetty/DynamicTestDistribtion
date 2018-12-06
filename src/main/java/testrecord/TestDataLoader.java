package testrecord;

import java.util.List;

public interface TestDataLoader {

  List<TestData> getAllData();

  void loadData(String path);

  void addData(TestData testRecord);

  void filterData(String platform, String testResult);
}
