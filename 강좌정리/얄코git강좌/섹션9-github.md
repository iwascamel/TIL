# 섹션 9 - github

## 1. Issue & Fork

### 1-1) Issue
<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/189519266-f056718f-b186-48c3-883c-546656803e52.png">

* labels
	* 해당 상태를 hash tag처럼 나타낸다.

<img width="501" alt="image" src="https://user-images.githubusercontent.com/51740388/189519295-88f31d07-0ec2-4019-9a9d-2d2319a714f4.png">

* milestones
	* 카테고리

### 1-2) Fork

* 다른 repository를 복사해오는 것

<img width="760" alt="image" src="https://user-images.githubusercontent.com/51740388/189519429-2f851304-f53d-45de-9a90-2e34af040f50.png">

* 만약 해당 소스에 기여하고 싶다면, fork를 따온 다음에 PR을 날리면 된다.

## 2. GPG key

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/189519688-a88864a9-9981-4092-a867-432d5f133c26.png">

* 커밋을 보면 특정 커밋에만 verified 가 붙어있는 것을 확인할 수 있다.
	* 해당 커밋들은 web에서 수정한 커밋들이다.
	* github입장에서는 web에서 직접 수정한 것이 회사 건물에 들어와서 수정을 한 느낌이라 verified를 준다.
* GPS키를 등록하면 모든 커밋에 verified가 뜨게 할 수 있다.
	* 변경 사항에 명령어에 -S 옵션을 주면 싸인이 돼서, verified가 뜬다.
		* git commit -S -m '메세지'
* 태그 역시 -s 옵션을 주면 verified를 할 수 있다.
	* git tag -s (태그명) (커밋해시) -m (메세지)


## 3. github CLI

* [github cli 설치](https://cli.github.com/)
* [가이드](https://cli.github.com/manual/)
* 로그인
	* gh auth (login/logout)
* repository 목록들 확인하기
	* gh repo list