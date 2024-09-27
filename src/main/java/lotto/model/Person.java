package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private LottoMoney money;
    private List<List<Integer>> lottoList = new ArrayList<>();

    public Person(LottoMoney money){
        this.money = money;
    }

    public void lottoSave(List<Integer> lotto){
        lottoList.add(lotto);
    }

    public LottoMoney getMoney(){
        return money;
    }

    public List<List<Integer>> getLottoList(){
        return lottoList;
    }

}
