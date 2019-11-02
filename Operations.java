class Operations {
  //the array that represents the main memory
  private Premium[] mainMemory;
  private int index;

  public Operations(int size) {
    mainMemory = new Premium[size];
    index = 0;
  }

  public Premium[] getMainMemory() {
    return mainMemory;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  //decrement the request, either basic or premium
  public void decRequest(Premium e) {
    if (e.isPremium())
      e.decPremium();
    else if (e.isBasic())
      e.decBasic();
  }

  //check if the element with the name "name" is in memory
  public boolean isInMainMemory(String name) {
    for (Premium e : mainMemory) {
      if (e != null) {
        if ((e.getName()).equals(name)) {
          return true;
        }
      }
    }
    return false;
  }

  //find and return the element with the name "name"
  public Premium getElementMain(String name) {
    for (Premium e : mainMemory) {
      if (e != null) {
        if ((e.getName()).equals(name)) {
          return e;
        }
      }
    }
    return null;
  }
}
