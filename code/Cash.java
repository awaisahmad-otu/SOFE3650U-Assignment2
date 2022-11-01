public class Cash {

  public String PullComic(String Comic) {
    Inventory comicInventory = new Inventory();
    Display viewDisplay = new Display();
    return viewDisplay.OutputCost(comicInventory.RetriveCost(Comic));
  }
}
