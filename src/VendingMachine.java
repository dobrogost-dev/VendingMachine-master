import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements Serializable {
    public String serial_number;

    public Location getLocation() {
        return location;
    }

    private Location location;

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;
    private List<VendingMachine_Maintenace> VMM;
    public VendingMachine(String serial_number) {
        this.serial_number = serial_number;
        products = new ArrayList<>();
        VMM = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        if (product.getVendingMachine() != null) {
            if (!product.getVendingMachine().equals(this)) {
                product.setVendingMachine(this);
            }
        }
    }
    public void removeProduct(Product product) {
        products.remove(product);
        if (product.getVendingMachine() != null) {
            product.setVendingMachine(null);
        }
    }
    public void setLocation(Location location) {
        this.location = location;
        if (location != null) {
            if (!location.getVendingMachines().containsKey(serial_number)) {
                location.addVendingMachine(this);
            }
        }
    }
    public void removeLocation(Location location) {
        this.location = null;
        if (location.getVendingMachines().containsKey(serial_number)) {
            location.getVendingMachines().remove(this);
        }
    }
    public void showProducts() {
        System.out.println("Showing products for: " + serial_number);
        if (products.size() == 0) {
            System.out.println("None");
        }
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i));
        }
    }
    public void showProductsSpecified() {
        System.out.println("Showing specified information of products for: " + serial_number);
        for (Product product : products) {
            product.showFullInfo();
        }
    }
    public void addVMM(VendingMachine_Maintenace VMM){
        this.VMM.add(VMM);
    }
    public List<VendingMachine_Maintenace> getVMM() {
        return VMM;
    }
    public void showTechnicians() {
        System.out.println("Technicians of: " + serial_number);
        for (VendingMachine_Maintenace vmm : VMM) {
            System.out.println(vmm.getTechnician());
        }
    }
    @Override
    public String toString() {
        return serial_number;
    }
}
