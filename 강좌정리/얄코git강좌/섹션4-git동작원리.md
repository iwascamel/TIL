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