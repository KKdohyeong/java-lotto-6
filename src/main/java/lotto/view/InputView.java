package lotto.view;

/*
왜 문자열을 private static final을 할까?
private으로 안드러나거나 이곳에서만 보도록 하고
static으로 전역으로 넘겨서 어디든 접근 가능하게 하고
 */

import lotto.model.LottoMoney;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoNumber;
import lotto.util.LottoNumberType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String errorMessageGetMoney = "[ERROR] : money is error";
    public LottoMoney getBuyMoney(){
        LottoMoney lottoMoney =null;
        while(lottoMoney == null){
            try{
                lottoMoney = new LottoMoney(Console.readLine());
            }
            catch(IllegalArgumentException e){
                System.out.println(errorMessageGetMoney);
            }
        }
        return lottoMoney;
    }


    public List<LottoNumber> getLottoNumber(){
        String input = Console.readLine();
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(number -> new LottoNumber(number, LottoNumberType.NUMBER))
                .toList();
        return lottoNumbers;
    }
    public LottoNumber getBonusNumber(){
        int number = Integer.parseInt(Console.readLine());
        return new LottoNumber(number, LottoNumberType.BONUSNUMBER);
    }
}
