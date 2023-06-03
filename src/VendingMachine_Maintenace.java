import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VendingMachine_Maintenace {
    private VendingMachine vendingMachine;
    public Maintenace_Technician technician;
    public VendingMachine_Maintenace(VendingMachine vendingMachine, Maintenace_Technician technician) {
        this.vendingMachine = vendingMachine;
        this.technician = technician;

        vendingMachine.addVMM(this);
        technician.addVMM(this);
    }
    public void delete() {
        vendingMachine.getVMM().remove(this);
        technician.getVMM().remove(this);
    }
    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public Maintenace_Technician getTechnician() {
        return technician;
    }
}
