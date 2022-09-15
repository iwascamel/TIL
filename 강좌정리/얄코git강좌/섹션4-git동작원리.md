# 섹션 4 git 동작원리

## 1. VCS로서 git의 장점
### 1-1) snapshot을 사용한다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/184878797-7ee2a631-7acf-4125-80b6-41afa281fd16.png">

* vs delta 방식
    * delta방식은 처음 파일과 비교해서 변경 사항이 있을 때마다 변경 사항을 저장한다.
    * 이 때의 단점은 각 파일이 만들어진 시점부터 해서 변경사항들을 모두 더해서 현재 내용을 계산해내야 하므로 commit이 많아질수록 느려진다.
* 스냅샷 방식
    * 현 시점에 모든 파일들이 모두 차 있으므로, 빠르다.
### 1-2) 중앙 집중식이 아닌, 분산 버전 관리 시스템이다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184879288-1a982e9f-65ff-451b-b472-6cf602aa2579.png">

* 중앙 집중식
    * CVS나 Subversion등의 VCS는 git의 github같은 원격서버에 모든 관리내역들이 저장된다.
    * 로컬에서는 중앙서버로부터 다운받은 파일들로만 작업할 수 있다.
        * 즉, 원격 저장소에 의존적이다.
        * 만약 인터넷이 연결이 안되면 작업을 진행할 수 없다.
* 분산 버전 관리식
    * 로컬의 파일 뿐 아니라 전체 git commit, branch들도 받아져서 인터넷과 상관없이 작업할 수 있다.
    * 즉 모든 구성원들이 git의 상태까지 공유한다.

## 2. git의 3가지 공간

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184881081-d8c16f1e-64f2-41b3-a1ed-5ac35cf1e735.png">

### 2-1) add 테스트

<img width="562" alt="image" src="https://user-images.githubusercontent.com/51740388/184881482-6e9cd060-0909-4a9d-8f53-13fd8d3e8d14.png">

* 만약 tigers.yaml을 지우고 git status를 치면 위와 같이 로그가 뜬다.
* git add . 를 해줘야 staging area에 올라간 것이다.

<img width="469" alt="image" src="https://user-images.githubusercontent.com/51740388/184881615-785db9a2-3375-49b4-804c-5885cdfa5fef.png">

* 돌려주려면 `git reset --hard`를 입력해주자.

### 2-2) git rm

* 만약 삭제와 동시에 commit을 하고 싶다면, 즉 해당 파일을 삭제 후 삭제 상태를 바로 staging area에 올리고 싶다면 git rm (해당파일)을 해주자.

### 2-3) git mv

* tigers.yaml -> zzamtigers.yaml으로 변경해보자.

<img width="566" alt="image" src="https://user-images.githubusercontent.com/51740388/184882123-ab576ad9-e529-4087-b10f-3f1f3eec965b.png">

* 그러면 위와 같이 삭제와 동시에 추가됐다는 로그가 생성된다.
* git add . 를 해주고 나서야 아래와 같이 renamed라고 뜬다.

<img width="407" alt="image" src="https://user-images.githubusercontent.com/51740388/184882320-b2763f18-b9b5-44f4-bc4d-748838baa567.png">

* 위 내역을 커밋까지 한 번에 하려면 `git mv tigers.yaml zzamtigers.yaml` 을 쳐주면 된다.

### 2-4) 커밋 분리

* 만약 staging area에 올린 것을 working directory에 되돌려놓고 싶다면?
    * 즉, 이번 commit에 해당 파일들의 변화는 올리고 싶지 않다면?

<img width="500" alt="image" src="https://user-images.githubusercontent.com/51740388/184882880-cdf32d18-790a-4a29-8654-e8546644f621.png">

* git restore --staged (해당 파일)

<img width="530" alt="image" src="https://user-images.githubusercontent.com/51740388/184883033-05051050-d4c9-4e2e-85b5-2176d553608e.png">

* 빠진 것을 확인할 수 있다.

* 만약 working directory에서도 빼고 싶다면?
    * git restore (해당 파일)
    * 즉, add가 안된 상태로 restore을 하게 된다면 untracked으로 돌아가게 된다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/184883276-259ece94-e55f-4df5-b814-bafdc9abc5e5.png">

### 2-5) reset의 3가지 옵션

* --soft
    * repository에서만 제거하고, staging area에는 남겨놓는다.
    * 즉, add는 됐지만 commit은 안된 상태로 돌려놓는다.
* --mixed(default)
    * working directory에는 남겨놓는다.
    * 즉, 파일 자체는 변화시키지 않는다.
    * staging area에서 제거한다.
    * 즉, add가 되기 전으로 돌아간다.
* --hard
    * 그 자체를 지워버린다.
    * working directory까지 지워버린다.
    * 가장 과격한 방법이다.

## 3. head

