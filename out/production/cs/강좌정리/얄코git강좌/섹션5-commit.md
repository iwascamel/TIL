# 섹션 5 - 프로답게 커밋하기

## 1. 커밋메세지

* 한 단위 작업은 커밋 하나에 담기는게 좋다.
  * 내용 파악 가능한 메세지와 함께
  * 합의된 방식을 잘 준수해서 일관된 형태의 커밋을 작성해나가는 것이 중요하다.

* 널리 사용되는 커밋 메세지 작성 방식

```
type: subject

body (optional)
~

footer (optional)
```

* ex)

```
feat: 압축파일 미리보기 기능 추가

사용자의 편의를 위해 압축을 풀기 전에
다음과 같이 압축파일 미리보기를 할 수 있도록 함
 - 마우스 오른쪽 클릭
 - 윈도우 탐색기 또는 맥 파인더의 미리보기 창

Closes #125
```

| type     | description                                     |
| -------- | ----------------------------------------------- |
| feat     | 새로운 기능 추가                                |
| fix      | 버그 수정                                       |
| docs     | 문서 수정                                       |
| style    | 공백, 세미콜론 등 스타일 수정                   |
| refactor | 코드 리팩토링                                   |
| perf     | 성능 개선                                       |
| test     | 테스트 추가                                     |
| chore    | 빌드 과정 또는 보조 기능(문서 생성기능 등) 수정 |

## 2. staging & commit

* git add . 식이 아니라, hunk별로 진행하고 싶다면, 
	* git add -p
		* p는 patch의 약자이다.
	* 같은 파일에 담긴 commit도 분할돼서 작성하고 싶을 때 사용한다.

<img width="356" alt="image" src="https://user-images.githubusercontent.com/51740388/185933763-423095e7-c64c-408d-98c3-29cda26965ee.png">

* 위와 같이 분기별로 보고 싶다.
	* 이 때, 여러 알파벳이 뜨는 데 ?를 입력하면 도움말을 보여준다.
* y: yes // n: no // q:quit 만 알아도 충분하다.
* 내가 바꾼 부분 하나의 단위를 hunk라고 한다.
* git commit -v
	* 변경사항 확인하고 커밋하기
		* git diff --staged + git commit
* git diff --staged
	* 이번 커밋에 담긴 변경사항들을 볼 수 있다.

## 3. stash

* 현업에서는 현재 커밋을 수정하다가, 급히 다른 파일을 수정할 일이 생긴다.
	* 그러나 작업하던 도중 커밋하는 것은 좋지않다.
* 이 때, 급하게 치워둘 수 있는 기능인 stash가 있다.
* git stash pop
	* stash에서 작업한 것을 꺼낸다.
* 즉, commit이 되기 이전의 add 파일들을 저장 및 되돌리기를 할 수 있다.
* 역시 -p 옵션을 활용해서 stash를 진행할 수 있다.
	* git stash -p
* 메세지와 함께 할 수도 있다.
	* git stash -m 'add stash3'

<img width="386" alt="image" src="https://user-images.githubusercontent.com/51740388/185936315-9f21ade9-e634-42ce-9a49-deccb73eca1a.png">

* stash를 하게 되면, `*2` 와 같이 git 에서 표시해준다.

<img width="258" alt="image" src="https://user-images.githubusercontent.com/51740388/185936348-88ac18b6-7eca-4dd2-8a6a-d38b9b4a54f5.png">

* git stash list를 하게 되면 해당 stash들의 list를 보여준다.
	* git stash apply stash@{1}
* 1번 stash 파일이 돌아오게 된다.
* 그러나 아직 stash 목록들은 남아있다.
* git stash drop stash@{1}
* pop을 하게 되면 apply와 drop이 한꺼번에 된다.
	* 이 때, stack처럼 최근항목부터 가져오낟.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/185937002-a6214266-2690-4293-b740-58120d2e00a5.png">

* git stash branch (브랜치명)
	* 새로 생성한 브랜치에 pop을 한다.

## 5. 커밋 수정하기 : rebase -i

* git commit --amend
	* 마지막 커밋 메세지 변경
* 만약 파일 하나를 추가하고 커밋을 하고 싶다면?
	* git add .
	* stage에 일단 올린다.
	* 그리고 git commit --amend로 마지막 커밋에 포함시키면 된다.
* git commit --amend -m 'Add members to Panthers and Pumas'
	* 한줄로는 위와 같이 변경할 수도 있다.

## 6. 과거의 커밋 수정 및 병합하기

### 6-1) 문제 상황

<img width="416" alt="image" src="https://user-images.githubusercontent.com/51740388/188310693-461bcf44-f9d7-4e26-83e0-a8bd87810520.png">

* 현재 상황
	* 횻홍
		* 커밋이름 다시 입력해줘야 한다.
	* 뻘짓
		* 해당 커밋은 지우고 싶다.
	* 결전~ 커밋들
		* 두 개 커밋을 합치고 싶다.

