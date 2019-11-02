class Free extends Subscriptie {
  public Free(String name) {
    super(name);
  }

  public boolean isBasic() {
    return false;
  }

  public boolean isPremium() {
    return false;
  }

  //print the type of subscription
  public String print() {
    if (!isBasic() && !isPremium())
      return "Free\n";
    else if (isBasic() && !isPremium())
      return "Basic\n";
    else
      return "Premium\n";
  }
}
