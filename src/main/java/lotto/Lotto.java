package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        // 2. 숫자들이 1~45 사이인지 확인
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("숫자는 1 이상 45 이하여야 합니다.");
            }
        }

        // 3. 중복 여부 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자들은 중복될 수 없습니다.");
        }

        //4. 오름차순 확인
        for(int i=0; i<numbers.size()-1; i++){
            if(numbers.get(i) > numbers.get(i+1)){
                throw new IllegalArgumentException();
            }
        }

    }

    // TODO: 추가 기능 구현
}
