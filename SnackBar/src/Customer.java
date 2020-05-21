import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger maxId = new AtomicInteger(0);
    private final int id;
    private String name;
    private double cash;

    public Customer() {
        id = maxId.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer addCash(double amount) {
        cash += amount;
        System.out.println(String.format("%s found $%.2f lying around.", name, amount));
        return this;
    }

    public double getCash() {
        return cash;
    }

    public Customer buySnacks(Snack snack, int quantity) {
        double totalCost = snack.getTotalCost(quantity);
        if (totalCost <= cash && snack.buy(quantity)) cash -= totalCost;
        System.out.println(String.format("%s bought %d %s for $%.2f.", name, quantity, snack.getName(), totalCost));
        return this;
    }

    @Override
    public String toString() {
        return String.format("Customer %d (%s) has $%.2f cash on hand.", id, name, cash);
    }
}
