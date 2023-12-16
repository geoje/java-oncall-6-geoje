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
        사원의 수가 35명을 초과할 경우 ✔️<br>
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

### 3️⃣ 비상 근무표 출력

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        입력할 월에 해당하면 모든 날에 대한 비상 근무표 출력<br>
        <code>5월 1일 월 준팍</code><br>
        <code>5월 2일 화 도밥</code><br>
        <code>5월 3일 수 고니</code><br>
        <code>...</code>
    </li><br>
</ul></td>
<td><ul>
    <li>평일이면서 법정공휴일의 경우에만 요일 뒤에 <code>(휴일)</code> 표기</li><br>
    <li>비상 근무표 출력을 완료하면 프로그램은 종료 ✔️</li>
</ul></td>
</tr>
</table>

> 1️⃣ 2️⃣ 3️⃣ 4️⃣ 5️⃣ 6️⃣ ✔️

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
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/constants.svg?sanitize=true"/>
            <b> constant</b>
        </td>
        <td><b>ErrorMessage</b></td>
        <td>예외 상황에 사용 되는 정적 메세지</td>
    </tr>
    <tr>
        <td><b>GeneralMessage</b></td>
        <td>일반 적인 입력 요청 또는 결과 알림에 사용 되는 메세지</td>
    </tr>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true"/>
            <b> controller</b>
        </td>
        <td><b>XXXXController</b></td>
        <td>입력을 받아 계산하고 출력 해주는 전체 진행 담당 컨트롤러</td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>XXXX</b></td>
        <td>XXXX</td>
    </tr>
    <tr>
        <td><b>XXXX</b></td>
        <td>XXXX</td>
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

### 💡 XXXX

- XXXX

년도를 고려하지 않고 2월이 28일까지있으면 되니 `2023` 또는 `2024` 년으로 고정하였다.
2023 선택

나만의 켈린더를 만들어서 실제 그 달의 요일에서 내가 입력을 요일 만큼 차를 구한다.
이는 `Offset` 으로 사용되어 나중에 프로그램이 원하는 날짜의 요일을 반환할 때 차
이만큼 더하고 나머지를 구해서 요일 표시에 사용된다.

시간 남으면 Workers 에서 , 분리 후 공백인 문자열은 제거하고 Worker 생성하여 좀 더 유연하게 리팩토링 하자