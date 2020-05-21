public class SnackBar {
    public static void main(String[] args) {
        Customer jane = new Customer().setName("Jane").addCash(45.25);
        Customer bob = new Customer().setName("Bob").addCash(33.14);

        VendingMachine food = new VendingMachine().setName("Food");
        VendingMachine drink = new VendingMachine().setName("Drink");
        VendingMachine office = new VendingMachine().setName("Office");

        Snack chips = new Snack().setName("Chips").addQuantity(36).setCost(1.75).setVendingMachineId(food.getId());
        Snack chocolateBar = new Snack().setName("Chocolate Bar").addQuantity(36).setCost(1.00).setVendingMachineId(food.getId());
        Snack pretzel = new Snack().setName("Pretzel").addQuantity(30).setCost(2.00).setVendingMachineId(food.getId());

        Snack soda = new Snack().setName("Soda").addQuantity(24).setCost(2.50).setVendingMachineId(drink.getId());
        Snack water = new Snack().setName("Water Bottle").addQuantity(20).setCost(2.75).setVendingMachineId(drink.getId());

        jane.buySnacks(soda, 3);
        System.out.println(jane);
        System.out.println(soda);

        jane.buySnacks(pretzel, 1);
        System.out.println(jane);
        System.out.println(pretzel);

        bob.buySnacks(soda, 2);
        System.out.println(bob);
        System.out.println(soda);

        jane.addCash(10);
        System.out.println(jane);

        jane.buySnacks(chocolateBar, 1);
        System.out.println(jane);
        System.out.println(chocolateBar);

        pretzel.addQuantity(12);
        System.out.println(pretzel);

        bob.buySnacks(pretzel, 3);
        System.out.println(bob);
        System.out.println(pretzel);

        chips.displayInfo();
        chocolateBar.displayInfo();
        pretzel.displayInfo();
        soda.displayInfo();
        water.displayInfo();
    }
}
