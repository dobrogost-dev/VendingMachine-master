import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product implements Serializable {
    private String name;
    private double price;
    /*
    Kompozycja
     */
    private List<Label> labels;
    /*
        Asocjacja zwykła
         */
    private VendingMachine vendingMachine;
    public Product(String name, double price) {
        this.price = price;
        this.name = name;
        this.vendingMachine = null;
        labels = new ArrayList<>();
    }
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        if (!vendingMachine.getProducts().contains(this)) {
            vendingMachine.addProduct(this);
        }
        if (vendingMachine == null) {
            vendingMachine.removeProduct(this);
        }
    }
    public void addLabel(String[] allergens, double weight, double kcal, double alcoholPercent) {
        Label label = new Label(allergens, weight, kcal, alcoholPercent);
        labels.add(label);
    }
    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void showFullInfo() {
        String info = "Name: " + name + " Price: " + price + "zł";
        for (Label label : labels) {
            if (label == null) {
            } else {
                info += label.getInfo();
            }
            System.out.println(info);
        }
    }
    public class Label implements Serializable {
        private String[] allergens;
        private double weight;
        private double kcal;
        private Double alcoholPercent;
        private Label(String[] allergens, double weight, double kcal, double alcoholPercent) {
            this.allergens = allergens;
            this.weight = weight;
            this.kcal = kcal;
            this.alcoholPercent = alcoholPercent;
        }
        private String getInfo() {
            return " Allergens: " + Arrays.toString(allergens) + " Weight: " + weight +
                    " Kcal: " + kcal + " Alcohol: " + alcoholPercent;
        }
    }
}
