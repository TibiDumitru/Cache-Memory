abstract class Subscriptie {
  private String name;
  private int noAppearances;

  public Subscriptie(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getNoAppearances() {
    return noAppearances;
  }

  public void setNoAppearances(int noAppearances) {
    this.noAppearances = noAppearances;
  }

  public abstract boolean isBasic();

  public abstract boolean isPremium();

}
