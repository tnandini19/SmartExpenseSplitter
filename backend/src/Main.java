import models.User;
import models.Expense;
import services.ExpenseManager;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        User nandini = new User("Nandini");
        User sakshi = new User("Sakshi");
        User riya = new User("Riya");

        manager.addUser(nandini);
        manager.addUser(sakshi);
        manager.addUser(riya);

        manager.addExpense(nandini, 900, new User[]{sakshi, riya});

        manager.showBalances();
    }
}

