package testrecord;

public class TestData {

  private String key;
  private String id;
  private Integer duration;
  private String result;
  private String platform;

  public TestData(String id, String duration) {
    this.setId(id);
    this.setDuration(duration);
  }

  public TestData(String key, String id, String duration, String result, String platform) {
    this.setKey(key);
    this.setId(id);
    this.setDuration(duration);
    this.setResult(result);
    this.setPlatform(platform);
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = Integer.parseInt(duration);
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }
}
