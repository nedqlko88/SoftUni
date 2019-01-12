package car.dealer.dtos.customers;

public class CustomerSalesDto {

    private String name;

    private int carsCount;

    private Double spentMoney;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarsCount() {
        return this.carsCount;
    }

    public void setCarsCount(int carsCount) {
        this.carsCount = carsCount;
    }

    public Double getSpentMoney() {
        return this.spentMoney;
    }

    public void setSpentMoney(Double spentMoney) {
        this.spentMoney = spentMoney;
    }
}
