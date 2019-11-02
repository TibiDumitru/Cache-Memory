import java.util.ArrayList;

class LFUCache implements Cache {
  //structure which represents the cache memory
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

  public void add(String name, int basicRequest, int premiumRequest) {
    if (index == maxNoObjects) {
      remove();
      index--;
    }
    index++;
    Premium e = new Premium(name, basicRequest, premiumRequest);
    e.setNoAppearances(1);
    cacheMemory.add(e);
  }

  //remove the last frequently used element
  public void remove() {
    int i = 0;
    int pos = 0;
    //initialize min with the first element's number of appearances
    int min = cacheMemory.get(0).getNoAppearances();
    for (Premium e : cacheMemory) {
      if (e.getNoAppearances() < min) {
        min = e.getNoAppearances();
        pos = i;
      }
      i++;
    }
    //remove the element with min number of appearances (which has index pos)
    cacheMemory.remove(pos);
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
