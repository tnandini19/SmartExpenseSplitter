package models;

public class Expense {
    private User paidBy;
    private double amount;
    private User[] sharedWith;

    public Expense(User paidBy, double amount, User[] sharedWith) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.sharedWith = sharedWith;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public User[] getSharedWith() {
        return sharedWith;
    }
}

