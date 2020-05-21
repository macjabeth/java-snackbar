import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger maxId = new AtomicInteger(0);
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
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
        System.out.println(String.format("%s found %s lying around.", name, formatter.format(amount)));
        return this;
    }

    public double getCash() {
        return cash;
    }

    public Customer buySnacks(Snack snack, int quantity) {
        double totalCost = snack.getTotalCost(quantity);
        if (totalCost <= cash && snack.buy(quantity)) cash -= totalCost;
        System.out.println(String.format("%s bought %d %s for %s.", name, quantity, snack.getName(), formatter.format(totalCost)));
        return this;
    }

    @Override
    public String toString() {
        return String.format("Customer %d (%s) has %s cash on hand.", id, name, formatter.format(cash));
    }
}
