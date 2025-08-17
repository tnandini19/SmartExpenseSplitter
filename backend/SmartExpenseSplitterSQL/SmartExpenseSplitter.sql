-- Database for Smart Expense Splitter
CREATE DATABASE SmartExpenseSplitterDB;
USE SmartExpenseSplitterDB;

-- Table for storing participants
CREATE TABLE Participants (
    participant_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    amount_spent DECIMAL(10,2) NOT NULL
);

-- Insert sample data
INSERT INTO Participants (name, amount_spent) VALUES
('Aditi', 1200.00),
('Nandini', 800.00),
('Rahul', 500.00);

-- Query to calculate total expense
SELECT SUM(amount_spent) AS TotalExpense FROM Participants;

-- Query to calculate average share
SELECT AVG(amount_spent) AS PerHeadShare FROM Participants;

-- Query to show settlement details
SELECT name,
       amount_spent - (SELECT AVG(amount_spent) FROM Participants) AS Balance
FROM Participants;
