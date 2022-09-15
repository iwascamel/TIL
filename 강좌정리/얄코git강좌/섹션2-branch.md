# 섹션2 branch

## 1. branch 기능들

* 여러가지 버전을 하나의 프로젝트에서 진행할 수 있도록 해준다.
* git branch add-coach
* git switch add-coach
	* git checkout으로 사용할 수도 있는데, git 2.23부터 checkout이 switch, restore로 분리됐다.
* 브랜치 생성 동시에 분리
	* 예전엔 git checkout -b (새 브랜치 명)
	* git switch -c (새 브랜치 명)
* 브랜치 삭제
	* git branch -d (브랜치 명)
		* -D 옵션을 주면 강제삭제가 일어난다.
			* 지워질 브랜치에만 있는 내용의 커밋이 있을 경우 사용한다.
* 브랜치 이름 바꾸기
	* git branch -m (기존 브랜치 명) (바꿀 이름)

## 2. branch 실습

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184502874-0efb6b0a-3da9-49dd-bd1d-0148a5b38f52.png">

* main에서 2개 브랜치 생성
	* 이후 2개 commit 생성했다.
	* main에서 커밋하면 위처럼 혼자 앞서간다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184502984-ec0b80f5-c20d-42b5-b45f-70ea7823270e.png">

* add-coach에서 3개 commit 생성
	* 뻗어서 나가는 것을 확인할 수 있다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184503050-d8f79f45-b839-4956-94c7-5462428fa354.png">

* new-teams에도 2개의 commit 생성
	* 가지가 총 3개 생겼다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184503153-9aac53de-6909-4d1e-b550-86cbcd8ace77.png">

* 만약 add-coach 브랜치에서 git log를 출력하면 빨간색과 같은 로그만 보인다.

* 만약 모든 commit 이력들을 확인하고 싶다면 아래와 같은 명령어를 치면 된다.
	* git log --all --decorate --oneline --graph

<img width="500" alt="image" src="https://user-images.githubusercontent.com/51740388/184503198-656965ec-752b-43c7-ae34-690c737ced5c.png">

* 그런데 CLI는 확인하기 좀 힘드므로, 만약 분기를 확인해야 한다면 GUI인 소스트리를 통해 확인하자.

## 3. Branch 합치기 - Merge, Rebase

### 3-1) Merge vs Rebase 차이점

* merge가 합치는 거라면, rebase는 대상 가지들을 옮겨주는 것이다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184504258-5be2dd25-014a-4d42-8b05-bf60a42aa5ee.png">

* 노란색이 merge를 했을 때, 보라색은 rebase를 했을 때를 보여준다.
* rebase를 한 뒤 commit log는 한 줄로 깔끔하게 정리가 되지만, merge는 branch의 log를 남긴다.
	* merge는 끝에만 모아서 병합을 하니까 잔가지가 남는다.
	* rebase는 곁가지를 잘라서 몸통에다 붙이는 형식이기 때문에 history를 한 줄로 깔끔하게 남길 수 있다.
* 그래서 branch 사용 내역들을 남기려면 merge를, history를 깔끔하게 만드는 것이 중요하다면 rebase를 사용하자.
	* 이미 팀원들간 공유된 commit들에 대해서는 rebase를 사용하지 않는 것이 좋다.

## 4. Merge , Rebase 합치기 실습

### 4-1) Merge

* 책정리.다재다능코틀린프로그래밍.codes.main branch에서 add-coach branch를 merge하게 되면 아래와 같은 그래프가 나오게 된다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184528090-65ccce5e-c5f0-4756-a539-eb716636025b.png">

* merge역시 하나의 커밋이다.
	* 그렇기 때문에 reset으로 되돌릴 수 있다.
* 책정리.다재다능코틀린프로그래밍.codes.main 직전의 커밋(위 그래프에선 `Add Freddie to Panthers`)으로 reset --hard로 되돌리면 아래와 같이 되돌아간다.

<img width="650" alt="image" src="https://user-images.githubusercontent.com/51740388/184528147-226a8deb-0b71-4424-8ef9-a54d1b2dbad5.png">

