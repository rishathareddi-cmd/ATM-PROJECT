// Initial account balance
let balance = 10000;

// Demo PIN
const correctPIN = "1234";


// LOGIN
function login() {

    let pin = document.getElementById("pinInput").value;

    if (pin === correctPIN) {

        document.getElementById("loginScreen").classList.add("hidden");

        document.getElementById("atmScreen").classList.remove("hidden");

        document.getElementById("loginMessage").innerText = "";

    } else {

        document.getElementById("loginMessage").innerText =
            "❌ Incorrect PIN. Please try again.";

    }
}


// CHECK BALANCE
function checkBalance() {

    document.getElementById("message").innerText =
        "💰 Your current balance is ₹" + balance;
}


// DEPOSIT
function deposit() {

    let amount = prompt("Enter amount to deposit:");

    amount = Number(amount);

    if (amount > 0) {

        balance = balance + amount;

        document.getElementById("message").innerText =
            "✅ ₹" + amount + " deposited successfully.\n" +
            "💰 Current balance: ₹" + balance;

    } else {

        document.getElementById("message").innerText =
            "❌ Please enter a valid amount.";
    }
}


// WITHDRAW
function withdraw() {

    let amount = prompt("Enter amount to withdraw:");

    amount = Number(amount);

    if (amount <= 0) {

        document.getElementById("message").innerText =
            "❌ Please enter a valid amount.";

    } else if (amount > balance) {

        document.getElementById("message").innerText =
            "❌ Insufficient balance.";

    } else {

        balance = balance - amount;

        document.getElementById("message").innerText =
            "✅ ₹" + amount + " withdrawn successfully.\n" +
            "💰 Remaining balance: ₹" + balance;
    }
}


// LOGOUT
function logout() {

    document.getElementById("atmScreen").classList.add("hidden");

    document.getElementById("loginScreen").classList.remove("hidden");

    document.getElementById("pinInput").value = "";

    document.getElementById("message").innerText = "";

    document.getElementById("loginMessage").innerText =
        "You have been logged out.";
}
