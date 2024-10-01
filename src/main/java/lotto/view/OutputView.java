package lotto.view;


import java.util.List;

public class OutputView {
    private static final String getBuyMoney = "구입금액을 입력해 주세요.";
    private static final String getBonusNumber = "보너스 번호를 입력해 주세요.";
    private static final String getLottoNumber = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_PURCHASED_LOTTO = "%d개를 구매했습니다.";
    public void printGetBuyMoney() {
        System.out.println(getBuyMoney);
    }

    public void printBuyLotto(List<List<Integer>> lottoList) {
        System.out.println();
        System.out.printf((MESSAGE_PURCHASED_LOTTO) + "%n", lottoList.size());
        for(List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printErrorMessage(){

    }

    public void printGetBonusNumber() {
        System.out.println();
        System.out.println(getBonusNumber);
    }

    public void printGetLottoNumber(){
        System.out.println(getLottoNumber);
    }

    public void printLottoResult(int[] lottoResults, Integer buyMoney){
        // 각 등수별 당첨 결과 출력
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoResults[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResults[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResults[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResults[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResults[0] + "개");
        System.out.println("총 수익률은 " + getLottoReturn(lottoResults,buyMoney) + "입니다.");

    }



    public double getLottoReturn(int[] lottoResults, Integer buyMoney){
        int earnMoney = lottoResults[0] * 2000000000 + lottoResults[1]* 30000000 + lottoResults[2]*1500000 + lottoResults[3]*50000 + lottoResults[4]*5000;
        return Math.round((double)earnMoney/buyMoney);
    }

}
