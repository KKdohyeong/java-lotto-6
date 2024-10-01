package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoCreate;
import lotto.domain.LottoResultCreator;
import lotto.model.LottoMoney;
import lotto.model.LottoNumber;
import lotto.model.Person;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    Lotto lotto;
    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printGetBuyMoney();
        Person person = new Person(inputView.getBuyMoney());
        buyLotto(person.getMoney().getMoney(), person);
        getLottoNumber();
        getBonusNumber(lotto);
        printLottoResult(person.getLottoList(), lotto, person);

    }

    public void printLottoResult(List<List<Integer>> lottoList, Lotto lotto, Person person){
        LottoResultCreator lottoResultCreator = new LottoResultCreator();
        int[] lottoResult = lottoResultCreator.createLottoResult(lottoList, lotto);
        outputView.printLottoResult(lottoResult,person.getMoney().getMoney());
    }

    public void getLottoNumber(){
        outputView.printGetLottoNumber();
        this.lotto = new Lotto(inputView.getLottoNumber());
    }

    public void buyLotto(Integer money, Person person){
        LottoCreate lotto = new LottoCreate();
        int count = money/1000;
        for(int i = 0; i < count; i++){
            person.lottoSave(lotto.makeLottoMoney());
        }
        outputView.printBuyLotto(person.getLottoList());
    }

    public void getBonusNumber(Lotto lotto){
        boolean error = false;
        while(!error){
            outputView.printGetBonusNumber();
            try{
                LottoNumber bonus = inputView.getBonusNumber();
                lotto.saveBonusNumber(bonus);
                error = true;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
