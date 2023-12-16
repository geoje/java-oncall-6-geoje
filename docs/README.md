# 🚨 우테코 6기 코테 - 개발자 비상근무

우테코 6기 코테 **개발자 비상근무** 은 사용자에게 입력 받은 월과 시작 요일을 바탕으로 비상 근무표를 만드는 프로그램입니다.

비상 근무표에서는 한 사람이 이틀 이상 근무를 하지 않는 등의 조건이 있습니다.

법정 공휴일은 주식회사 우택호 인사팀에서 보낸 메일에 총 `8일` 로 지정합니다.

---

## 🔍 목차

- ⚙️ 구현할 기능 목록
- 📋 프로젝트 구조
- ✨ 최종 코딩테스트를 통해 배운 것

---

## ⚙️ 구현할 기능 목록

예외 상황이 생기면 `[ERROR]` 로 시작하는 메세지를 출력한 후 다시 입력을 받습니다.

### 1️⃣ 월과 시작 요일 입력 받기 ✔️

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>비상 근무를 배정할 월과 시작 요일을 입력하세요></code>
    </li><br>
    <li>월과 요일을 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>입력받은 값을 <code>,</code> 로 분리했을 때 개수가 2개가 아닐 경우 ✔️</li>
    <li>입력받은 월이 <code>1 ~ 12</code> 월 중 하나가 아닐 경우 ✔️</li>
    <li>
        입력받은 요일이 <code>일 ~ 토</code> 중 하나가 아닐 경우 ✔️<br>
        <code>[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.</code>
    </li>
</ul></td>
</tr>
</table>

### 2️⃣ 비상 근무 사원 입력 받기 ✔️

평일 순번 또는 휴일 순번의 입력 값이 올바르지 않은 경우 `평일 순번` 부터 다시 입력 받는다.

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>평일 비상 근무 순번대로 사원 닉네임을 입력하세요></code>
    </li><br>
    <li>근무 사원들을 입력받고 잘 입력 받았는지 체크 ✔️</li><br>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>휴일 비상 근무 순번대로 사원 닉네임을 입력하세요></code>
    </li><br>
    <li>근무 사원들을 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>
        사원의 수가 5명 미만 또는 35명을 초과일 경우 ✔️<br>
        <code>[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.</code>
    </li><br>
    <li>
        사원의 이름이 5자를 초과할 경우 ✔️<br>
        <code>[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.</code>
    </li><br>
    <li>
        사원의 이름이 중복될 경우 ✔️<br>
        <code>[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.</code>
    </li>
</ul></td>
</tr>
</table>

### 3️⃣ 비상 근무표 출력 ✔️

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        입력할 월에 해당하면 모든 날에 대한 비상 근무표 출력 ✔️<br>
        <code>5월 1일 월 준팍</code><br>
        <code>5월 2일 화 도밥</code><br>
        <code>5월 3일 수 고니</code><br>
        <code>...</code>
    </li><br>
</ul></td>
<td><ul>
    <li>평일이면서 법정공휴일의 경우에만 요일 뒤에 <code>(휴일)</code> 표기 ✔️</li><br>
    <li>비상 근무표 출력을 완료하면 프로그램은 종료 ✔️</li>
</ul></td>
</tr>
</table>

---

## 📋 프로젝트 구조

### 📦 패키지

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td rowspan="4">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/constants.svg?sanitize=true"/>
            <b> constant</b>
        </td>
        <td><b>DayOfWeekKo</b></td>
        <td>요일을 한글로 표시해주며 다양한 숫자를 요일로 바꿔주는 상수</td>
    </tr>
    <tr>
        <td><b>ErrorMessage</b></td>
        <td>예외 상황에 사용 되는 정적 메세지</td>
    </tr>
    <tr>
        <td><b>GeneralMessage</b></td>
        <td>일반적인 입력 요청 또는 결과 알림에 사용 되는 메세지</td>
    </tr>
    <tr>
        <td><b>Holiday</b></td>
        <td>공휴일을 의미하는 상수</td>
    </tr>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true"/>
            <b> controller</b>
        </td>
        <td><b>ScheduleController</b></td>
        <td>여러 입력을 받아 최종 근무표를 요청하여 출력까지 해주는 전체 진행 담당 컨트롤러</td>
    </tr>
    <tr>
        <td rowspan="4">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>AdvancedCalendar</b></td>
        <td>월과 요일로 새로운 달력을 만들고 근무자를 통해 근무표까지 만들어 주는 도메인</td>
    </tr>
    <tr>
        <td><b>DaySchedule</b></td>
        <td>한 날의 근무 스케쥴 하나를 의미하는 도메인</td>
    </tr>
    <tr>
        <td><b>Worker</b></td>
        <td>한 근무자를 의마하는 도메인</td>
    </tr>
    <tr>
        <td><b>Workers</b></td>
        <td>여러 근무자 컬렉션을 가지며 다음 근무자를 뽑아주는 도메인</td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/views.svg?sanitize=true"/>
            <b> view</b>
        </td>
        <td><b>InputView</b></td>
        <td>사용자에게 질문을 하고 입력을 받아주는 뷰</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 일반적인 메세지와 결과 및 에외 메세지를 출력해주는 뷰</td>
    </tr>
</table>

---

## ✨ 최종 코딩테스트를 통해 배운 것

### 💡 AtomicReference

- 프리코스 `4주차` 에서 `AtomicInteger` 을 먼저 공부 했었습니다.
- 예전과는 다르기 `AtomicReference` 를 사용하였습니다.
- `4주차` 에서는 `병렬적` 계산에 사용되어 여러 스레드가 동시 접근하는 문제가 발생하였습니다.
- 이번 최종 코딩테스트에서도 비슷하지만 단순히 다른 스레드에서 지역 변수를 엑세스 하려고 하니 문제가 생겼고 `AtomicInteger` 를 사용하여 해결 할 수 있는 문구를 확인하였습니다.
- 병렬처리에서만이 아닌 단순히 크로스 스레드로 데이터를 엑세스할 경우 이 객체를 사용하면 될 것임을 제대로 배울 수 있었습니다.
  ![](https://velog.velcdn.com/images/chch1213/post/760bc0e9-9447-4f20-8421-44fe5611b4fc/image.png)

### 💡 일급 컬렉션

- `2주차` 에서 부터 계속 사용해오던 일급 컬렉션 도메인 객체에서의 한계점도 부딪히게 되었습니다.
- `Workers` 라는 도메인을 만들어 `List<Worker>` 를 하나의 객체로 가지는 `Record` 로 만들었습니다.
- 이후 최종 근무 테이블을 만들 때 `Workers` 에서 `Worker` 한명 한명을 뽑아 쓰는 작업을 해야했습니다.
- 해당 작업을 할 때 근무자를 뽑은 뒤 `index` 가 변경되고 저장되어 있어야 하는데 이를 수행하기 위해서 `Record` 는 인스턴스 필드를 사용할 수 없었습니다.
- 과김히 `Class` 로 변환하였고 `index` 와 `change` 2개의 필드를 추가하여 기능을 정상적으로 수행할 수 있도록 하였습니다.
  ![](https://velog.velcdn.com/images/chch1213/post/0c68f34a-de96-4d54-bdcb-d1ed510379dd/image.png)

### 💡 TDD - 테스트 주도 개발

- 프리코스 기간동안 매우 중요하게 여겨 도메인 객체를 만들 때 마다 최소 단위의 테스트를 시행하였습니다.
- 하지만 최종 코딩 테스트는 프리코스의 기간인 `7일` 이 아닌 `5시간` 이였습니다.
- 따라서 시간을 효율적으로 쓰기 위해 프리코스 때 처럼 도메인에 기능을 하나 만들 때 마다 단위 테스트를 만드는 것을 불가능 하다 판단하였습니다.
- 사용자의 입력에 대한 예외 처리는 꼭 필요하다 생각하였고 해당 예외 처리 부분만은 기능을 모두 만든 뒤 테스트 코드 또한 작성하였습니다.
- 이로 인해 놓친 예외 사항 2가지를 최종 테스트 전에 빠르게 판별할 수 있었고 해당 기능을 빠르게 수정하였습니다.
- 제공된 `ApplicationTest` 은 공휴일과 근무 오프에 대한 예시가 없었습니다.
- 해당 기능도 잘 테스트 되는지 확인 하기 위해 제공된 코드를 복사한 후 입력 값을 조정하여 `테스트 함수 2개를 추가` 하였습니다.
  ![](https://velog.velcdn.com/images/chch1213/post/ad3c40df-8144-4cf6-a228-985559698b83/image.png)

### 💡 시간 제한

- 확실히 일주일 동안 과제를 수행하던 `프리코스` 와는 달리 `5시간` 안에 해결해야하는 `최종 코딩테스트` 는 굉장히 촉박했습니다.
- 프리코스를 진행하며 제 자신이 코딩하는 영역의 어느 부분이 오래 걸리는지 알고 있었습니다.
- 주어진 과제에서 사용자의 입력을 받는 `3부분` 을 검증 까지 처리하는 것과 최종 결과를 출력하기 위한 `연산 부분` 이렇게 `2가지` 오래 걸릴 것이라 예상하였습니다.
- 과제를 읽으며 각 부분에 `2시간` 정도를 부여하면 충분할 것이라 생각하였고 실제로 총 합 `4시간` 을 사용한 `5시 30분`이 되었을 때 `적당한 테스트 코드` 와 `모든 기능 구현` 을 완료하였습니다.
- 이제 남은 `1시간` 동안 테스트 코드를 작성하고 싶었지만 프로그램의 더 좋은 시각화를 위해 문서를 작성하는데 더 집중하자고 생각하였습니다.
- 그렇게 `4주차` 만큼 완벽하게는 하지 못하였지만 제가 보여줄 수 있는 모든 것은 보여줄 수 있었다 생각합니다.
- 실제 프로젝트도 기한 제한이 있는 만큼 집중하여 개발하는 것에 대해 더욱 배울 수 있는 좋은 시간이였습니다.

# 👍