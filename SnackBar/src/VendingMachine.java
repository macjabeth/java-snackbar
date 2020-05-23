import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {
    public static final Map<Integer, VendingMachine> instances = new HashMap<>();
    private static final AtomicInteger maxId = new AtomicInteger(0);
    private final int id;
    private String name;

    public VendingMachine() {
        id = maxId.incrementAndGet();
        instances.put(id, this);
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
