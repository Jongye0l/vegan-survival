# vegan-survival
---
### 소개 Information
* 비건 야생 플러그인입니다.
* 고기를 먹을시 비건 수치가 오르며 비건수치에 따라 디버프가 존재합니다.
* 비건 수치가 100이 되면 고기를 먹을 수 없게 됩니다.
---
### 사용 방법 How to use
* [이 링크](https://github.com/Jongye0l/vegan-survival/releases/latest) 에서 다운로드후 플러그인 폴더에 옮겨 주시고 서버를 켜시면 됩니다.
---
### 기능 Feature
* 고기를 먹으면 비건수치가 3 오릅니다.
* 비건수치가 70, 80, 90, 100이 되면 디버프가 걸립니다.
* 비건수치가 ActionBar에 나옵니다.
* 비건소모제 라는 아이템으로 비건수치를 초기화 할 수 있습니다.
* 비건완화제 라는 아이템으로 비건수치를 초기화 하고 5분간 비건이 오르지 않게 할 수 있습니다.
* 비건 약식 치료제 라는 아이템으로 비건수치를 10 낮출수 있습니다.
* /vegan 명령어가 있습니다.
    * /vegan set [offlinePlayer] [vegan] - 비건 수치 설정
    * /vegan add [offlinePlayer] [vegan] - 비건 수치 추가
    * /vegan remove [offlinePlayer] [vegan] - 비건 수치 제거
    * /vegan show [offlinePlayer] - 비건 수치 확인
    * /vegan give [player] [item] - 아이템 얻기
        * Consumables - 비건 소모제
        * Laxative - 비건 완화제
        * smallremedy - 비건 약식 치료제
    * /vegan config
      * /vegan config addvegan [integer]
      * /vegan config regenhealth [integer]
      * /vegan config regenhungerreset [boolean]
* 죽어도 배고픔이 초기화 되지 않고 체력이 1로 리스폰 합니다.
* 비건 수치는 100을 넘지 못합니다.
* 비건 수치가 100이 넘는다면 음식을 먹지 못합니다.
* 3일간 아무것도 먹지 않으면 허기3이 걸립니다.
* 배고픔 수치가 소숫점으로 표시됩니다.
* 받는 데미지가 배고픔에 따라서 증가합니다.
* 고기를 먹지 않았을 때 배고픔 증가량이 1/10이 되었습니다.
* 농작물이 자랄시 50%확률로 취소됩니다.
---
### 구성 config
* addvegan - 고기를 먹었을때 비건 추가량
* regenhealth - 리스폰 했을 때에 체력설정
* regenhungerreset - 리스폰 했을 때 배고픔 초기화 여부
---
### 안내 사항 Instructions
* 위 프로젝트는 BSD 3-clause 라이선스를 가지고 있습니다.
* 이 플러그인을 사용하려면 [JongyeolLibrary](https://github.com/Jongye0l/JongyeolLibrary/releases/latest) 1.3.0 이상의 플러그인이 필요합니다.
---
### 개발 환경 Development environment
* Windows 11
* IntelliJ IDEA 2021.3.2 (Community Edition)
* Oracle OpenJDK 17.0.5
* Spigot 1.19(R0.1-20220725.090125-47)
* bungeecord-chat-1.16(R0.4)
---
### 테스트 환경 Test environment
* Windows 11
* Spigot 1.19(3540-Spigot-56be6a8-0231a37)
* Minecraft 1.19 Feather Client(00bedfdf)
---
### 기여자 Contributors
* Hi_Templar123 - 아이디어