### 6-2) git rebase -i : 커밋 내역 수정

* git rebase -i
	* 수정이 필요한 대상 **바로 이전** 커밋을 해준다. 
	* 예를 들어, `횻홍`을 수정해줄 거면 `주인공 필살기 궁둥의 권` 추가 의 commit으로 rebase -i를 해준다.

<img width="505" alt="image" src="https://user-images.githubusercontent.com/51740388/188310778-5994639d-7cfc-40e6-89dd-62f69acaaaac.png">

<img width="580" alt="image" src="https://user-images.githubusercontent.com/51740388/188310870-4adfdc4c-29c9-4336-91f3-319ad128e75f.png">

* 그러면 위와 같은 화면이 뜨게 된다.
* 해당 pick을 어떻게 수정하고, 저장하느냐에 따라서 각 commit에 대해서 뭘 할지를 지정하는 것이다.

<img width="249" alt="image" src="https://user-images.githubusercontent.com/51740388/188310907-e55efaa9-c547-414d-9d4b-1c4a9bb9b930.png">

* squash
	* 이전 커밋에가 아니라, 이전 커밋과 합치기가 좀 더 정확한 말 같다.

* 횻홍만 `r 1c799ad 횻홍` r로 바꿔보자.
	* 그리고 :wq!

<img width="573" alt="image" src="https://user-images.githubusercontent.com/51740388/188310965-350d76c7-9954-4c4c-b4ce-2c2a141d09b0.png">

* 그러면 위와 같은 화면이 뜨게 된다.
	* 해당 commit내용을 버그수정으로 바꿔주자.

<img width="338" alt="image" src="https://user-images.githubusercontent.com/51740388/188310981-1285330a-e41f-4829-ba78-78f0b8269d6e.png">

### 6-3) git rebase -i : 커밋 삭제, 커밋 합치기

* 이제 버그수정 다음 것부터 수정할거니까, 해당 버그수정 commit을 가져오자.

<img width="374" alt="image" src="https://user-images.githubusercontent.com/51740388/188311139-577f2218-1f3c-459b-9f6c-920d3c4a2680.png">

* 순서가 위에서 아래로 내려올수록 최신순이다.

<img width="509" alt="image" src="https://user-images.githubusercontent.com/51740388/188311167-a7567ebd-a335-4362-bdd8-6bfacbf99704.png">

* 두개의 커밋을 합칠 때 위와 같이 뜬다.

<img width="353" alt="image" src="https://user-images.githubusercontent.com/51740388/188311233-ec33c0c5-1ae3-4c7a-804d-dacac2ee76ea.png">

### 6-4) git rebase -i : 하나의 커밋 두 개로 분기하기

* 캐릭터 귤맨 추가, 시작메뉴 디자인 변경같은 경우 2개의 커밋이 하나의 커밋에 들어가있다.

<img width="710" alt="image" src="https://user-images.githubusercontent.com/51740388/188311307-49f91742-7e89-4e6b-bebd-c38ab321d59f.png">

* file3에는 귤맨 추가, file4에는 시작메뉴 디자인 변경이 일어났으므로 2개의 커밋을 쪼갤 것이다.

<img width="365" alt="image" src="https://user-images.githubusercontent.com/51740388/188311351-8d8d9fbd-794b-499b-bf8f-40d8b3fa033e.png">

* 결전의 찜질방 맵 추가 commit으로 rebase -i를 준다. 그리고, 캐릭터 귤맨 추가, 시작 메뉴 디자인 변경에 대한 옵션을 e를 준다.

<img width="571" alt="image" src="https://user-images.githubusercontent.com/51740388/188311431-b1841bbf-b276-44a0-857f-2005243ee48f.png">

* 해당 커밋이 더해지기 전 커밋으로 가기위해 git reset head^를 주자.

<img width="658" alt="image" src="https://user-images.githubusercontent.com/51740388/188311478-568a81cf-db75-405e-befd-fb366a9f0aa8.png">

* 그리고 해당 commit들을 따로따로 더해준 뒤, rebase --continue를 해준다.

<img width="313" alt="image" src="https://user-images.githubusercontent.com/51740388/188311495-908269ee-b80d-49dc-99e3-1d6e9336b26a.png">

* 따로따로 더해진 것을 확인할 수 있다.

### 6-5) rebase인 이유?

* 만약 이전 커밋에서 변경사항이 발생하면, 다음 커밋은 더 이상 해당 커밋과 같은 것이 아니게 된다.
* 그러므로 git에서 과거의 어떤 내역을 수정하기 위해서는 해당 시점까지를 딱 자른 다음에, 해당 시점부터 이후까지를 다시 작성해주는 새로운 branch를 생성한 다음에 해당 브랜치에 rebase로 갖다 붙이는 식으로 동작한다.
