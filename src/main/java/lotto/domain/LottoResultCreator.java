package lotto.domain;

import lotto.Lotto;
import lotto.model.LottoNumber;
import lotto.util.LottoNumberType;
import lotto.util.LottoPlace;

import java.util.List;

public class LottoResultCreator {

    public int[] createLottoResult(List<List<Integer>> lottoList, Lotto lotto){
        int[] lottoResult = new int[5];
        Integer bonusNumber = findBonusNumber(lotto);
        List<Integer> winningNumbers = lotto.getNumbers().stream()
                .filter(number -> number.getType() == LottoNumberType.NUMBER)
                .map(LottoNumber::getNumber)
                .toList();

        for (List<Integer> lottos : lottoList){
            int matchCount = calculateMatch(winningNumbers, lottos);
            boolean bonusMatch = checkBonusMatch(bonusNumber, lottos);
            LottoPlace rank = getRank(matchCount, bonusMatch);
            if (rank != null) {
                lottoResult[rank.ordinal()]++; // enum의 순서를 사용해 배열 인덱스를 맞춤
            }
        }

        return lottoResult;
    }

    private int calculateMatch(List<Integer> winningNumbers, List<Integer> lottos){
        int matchCount = 0;
        for (Integer number : lottos) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonusMatch(Integer bonusNumber, List<Integer> lottos) {
        if (bonusNumber == null) {
            return false;
        }
        return lottos.contains(bonusNumber);
    }

    private Integer findBonusNumber(Lotto lotto){
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.getType() == LottoNumberType.BONUSNUMBER) {
                return lottoNumber.getNumber();
            }
        }
        return null;
    }

    private LottoPlace getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return LottoPlace.FIRSTPLACE; // 1등
        }
        if (matchCount == 5 && bonusMatch) {
            return LottoPlace.SECONDPLACE; // 2등
        }
        if (matchCount == 5) {
            return LottoPlace.THIRDPLACE; // 3등
        }
        if (matchCount == 4) {
            return LottoPlace.FOURTHPLACE; // 4등
        }
        if (matchCount == 3) {
            return LottoPlace.FIFTHPLACE; // 5등
        }
        return null; // 꽝
    }
}