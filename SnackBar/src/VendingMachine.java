import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {
    private static final AtomicInteger maxId = new AtomicInteger(0);
    private final int id;
    private String name;

    public VendingMachine() {
        id = maxId.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public VendingMachine setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
