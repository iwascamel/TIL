# 섹션1 - git 기본

## 1. 기본 명령어들

### 1-1) git status

* add 안되면 tracking안된 파일들이 출력된다.

### 1-2) .gitignore

* 해당 파일에 파일명을 추가해주면 바로 tracking을 하지 않는다. (add하지 않아도 추적하지 않는다.)

```
# 이렇게 #를 사용해서 주석

# 모든 file.c
file.c

# 최상위 폴더의 file.c
/file.c

# 모든 .c 확장자 파일
*.c

# .c 확장자지만 무시하지 않을 파일
!not_ignore_this.c

# logs란 이름의 파일 또는 폴더와 그 내용들
logs

# logs란 이름의 폴더와 그 내용들
logs/

# logs 폴더 바로 안의 debug.log와 .c 파일들
logs/debug.log
logs/*.c

# logs 폴더 바로 안, 또는 그 안의 다른 폴더(들) 안의 debug.log
logs/**/debug.log
```

## 2. add commit

* git commit 누르면 vim으로 들어간다.
* git log
  * commit 메세지 목록들을 볼 수 있다.
* vim에서 j는 아래로 스크롤, k는 위로

* git commit -am "메세지"
  * add commit 한번에
  * 새로 추가된(untracked) 파일이 없을 때만 가능

## 3. Reset, Revert

### 3-1) Reset
* 과거의 값을 아예 지워버린다.
<img width="300" alt="image" src="https://user-images.githubusercontent.com/51740388/184501554-c80f4d24-aaa0-41a5-85cf-6e06f4907952.png">

### 3-2) Revert
* 반대의 값을 수행하는 캡슐을 묻어놓는 개념이다.
	* 협업시 한번 공유가 된 코드들에 대해서 코드를 되돌릴려면 무조건 revert를 사용해야 한다.
<img width="300" alt="image" src="https://user-images.githubusercontent.com/51740388/184501578-bbbe0c7b-f979-402e-88de-9755bda126a0.png">

* 만약 과거 시점의 한 코드만 수정하고 싶다면, revert를 사용하면 좋다.
<img width="400" alt="image" src="https://user-images.githubusercontent.com/51740388/184501615-f752b8fe-505b-4c4c-8345-f47f350e1380.png">

### 3-3) revert 실습
* .git 파일 백업해두기
	* command + shift + . 하면 숨김파일 볼 수 있다.

#### reset
* git reset --hard (돌아갈 커밋 메세지 한 6자정도까지)
* git reset --hard
	* 뒤에 커밋메세지가 없다면 마지막 커밋을 head로 가르킨다.

#### revert
* git revert (커밋메시지)
* revert를 하면 아래와 같이 메세지가 생성된다.
	* 특별한 경우가 아니면 해당 메세지를 손 볼 이유는 없다.
```
Revert "Add George to Tigers"

This reverts commit 176c010a51fb8991a13e66f3d17b27b5a90da51e.
```

* source tree로 보면 commit 메세지를 반대로 실행하는 커밋이 하나 생성된 것을 볼 수 있다.
<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184501956-335feafc-da7f-4575-85d5-f607895b536a.png">
<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184501995-6f0a3427-cc52-4f4e-bafa-4c8432c4638f.png">
<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184502001-55750ee9-5781-4ef8-8f2e-e92d543aca8f.png">
* 두 커밋 내역을 비교해보면, revert에서 원래 commit에 추가된 내용을 반대로 실행하는 것을 볼 수 있다.

### 3-4) revert 충돌

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184502100-0d03fd29-c88e-4e83-b204-a6bdcdd8a193.png">
* replace lions with lepards로 돌아가려 한다고 해보자.
	* leopards는 추가, lions는 삭제, tigers는 수정됐다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/184502141-96ef5bfa-f36f-47cb-bb31-7199fde57d02.png">
* 해당 커밋(replace lions with lepards)보다 상위 커밋인 replace cheetas with panthers에서 leopards를 수정했다.
	* 고로 충돌이 생긴다.

<img width="650" alt="image" src="https://user-images.githubusercontent.com/51740388/184502198-0fa04806-1df1-4284-9803-16bf8415e829.png">

* 일단 예제에서는 그냥 해당 leopards를 삭제해준다.
	* git rm leopards.yaml
* 그러고 git revert --continue를 해주자.
* revert에 revert가 반복되면 커밋 메세지가 더러워진다.
	* 예제에서는 일단 revert 전으로 reset해준다.

### 3-5) commit하지 않고 revert하기
* git revert --no-commit (되돌릴 커밋 해시)
	* revert를 하면 자동으로 commit이 생성되는데, 위 명령어를 이동하면 commit이 되지 않으므로 어떤 변화를 수행하고 같이 commit을 하려고 할 때 위 명령어를 활용하면 된다.
	* 취소하려면 git reset --hard 을 하면 된다.