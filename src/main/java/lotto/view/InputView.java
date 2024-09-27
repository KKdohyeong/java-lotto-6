package lotto.view;

/*
왜 문자열을 private static final을 할까?
private으로 안드러나거나 이곳에서만 보도록 하고
static으로 전역으로 넘겨서 어디든 접근 가능하게 하고
 */

import lotto.model.LottoMoney;

import java.io.Console;

public class InputView {
    private static final String errorMessageGetMoney = "[ERROR] : money is error";
    Console console = System.console();
    LottoMoney getBuyMoney(){
        LottoMoney lottoMoney =null;
        while(lottoMoney == null){
            try{
                lottoMoney = new LottoMoney(console.readLine());
            }
            catch(IllegalArgumentException e){
                console.printf(errorMessageGetMoney);
            }
        }
        return lottoMoney;
    }
}
