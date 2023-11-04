package encapsulation;

public class Pocket {
    private double money;

    public Pocket(double money) {
        this.money = money;
    }

    public double getMoney() {
        if (money <= 10) {
            return 0;
        }
        return money;
    }

    public void setMoney(double money) {
        if (money < 0 || money > 10000) {
            System.out.println("I do not have enough space in my pocket for such a BiG money");
        } else {
            this.money = money;
        }
    }


}
