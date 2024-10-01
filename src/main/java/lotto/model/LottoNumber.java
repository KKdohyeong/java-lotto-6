package lotto.model;

import lotto.util.LottoNumberType;

public class LottoNumber {
    private LottoNumberType type;
    private Integer number;
    public LottoNumber(Integer number, LottoNumberType type) {
        this.number = number;
        this.type = type;
    }
    public Integer getNumber(){
        return number;
    }
    public LottoNumberType getType(){
        return type;
    }
}
