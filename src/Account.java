/**
 * 练习一：
 * 为Account类编写单元测试，要求使用Given-When-Then三段式的结构和命名法。
 * 提取公共部分到SetUp函数中。学习使用assertXXX系列断言。
 * 用IntelliJ来运行测试用例，并计算测试覆盖率。
 */

public class Account {

    private final boolean isDebit;
    private long balance;

    protected Account(boolean isDebit) {
        this.isDebit = isDebit;
    }

    public static Account openDebitAccount() {
        return new Account(true);
    }

    public static Account openAccount() {
        return new Account(false);
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        boolean insufficientFunds = getBalance() < amount;
        balance -= amount;
        if (isDebit && insufficientFunds) {
            throw new InsufficientFundsException();
        }
    }
}


class InsufficientFundsException extends RuntimeException {
}