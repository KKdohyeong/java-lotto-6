package lotto;

import lotto.model.LottoNumber;
import lotto.util.LottoNumberType;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> numbers = new ArrayList<>();

    public Lotto(List<LottoNumber> numbers) {
        if (numbers != null) {
            validate(numbers);
            this.numbers.addAll(numbers);
        } else {
            throw new IllegalArgumentException("번호 리스트가 null입니다.");
        }
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        // 2. 숫자들이 1~45 사이인지 확인
        for (LottoNumber lottoNumber : numbers) {
            int number = lottoNumber.getNumber();
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("숫자는 1 이상 45 이하여야 합니다.");
            }
        }

        // 3. 중복 여부 확인
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (LottoNumber lottoNumber : numbers) {
            int number = lottoNumber.getNumber();
            uniqueNumbers.add(number);
        }
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자들은 중복될 수 없습니다.");
        }

        // 4. 오름차순 확인
        for (int i = 0; i < numbers.size() - 1; i++) {
            int current = numbers.get(i).getNumber();
            int next = numbers.get(i + 1).getNumber();
            if (current > next) {
                throw new IllegalArgumentException("번호는 오름차순으로 정렬되어야 합니다.");
            }
        }
    }

    public void saveBonusNumber(LottoNumber number) {
        bonusValidate(number);
        numbers.add(number);
    }

    private void bonusValidate(LottoNumber bonusNumber) {
        int number = bonusNumber.getNumber();
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1 이상 45 이하여야 합니다.");
        }

        // 중복 여부 확인
        for (LottoNumber lottoNumber : numbers) {
            if (lottoNumber.getNumber().equals(number)) {
                throw new IllegalArgumentException("보너스 번호는 기존 번호와 중복될 수 없습니다.");
            }
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
