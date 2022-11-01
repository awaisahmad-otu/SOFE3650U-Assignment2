import java.util.HashMap;

public class Inventory {

  public String RetriveCost(String store) {
    HashMap<String, String> type = new HashMap<String, String>();

    type.put("Venom #11", "5.99");
    type.put("Spider-man #12", "10.99");
    type.put("GGC 9.8 Spider-man: Miles Morales #1", "599.99");
    for (String i : type.keySet()) {
      if (store == i) {
        return type.get(store);
      }
    }
    return "Invalid!";
  }
}
