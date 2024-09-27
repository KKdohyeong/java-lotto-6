package lotto.model;

public class LottoMoney {
    public Integer money;

    public LottoMoney(String msg){
        try{
            money = Integer.parseInt(msg);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        validateIsNegativeOrZero();
        validateIsDividedByThousand();

    }
    public void validateIsNegativeOrZero(){
        if(money <=0){
            throw new IllegalArgumentException();
        }
    }

    public void validateIsDividedByThousand(){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public void setMoney(int money){
        this.money = money;
    }

    public Integer getMoney(){
        return this.money;
    }


}
