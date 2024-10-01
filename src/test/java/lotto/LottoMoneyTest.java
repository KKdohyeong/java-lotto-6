package lotto;

import lotto.model.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1. 1000원을 받았을 때 1000원이 저장되는지
2. 음수 돈일 때 IllegalArgumentException
3. 0일 대 IllegalArgumentException
4. 1000원 단위로 안떨어질 때 IllegalArgumentException
 */

public class LottoMoneyTest {

    @DisplayName("1,000원을 저장했을 때 저장되는지 확인")
    @Test
    void moneySave(){
        // given: 1,000원을 입력값으로 준비
        String validMoney = "1000";

        // when: LottoMoney 객체를 생성
        LottoMoney lottoMoney = new LottoMoney(validMoney);

        // then: money가 정상적으로 저장되었는지 확인
        assertEquals(1000, lottoMoney.getMoney());
    }

    @DisplayName("돈으로 음수가 들어온 경우 예외가 발생한다.")
    @Test
    void negativeMoneyTest(){
        assertThatThrownBy(() -> new LottoMoney("-1"));
    }


    @DisplayName("돈으로 0원이 들어온 경우 예외가 발생한다.")
    @Test
    void zeroMoneyTest(){
        assertThatThrownBy(() -> new LottoMoney("0"));
    }

    @DisplayName("돈이 1000원 단위로 안나뉘어지는 경우 예외가 발생한다.")
    @Test
    void notDividedByThousand(){
        assertThatThrownBy(() -> new LottoMoney("1500"));
    }

    @DisplayName("입력을 잘못했을 경우 다시 입력을 받는다")
    @Test
    void getMoneyAgainWhenException(){
        //given
        String errorMoney = "-100";

        //then

    }

     
}
