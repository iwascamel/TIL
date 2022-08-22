# 섹션3 - github

## 1. github이란

* github등의 온라인 git 저장소는 모든 업로드와 다운로드를 commit 단위로 주고받는다.

## 2. github repository 최초 생성시 명령어 분석

* git remote add origin
    * git에 원격 저장소(remote)를 추가한다.
    * origin
        * 원격 저장소의 이름
        * 바꿀 수 있으나, 바꾸지 않는게 권장된다.
* git branch -M main
    * 기본 브랜치명을 main으로 설정
* git push -u origin main
    * 어느 원격에다가(origin) , 그리고 어느 브랜치에다가(main) push할 지 설정한다.
    * -u
        * 기본으로 세팅해준다.
        * 혹은 --set-upstream
* git remote
    * 해당 명령어를 치면 원격 저장소의 이름들이 뜬다.

* download
    * zip으로 다운받으면 .git폴더는 존재하지 않는다.
    * .git폴더 및 commit 내역들을 다운받고 싶다면 git clone으로 다운받아야 한다.
	    * 이 때 사용하는 프로토콜은 https이다.

<img width="395" alt="image" src="https://user-images.githubusercontent.com/51740388/184540960-624f1e00-424c-434c-ba7a-609de304065e.png">

## 3. push 실습(rebase)

* 만약 github과 내 로컬의 commit이 충돌할 경우, 내 코드가 로컬 커밋보다 뒤쳐져있기 때문에 push가 안된다.
	* git pull을 한 뒤 push를 할 수 있다.
	* 이 때 2가지 방법을 사용할 수 있다.
		* git pull --no-rebase
			* rebase가 아니다 -> merge
		* git pull --rebase
			* rebase방식
			* 이 때의 rebase를 할 때, 공유된 것에 대해서 사용하지 말라고 했는데, 공유된 것에 대해서 하지 말라는 것이지 pull 할 때는 괜찮다.

<img width="760" alt="image" src="https://user-images.githubusercontent.com/51740388/184874340-99dd54d0-949c-4be8-aa27-896ab94f7e11.png">

* pull rebase를 하게 되면 main의 커밋을 origin보다 앞에 배치하게 해준다.
	* 즉, 원격거를 일단 붙이고, 그 다음에 내거를 잘라서 붙여주는 방식이다.

* 만약 rebase의 경우 accept theirs로 origin거를 받아들였다면

<img width="800" alt="image" src="https://user-images.githubusercontent.com/51740388/184875369-85c3c4ac-ee0b-414e-8945-2111d9e5a927.png">

* 위와 같이 main과 origin의 커밋이 같이 있게 된다.
	* 즉, 커밋이 추가되지 않게 된다.

#### 강제 push

* git push --force
	* 다른 사람 코드가 날라갈 수 있으므로, 협의된 것이 아니라면 사용하면 안된다.
	* 충돌 내역 이전으로 reset된다.

## 4. 원격의 branch 다루기

### 4-1) origin의 새로운 branch

* 새로운 branch를 생성한다.
	* 이 때 바로 push하려고 하면 git push --set-upstream origin (A(새로운 브랜치명)) 과 같이 뜬다.
	* 이 뜻은 내가 지금 생성한 브랜치를 어디에다가 push해야 할지를 모른다는 것이다.
		* 너가 지금 origin이라는 원격에 A라는 브랜치를 만들어서 하려는 것 같은데, 그러면 위와 같은 명령어를 명시해달라는 뜻이다.
	* 위 명령어는 git push -u origin A로 축약될 수 있다.
* git branch만 치면 local에 있는 branch만 보인다.
* 만약 origin의 branch들도 보려면 git branch -a(-all) 을 쳐야 한다.

### 4-2) origin의 브랜치 받아오기 : fetch

* git fetch
* 이후 git switch(checkout) -t origin/from-remote
	* -t 옵션
		* -u 옵션과 같이, from-remote를 가져와서 로컬에서도 from-remote라는 브랜치를 만들고 origin의 해당 브랜치와 연결해서 사용하겠다.

#### 원격 브랜치 삭제

* git push origin --delete (삭제하고자 하는 원격의 브랜치명)