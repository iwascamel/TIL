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

## 5. 커밋 수정하기

* git commit --amend
	* 마지막 커밋 메세지 변경
* 만약 파일 하나를 추가하고 커밋을 하고 싶다면?
	* git add .
	* stage에 일단 올린다.
	* 그리고 git commit --amend로 마지막 커밋에 포함시키면 된다.
* git commit --amend -m 'Add members to Panthers and Pumas'
	* 한줄로는 위와 같이 변경할 수도 있다.