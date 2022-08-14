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

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/184502984-ec0b80f5-c20d-42b5-b45f-70ea7823270e.png">

* add-coach에서 3개 commit 생성
	* 뻗어서 나가는 것을 확인할 수 있다.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/184503050-d8f79f45-b839-4956-94c7-5462428fa354.png">

* new-teams에도 2개의 commit 생성
	* 가지가 총 3개 생겼다.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/184503153-9aac53de-6909-4d1e-b550-86cbcd8ace77.png">

* 만약 add-coach 브랜치에서 git log를 출력하면 빨간색과 같은 로그만 보인다.

* 만약 모든 commit 이력들을 확인하고 싶다면 아래와 같은 명령어를 치면 된다.
	* git log --all --decorate --oneline --graph

<img width="460" alt="image" src="https://user-images.githubusercontent.com/51740388/184503198-656965ec-752b-43c7-ae34-690c737ced5c.png">

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

