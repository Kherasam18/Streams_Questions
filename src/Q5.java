import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum Currency {
    USD,
    EUR,
    INR
}

class Transaction {
    private int id;
    private Currency currency;
    private double amount;

    public Transaction(int id, Currency currency, double amount) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return STR."Transaction{id=\{id}, currency=\{currency}, amount=\{amount}}";
    }
}

public class Q5 {
    public static Map<Currency, List<Transaction>> groupByCurrency(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
    }

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1, Currency.USD, 100.0),
                new Transaction(2, Currency.EUR, 200.0),
                new Transaction(3, Currency.INR, 150.0),
                new Transaction(4, Currency.EUR, 250.0),
                new Transaction(5, Currency.USD, 180.0),
                new Transaction(6, Currency.INR, 220.0),
                new Transaction(7, Currency.EUR, 300.0),
                new Transaction(8, Currency.USD, 240.0),
                new Transaction(9, Currency.INR, 280.0),
                new Transaction(10, Currency.USD, 260.0)
        );

        Map<Currency, List<Transaction>> groupedTransactions = groupByCurrency(transactions);

        groupedTransactions.forEach((currency, transactionsForCurrency) -> {
            System.out.println("Transactions for " + currency + ":");
            transactionsForCurrency.forEach(System.out::println);
        });
    }
}