### 3-1) git checkout^

* head
	* 현재 속한 branch의 가장 최신 커밋
	* 이 때, 무조건 끝에 있는 게 아니라, 해당 branch의 마지막 커밋이라는 것이 중요하다.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/185922274-dc5f34f2-d42f-47ca-80ac-3102257a76c0.png">

* 즉 위의 경우, main은 head에 있지만 delta-branch보다 뒤에 있다.

* checkout
	* 파일들의 상태는 바꾸지 않고 해당 커밋지점으로 이동하는 것
* git checkout^^
	* ^ 나 ~ 개수만큼 뒤로 checkout을 한다.

<img width="591" alt="image" src="https://user-images.githubusercontent.com/51740388/185923911-e365d6d0-7d79-4650-b0ae-b8293bf0249e.png">

* delta-branch의 head에서 `git checkout~~` 을 하면, 위와 같이 된다.

* git checkout -
	* ctrl z와 같이 동작한다.
* 그런데 head는 해당 브랜치의 가장 앞 브랜치인데, head라고 표시돼 있다.
	* 그 이유는, 새로운 branch를 생성해서, 그 branch의 가장 앞에 존재하기 때문이다.
		* 즉, 해당 커밋에서 갈라진, 그러나 이름이 아직 붙여지지 않은 새로운 branch에 위치해 있는 것이다.
	* 만약 가장 delta-branch의 가장 앞으로 가고 싶다면 git switch delta-branch를 하면 된다.

### 3-2) 분기

<img width="660" alt="image" src="https://user-images.githubusercontent.com/51740388/185924877-e6639902-25a8-4a8f-bbe1-44ed7e39e546.png">

* 만약에 beta-branch의 head 이전에 분기를 만들고 싶다고 해보자.
* git checkout beta-branch
* git checkout head~
* git switch -c gamma-branch
* 파일 수정
* git commit -am 'gamma 1st commit'

### 3-3) 분기2

* 만약 2단계 전으로 reset을 시키고 싶다면?
	* git reset --hard head~2

## 4. fetch & pull

* fetch
	* remote(원격저장소)의 최신 commit을 로컬로 가져오기만 한다.
* pull
	* fetch + merge or rebase
	* default는 merge다.

* 그래서 책정리.다재다능코틀린프로그래밍.codes.main - origin/main이 있다고 했을 때, git fetch만 받아온다.
	* 그리고, git checkout origin/main을 한 다음에 해당 코드들을 돌려보고 이후 merge를 해줘도 된다.

* git switch -t origin/new-branch
	* -t
		* trace option
	* 원격에도 new-branch가 생성되고, 원격 origin/new-branch와 같게 trace한다.
	* 또한, -t가 -u와 같이 작동한다?
		* 그래서 commit들을 앞으로 주고받을 수 있게 된다.

## 5. git help & 각종 설정

### 5-1) git help

* git help
	* 기본적인 명령어들
* git help -a
	* 모든 명령어들
* git commit -h 를 입력하면 뒤에 어떤 option이 있는 지 볼 수 있다.
* git help commit
	* commit에 대한 help를 볼 수 있다.
	* 웹에서 열고 싶으면 -w를 붙여주자.
* git branch --help

### 5-2) git config

* config를 --global로 설정하면 전역으로 설정된다.
* git config --global user.name
	* 현재 global로 설정돼 있는 유저네임 출력
	* 만약 이름을 새로 설정해주고 싶다면, git config --global user.name (이름)
* 만약 현재 폴더에서만 다른 이름을 설정해주고 싶다면
	* git config user.name (이름)
* git config --list
	* 현재 프로젝트의 설정값들을 볼 수 있다.
* git config --global --list
	* 글로벌 설정들만 보여준다.
* git config -e
	* editor안에서 열리게 해준다.
	* git config --global core.editor "code --wait"
		* vim은 불편하니, vsc code를 default값으로 설정해서 vsc로 열 수 있게 해준다.
		* --wait
			* 에디터를 수정하는 동안 CLI를 정지

* 줄바꿈 호환문제 해결
	* git config --global core.autocrlf (윈도우: true / 맥: input)
		* 엔터를 하는 방식이 윈도우랑 맥이 다르다.
* pull 기본전략
	* git config pull.rebase (true/false)
		* true면 rebase, false면 merge
* git config --global init.defaultBranch 책정리.다재다능코틀린프로그래밍.codes.main
	* main을 기본 브랜치로 설정
* -u 옵션
	* 현재의 local branch를 remote의 어떤 브랜치와 연결할 지에 대한 옵션
	* (혹은 --set-upstream)
* 현재의 로컬 브랜치를 그냥 원격 브랜치에 적용하려고 할 때
	* git config --global push.default current
* 단축키 설정
	* git config --global alias.단축키 "명령어"
		* ex) git config --global alias.cam "commit -am"