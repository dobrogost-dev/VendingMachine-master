import java.util.HashMap;
import java.util.Map;

public class Location {
    private int id;
    private String address;

    public Map<String, VendingMachine> getVendingMachines() {
        return vendingMachines;
    }

    /*
        Asocjacja kwalifikowana
         */
    //Kwalifikatorem jest String serial_number
    private final Map<String, VendingMachine> vendingMachines;

    public Location(int id, String address) {
        this.id = id;
        this.address = address;
        vendingMachines = new HashMap<>();
    }

    public void addVendingMachine(VendingMachine vendingMachine) {
        if (!vendingMachines.containsKey(vendingMachine.serial_number)) {
            vendingMachines.put(vendingMachine.serial_number, vendingMachine);
        }
        if (vendingMachine.getLocation() != null) {
            if (vendingMachine.getLocation().equals(this)) {
                vendingMachine.setLocation(this);
            }
        }
    }
    public void removeVendingMachine(VendingMachine vendingMachine) {
        vendingMachines.remove(vendingMachine.serial_number);
        vendingMachine.setLocation(null);
    }
    public VendingMachine getVendingMachine(String name) throws Exception {
        if (!vendingMachines.containsKey(name)) {
            throw new Exception("Vending machine with this name does not exist");
        }
        return vendingMachines.get(name);
    }
}
