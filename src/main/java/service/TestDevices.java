package service;

import java.util.HashMap;
import java.util.Map;

public class TestDevices {

  private Map<String, TestDevice> testDeviceMap;

  public TestDevices(int deviceNumber, int maxExecutedSecs) {
    testDeviceMap = new HashMap<>();
    for (int index = 0; index < deviceNumber; index++) {
      String deviceName = String.format("%d", index + 1);
      this.addDevice(deviceName, new TestDevice(deviceName, maxExecutedSecs));
    }
  }

  public Map<String, TestDevice> getAllDevices() {
    return testDeviceMap;
  }

  public void addDevice(String deviceName, TestDevice testDevice) {
    testDeviceMap.put(deviceName, testDevice);
  }

  public TestDevice getDevice(String deviceName) {
    return testDeviceMap.get(deviceName);
  }
}
