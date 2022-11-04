package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MATCH_POINT = 1;
    private static final int MISMATCH_POINT = 0;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String EXCEPTION_MESSAGE_FOR_INCONSISTENCY_LOTTO_NUMBERS_SIZE = "로또번호 갯수는 " + LOTTO_NUMBERS_SIZE + "이어야 합니다.";
    public static final String EXCEPTION_MESSAGE_FOR_LOTTO_NUMBERS_DUPLICATION = "로또번호는 중복일 수 없습니다";
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> lottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public int getMatchPoint(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber) ? MATCH_POINT : MISMATCH_POINT;
    }

    public boolean getMatchBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberDuplication(lottoNumbers);
        validateLottoNumbersSize(lottoNumbers);
    }

    private static void validateLottoNumberDuplication(List<LottoNumber> lottoNumbers) {
        int setSize = lottoNumbers.stream()
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toSet())
                .size();
        if (setSize != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_LOTTO_NUMBERS_DUPLICATION);
        }
    }

    private static void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_INCONSISTENCY_LOTTO_NUMBERS_SIZE);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
