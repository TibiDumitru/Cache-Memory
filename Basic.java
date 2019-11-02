class Basic extends Free {
  private int basicRequest;

  public Basic(String name, int basicRequest) {
    super(name);
    this.basicRequest = basicRequest;
  }

  public int getBasicRequest() {
    return basicRequest;
  }

  public void setBasicRequest(int basicRequest) {
    this.basicRequest = basicRequest;
  }

  //check if the subscription is basic
  public boolean isBasic() {
    if (basicRequest > 0)
      return true;
    return false;
  }

  //decrement basicRequest
  public void decBasic() {
    basicRequest--;
  }
}
