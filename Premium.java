class Premium extends Basic {
  private int premiumRequest;

  public Premium(String name, int basicRequest, int premiumRequest) {
    super(name, basicRequest);
    this.premiumRequest = premiumRequest;
  }

  public int getPremiumRequest() {
    return premiumRequest;
  }

  public void setPremiumRequest(int premiumRequest) {
    this.premiumRequest = premiumRequest;
  }

  //check if the subscription is premium
  public boolean isPremium() {
    if (premiumRequest > 0)
      return true;
    return false;
  }

  //decrement premiumRequest
  public void decPremium() {
    premiumRequest-- ;
  }
}
