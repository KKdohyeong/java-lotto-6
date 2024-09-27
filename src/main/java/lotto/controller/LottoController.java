package lotto.controller;

import lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }



    int getMoneyForLotto(){
        return 0;
    }

}
