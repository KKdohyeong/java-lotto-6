package lotto.view;


import java.util.List;

public class OutputView {
    private static final String getBuyMoney = "구입금액을 입력해 주세요.";


    public void printGetBuyMoney() {
        System.out.println(getBuyMoney);
    }

    public void printBuyLotto(List<List<Integer>> lottoList) {
        for(List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
