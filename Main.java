import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      //read from file
      Scanner scanner = new Scanner(new File(args[0]));
      //write in output file
      PrintStream fileStream = new PrintStream(args[1]);
      System.setOut(fileStream);
      //read the first line
      String cacheType = scanner.nextLine();
      //max number of elements in cache
      int maxNoObjects = scanner.nextInt();
      //number of operations
      int N = scanner.nextInt();
      Operations op = new Operations(N);
      Cache cache;
      //define the type of cache
      if (cacheType.equals("FIFO"))
        cache = new FIFOCache();
      else if (cacheType.equals("LRU"))
        cache = new LRUCache();
      else
        cache = new LFUCache();
      cache.setMaxNoObjects(maxNoObjects);
      String space = scanner.nextLine();
      int i = 0;
      //read line by line
      while (i < N) {
        String line = scanner.nextLine();
        //parse the read lines
        String[] tokens = line.split(" ");
        if (tokens[0].equals("ADD")) {
          String ADDName = tokens[1];
          int premiumRequest = 0;
          int basicRequest = Integer.parseInt(tokens[2]);
          //check if the object has a premium subscription
          if (tokens.length == 4)
            premiumRequest = Integer.parseInt(tokens[3]);
          //add all elements in the main memory
          boolean isAlreadyInMain = false;
          int pos = 0;
          //check if the element is already in the main memory
          for (Premium e : op.getMainMemory()) {
            if (e == null)
              break;
            if (e.getName().equals(ADDName)) {
              isAlreadyInMain = true;
              break;
              }
            pos++;
          }
          if (isAlreadyInMain) {
            //overwrite the request values
            op.getMainMemory()[pos].setBasicRequest(basicRequest);
            op.getMainMemory()[pos].setPremiumRequest(premiumRequest);
            //check if the element is also in the cache memory
            boolean isAlreadyInCache = false;
            Premium e = cache.getElementCache(ADDName);
            if (e != null)
              isAlreadyInCache = true;
            if (isAlreadyInCache) {
              cache.getCacheMemory().remove(e);
              cache.setIndex(cache.getIndex() - 1);
            }
          } else {
            //add the new elements in the main memory
            op.getMainMemory()[op.getIndex()] =
                    new Premium(ADDName, basicRequest, premiumRequest);
            op.setIndex(op.getIndex() + 1);
          }
        } else if (tokens[0].equals("GET")) {
          String GETName = tokens[1];
          if (cache.isInCacheMemory(GETName)) {
            System.out.print("0 ");
            Premium ec = cache.getElementCache(GETName);
            if (cacheType.equals("LFU"))
              //increment the number of appearances in the cache memory
              ec.setNoAppearances(ec.getNoAppearances() + 1);
            Premium em = op.getElementMain(GETName);
            System.out.print(ec.print());
            op.decRequest(ec);
            op.decRequest(em);
            if (cacheType.equals("LRU")) {
              //move element ec at the end of the structure
              cache.getCacheMemory().remove(ec);
              cache.getCacheMemory().add(ec);
            }
          } else if (op.isInMainMemory(GETName)) {
            System.out.print("1 ");
            Premium em = op.getElementMain(GETName);
            System.out.print(em.print());
            op.decRequest(em);
            //add element em to the cache memory
            cache.add(em.getName(), em.getBasicRequest(), em.getPremiumRequest());
          } else {
            System.out.println("2");
          }
        }
        i++;
      }
      scanner.close();
      fileStream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
