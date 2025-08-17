# Smart Expense Splitter (SQL)

This SQL project supports the SmartExpenseSplitter application by storing participant details and calculating expense settlements.

## Features
- Create a database with participant table
- Insert expense records
- Calculate total expense
- Calculate per-head share
- Display settlement balances

## Example Queries
- `SELECT SUM(amount_spent) FROM Participants;`
- `SELECT AVG(amount_spent) FROM Participants;`
- Settlement logic using subqueries
