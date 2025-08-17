package services;

import models.Expense;
import models.User;
import java.util.*;

public class ExpenseManager {
    private List<User> users = new ArrayList<>();
    private List<Expense> expenses = new ArrayList<>();
    private Map<String, Map<String, Double>> balanceSheet = new HashMap<>();

    public void addUser(User user) {
        users.add(user);
        balanceSheet.put(user.getName(), new HashMap<>());
    }

    public void addExpense(User paidBy, double amount, User[] sharedWith) {
        Expense expense = new Expense(paidBy, amount, sharedWith);
        expenses.add(expense);

        double splitAmount = amount / sharedWith.length;

        for (User user : sharedWith) {
            if (!user.getName().equals(paidBy.getName())) {
                balanceSheet.get(user.getName())
                    .put(paidBy.getName(),
                         balanceSheet.get(user.getName())
                             .getOrDefault(paidBy.getName(), 0.0) + splitAmount);
            }
        }
    }

    public void showBalances() {
        System.out.println("Balance Sheet:");
        for (String user : balanceSheet.keySet()) {
            for (String oweTo : balanceSheet.get(user).keySet()) {
                double amount = balanceSheet.get(user).get(oweTo);
                if (amount > 0) {
                    System.out.println(user + " owes " + oweTo + ": Rs." + amount);

                }
            }
        }
    }
}

