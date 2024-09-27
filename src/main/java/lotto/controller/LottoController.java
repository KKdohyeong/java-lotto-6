package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoCreate;
import lotto.model.LottoMoney;
import lotto.model.Person;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printGetBuyMoney();
        Person person = new Person(inputView.getBuyMoney());
        buyLotto(person.getMoney().getMoney(), person);

    }

    int getMoneyForLotto(){
        return 0;
    }

    public void buyLotto(Integer money, Person person){
        LottoCreate lotto = new LottoCreate();
        int count = money/1000;
        for(int i = 0; i < count; i++){
            person.lottoSave(lotto.makeLottoMoney());
        }
        outputView.printBuyLotto(person.getLottoList());
    }
}
