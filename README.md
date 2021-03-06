# Project Yut
<br>
전통게임 윷놀이를 Java로 구현하였습니다.
<br><br><br>


## 만들게 된 이유

자바를 공부중에 있던 와중, 명절 설날에 윷놀이를 가족과 같이 하게 되었습니다.<br><br>
객체를 중심으로 구현하기에 좋을 거 같아 자바 공부겸 GUI까지 만드는 프로젝트를 만들고 싶어 방학동안 개인적으로 진행하게 되었습니다.<br><br>

## 실행방법 및 구성 화면
<br>

> WholeGameGUI_FirstPage 를 실행시킵니다.


![K-001](https://user-images.githubusercontent.com/75191916/158020726-377e7ab1-6277-4233-a350-55dea904704a.png)

- 최소 2명에서 4명까지 플레이 가능하며 개인전으로 이루어집니다.<br>
<br>

- 말 또한 2개에서 4개의 말을 지정할 수 있습니다.


![K-002](https://user-images.githubusercontent.com/75191916/158021205-7b2f59d6-9b7a-438b-b7a0-47a7114d45d4.png)


- 기본적으로 게임은 위 화면의 구성으로 이루어집니다.<br>
<br>


![KakaoTalk_20220312_230843364](https://user-images.githubusercontent.com/75191916/158021194-da876166-6a2c-4312-86ca-818d00efe7b0.jpg)


- 위는 간단한 설명을 적어둔 이미지 입니다.<br>
<br>

- 처음 시작 플레이어는 랜덤으로 정해지며 그 이후에는 순차적으로 돌아갑니다.

<br>

- 이후에는 __상태창을 따라__ 진행하면 됩니다. 그렇지 않을시 버그가 일어날 수도 있습니다.


## 구현 도메인

- 기본적인 이동과정 구현

- 갈림길시 대각선으로 이동

- 백도 구현, 이는 자기가 왔던 길을 기억해서 한칸 뒤로 이동함. 말이 없을경우에는 다음 플레이어의 차례로 넘어감

- 말을 업을 수 있음, 어떤 말을 업었는지는 윷판에 표시됨.

- 게임이 끝나면 우승자를 알려주고 다시하기 창을 띄워줌


![K-003](https://user-images.githubusercontent.com/75191916/158021496-ccd20612-0109-460a-9f62-dafa5179e802.png)