### 4-2) Rebase

* 만약 A브랜치를 main에 합치려고 한다면 책정리.다재다능코틀린프로그래밍.codes.main 에서 git merge A를 해주어야 하지만, rebase는 반대다.
* A로 이동 후, A에서 rebase main을 해줘야 한다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184528277-693ae0e2-5140-4885-8a52-0ac9b822797a.png">

* rebase를 하면 위와 같이 결과물이 나온다.
* 이 때, main은 new-teams에 비해 뒤에 있게 된다.
	* 해당 문제는 merge로 해결한다.
* main에서 git merge new-teams를 해주면 해결된다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184528340-c2b4f66d-c416-40cd-ac28-3b48ebabae72.png">
## 5. Branch간 충돌 해결하기

### 5-1) 충돌 발생 이유

* 서로 다른 파일이나, 같은 파일이라고 해도 다른 부분을 수정하면 merge나 rebase할 때 충돌이 발생하지 않는다.
* 그러나 다른 브랜치에서 같은 파일에 같은 줄의 코드를 수정하게 되면 어떤 파일을 병합할 지 선택할 수 없기 때문에 문제가 발생한다.

### 5-2) 충돌 발생 예제: Merge

* 책정리.다재다능코틀린프로그래밍.codes.main 브랜치와 conflict-1, conflict-2 브랜치가 충돌이 나게 설정한다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184528510-38cc5d4c-9025-47e3-b35a-1ee470cda19e.png">

* main에서 conflict-1과 merge를 진행하면 충돌이 생긴다.

```
<<<<<<< HEAD
manager: Kenneth
=======
manager: Deborah
>>>>>>> conflict-1
```

* 이 때 충돌이 난 파일들을 검색하려면 아래와 같이 검색에 >>>를 하는 것으로 쉽게 찾을 수 있다.

<img width="331" alt="image" src="https://user-images.githubusercontent.com/51740388/184528587-393ec84c-2078-4683-8d1c-81085149ea05.png">

* 만약 충돌이 많아서 해결하기 어려운 경우, 되돌려야 되는 경우
	* git merge --abort
	* 를 입력해주면 돌아간다.
* 충돌이 난 파일 중에 골라주고 ( vsc 기능으로 쉽게 할 수 있다. 나는 뭔가 extention이 충돌나는 지 현재 작동이 안된다.)
	* git add .
	* git commit
	* 을 해주면 자동으로 commit 메세지가 입력돼있다.

### 5-3) 충돌 발생 예제: Rebase
<img width="760" alt="image" src="https://user-images.githubusercontent.com/51740388/184539716-9b1c49c5-0ff1-471b-a525-18c99ce24a8d.png">

* merge의 경우 양쪽의 갈래를 한 번에 이어붙이는 것이기 때문에 commit 한 번에 끝난다.
* rebase의 경우 해당 branch의 각 commit마다 반대의 코드가 실행돼야 하기 때문에, 각 commit마다 따로따로 차례로 해결해줘야 한다.

<img width="603" alt="image" src="https://user-images.githubusercontent.com/51740388/184540015-3a01ef05-d9bf-43ee-8562-ab237b5b98c6.png">

* git switch conflict-2
* git rebase 책정리.다재다능코틀린프로그래밍.codes.main
* 하면 위와 같이 충돌이 생긴다.

<img width="572" alt="image" src="https://user-images.githubusercontent.com/51740388/184540053-df026e2f-5eff-47ce-8883-0e95c3a1b495.png">

* git status를 쳐보면 `leopards.yaml` 에서 충돌이 발생한 것을 확인할 수 있다.
* 만약 충돌이 해결이 안될 것 같으면 git rebase --abort를 입력해주면 돌아간다.
* 충돌을 해결했다면
	* git add .
	* git commit
	* 을 해준다.
* 이후 git rebase --continue를 해준다
	* 해당 예제에서는 해당 rebase브랜치에 commit이 2개가 있기 때문이다.
* 그런 다음 다시 수정 이후 add 이후 git rebase --continue를 해준다.


