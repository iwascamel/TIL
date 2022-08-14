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