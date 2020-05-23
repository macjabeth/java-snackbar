import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Snack {
    private static final AtomicInteger maxId = new AtomicInteger(0);
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
    private final int id;
    private String name;
    private int quantity;
    private double cost;
    private int vendingMachineId;

    public Snack() {
        id = maxId.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public Snack setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Snack setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Snack setVendingMachineId(int vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
        return this;
    }

    public int getVendingMachineId() {
        return vendingMachineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Snack addQuantity(int quantity) {
        this.quantity += quantity;
        System.out.println(String.format("%s stock increased by %d.", name, quantity));
        return this;
    }

    public boolean buy(int quantity) {
        boolean inStock = this.quantity >= quantity;
        if (inStock) this.quantity -= quantity;
        return inStock;
    }

    public double getTotalCost(int quantity) {
        return cost * quantity;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Vending Machine: " + VendingMachine.instances.get(vendingMachineId).getName());
        System.out.println("Quantity on hand: " + quantity);
        System.out.println("Total quantity cost on hand: " + formatter.format(quantity * cost));
    }

    @Override
    public String toString() {
        return String.format("Quantity of snack %d (%s) is %d.", id, name, quantity);
    }
}
