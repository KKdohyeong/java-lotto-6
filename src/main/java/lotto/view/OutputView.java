package lotto.view;

import java.io.Console;

public class OutputView {
    private static final String getBuyMoney = "구입금액을 입력해 주세요.";
    Console console =  System.console();

    void printGetBuyMoney() {
        console.printf(getBuyMoney);
    }
}
