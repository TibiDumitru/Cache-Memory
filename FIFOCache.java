import java.util.ArrayList;

class FIFOCache implements Cache {
  private ArrayList<Premium> cacheMemory = new ArrayList<>();
  private int index;
  private int maxNoObjects;

  public ArrayList<Premium> getCacheMemory() {
    return cacheMemory;
  }

  public void setMaxNoObjects(int maxNoObjects) {
    this.maxNoObjects = maxNoObjects;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  //add to the end of the structure
  public void add(String name, int basicRequest, int premiumRequest) {
    if (index == maxNoObjects) {
      remove();
      index--;
    }
    index++;
    Premium e = new Premium(name, basicRequest, premiumRequest);
    cacheMemory.add(e);
  }

  //remove the head of the structure
  public void remove() {
    cacheMemory.remove(0);
  }

  public boolean isInCacheMemory(String name) {
    for (Premium e : cacheMemory) {
      if ((e.getName()).equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Premium getElementCache(String name) {
    for (Premium e : cacheMemory) {
      if ((e.getName()).equals(name)) {
        return e;
      }
    }
    return null;
  }
}
