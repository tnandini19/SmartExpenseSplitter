const expenseForm = document.getElementById("expenseForm");
const expenseList = document.getElementById("expenseList");
const balancesDiv = document.getElementById("balances");

let expenses = [];
let balances = {};

expenseForm.addEventListener("submit", (e) => {
  e.preventDefault();

  const name = document.getElementById("name").value;
  const amount = parseFloat(document.getElementById("amount").value);

  if (!name || isNaN(amount)) return;

  expenses.push({ name, amount });

  if (!balances[name]) balances[name] = 0;
  balances[name] += amount;

  renderExpenses();
  renderBalances();

  expenseForm.reset();
});

function renderExpenses() {
  expenseList.innerHTML = "";
  expenses.forEach((exp, i) => {
    const li = document.createElement("li");
    li.textContent = `${exp.name} paid ₹${exp.amount}`;
    expenseList.appendChild(li);
  });
}

function renderBalances() {
  balancesDiv.innerHTML = "";
  let total = Object.values(balances).reduce((a, b) => a + b, 0);
  let perPerson = total / Object.keys(balances).length;

  for (let person in balances) {
    let balance = balances[person] - perPerson;
    let p = document.createElement("p");
    if (balance > 0) {
      p.textContent = `${person} should receive ₹${balance.toFixed(2)}`;
    } else if (balance < 0) {
      p.textContent = `${person} should pay ₹${Math.abs(balance).toFixed(2)}`;
    } else {
      p.textContent = `${person} is settled up 🎉`;
    }
    balancesDiv.appendChild(p);
  }
}
