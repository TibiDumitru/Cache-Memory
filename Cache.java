import java.util.ArrayList;

interface Cache {
  void add(String name, int basicRequest, int premiumRequest);
  void remove();
  ArrayList<Premium> getCacheMemory();
  void setIndex(int index);
  int getIndex();
  void setMaxNoObjects(int maxNoObjects);
  //check if the element with the name "name" is in the cache memory
  boolean isInCacheMemory(String name);
  //return the element with the name "name" which is in the cache memory
  Premium getElementCache(String name);
}
