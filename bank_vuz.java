class Client {
    private String name;
    private String surname;
    private double balance;
    private String password;

    public Client(String name, String surname, double balance, String password) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.password = password;
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean canTransfer(double amount) {
        return balance >= amount;
    }
}

class Bank {
    public boolean sendMoney(Client fromClient, String pass, Client toClient, double amount) {
        if (!fromClient.checkPassword(pass)) {
            System.out.println("Неверный пароль.");
            return false;
        }
        if (!fromClient.canTransfer(amount)) {
            System.out.println("Недостаточно средств на счету.");
            return false;
        }

        fromClient.setBalance(fromClient.getBalance() - amount);
        toClient.setBalance(toClient.getBalance() + amount);
        System.out.println("Перевод выполнен успешно.");
        return true;
    }
}

public class bank_vuz {
    public static void main(String[] args) {

        Client client1 = new Client("Макар", "Зыков", 5000.0, "1234");
        Client client2 = new Client("Артем", "Николаев", 2000.0, "abcd");
        Client client3 = new Client("Павел", "Алексеевич", 3000.0, "qwert");

        Bank bank = new Bank();

        System.out.println("Баланс до перевода:");
        System.out.println("Клиент 1: " + client1.getBalance());
        System.out.println("Клиент 2: " + client2.getBalance());

        boolean result = bank.sendMoney(client1, "1234", client2, 1500.0);
        System.out.println("Баланс после перевода:");
        System.out.println("Клиент 1: " + client1.getBalance());
        System.out.println("Клиент 2: " + client2.getBalance());

        result = bank.sendMoney(client2, "wrongPass", client3, 1000.0);

        result = bank.sendMoney(client1, "1234", client3, 6000.0);
    }
}

