# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습 요구사항 
### String 클래스에 대한 학습 테스트
- [x] : split 테스트 코드 작성
- [x] : substring 테스트 코드 작성
- [x] : charAt을 활용한 StringIndexOutOfBoundsException 발생 테스트 코드 작성

### Set Collection에 대한 학습 테스트
- [x] : size를 활용한 크기 확인 테스트 코드 작성
- [x] : contains를 활용해 값이 존재하는지 확인하는 테스트 코드 작성
  - 중복코드를 줄이기 위해 JUnit의 `ParameterizedTest`를 활용 할 것
- [x] : @CsvSource를 활용하여 요구사항 2에서 false가 반환되는 테스트 코드 작성

## 2단계 - 문자열 덧셈 계산기
> 객체지향 생활 체조 원칙을 고려하여 프로그래밍 할 것
- [x] : null 또는 빈문자는 `0`을 반환
- [x] : 숫자 하나만 입력할 경우 해당 숫자를 반환
- [x] : 쉼표(`,`), 콜론(`:`)을 구분자로 가지는 문자열을 전달하여, 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [x] : 기본 구분자(`,`, `:`)외에 커스텀 구분자 지정.
  - `//`와 `\n`사이에 위치하는 문자를 커스텀 구분자로 사용한다
  - ex) `//;\n1;2;3`의 경우 커스텀 구분자는 `;`이며, 결과 값은 `6`이 반환
- [x] : 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw

## 3단계 - 로또(자동)
> 객체지향 생활 체조 원칙 고려  
>   - 특히, 일급 콜렉션 규칙을 지킬 수 있도록 노력할 것
### Domain
- 구입금액
  - [x] 1장당 가격은 1000원
  - [x] 1000원 이하인 경우 오류
- 로또번호
  - [x] 로또 번호는 1 ~ 45 사이의 숫자
  - [x] 로또 번호는 1 ~ 45 사이의 숫자가 아니면 에러
- 로또 
  - [x] 로또번호 6개로 구성
  - [x] 로또번호 6개가 아닌 경우 에러
  - [x] 당첨로또와 비교하여 결과 반환
- 로또발급기
  - [x] 로또번호 6개를 구성하여 로또를 발급
  - [x] 로또번호 6개를 자동으로 발급(전략패턴 반영)
- 로또들
  - [x] 로또리스트
- 로또판매자
  - [x] 구입금액을 입력받아 로또들을 발급하여 구입 가능 갯수만큼 반환한다
- 당첨로또
  - [x] 지난 주 당첨 번호(로또번호) 6개를 입력받아 구성
- 당첨랭킹(당첨로또 vs 발급한 로또들)
  - [x] 6개 일치(2,000,000,000원)
  - [x] 5개 일치(1,500,000원)
  - [x] 4개 일치(50,000원)
  - [x] 3개 일치(5,000원)
  - [x] 2, 1, 0 개 일치(0원)
- 당첨결과집계
  - 랭킹들(랭킹 Map)
  - 수익률
    - [x] 당첨금합계 / 구입금액을 소숫점 계산하여 반환

### View
- 출력
  - [x] 발급한 로또들의 번호
  - [x] 당첨 통계
  - [x] 총 수익률(소수점 2째 자리 표시)
