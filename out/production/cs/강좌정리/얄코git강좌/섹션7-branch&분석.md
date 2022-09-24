# 섹션 7 - branch & 분석

## 1. Fastforward vs 3-way-merge

<img width="800" alt="image" src="https://user-images.githubusercontent.com/51740388/188635383-0b8da432-777b-4e7c-9ecd-a992a698da9a.png">

### 1-1) Fast forward

* 두 브랜치가 공통 커밋을 조상으로 갖고 있는데, 한쪽 브랜치에만 이후의 커밋이 있을 때

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/188635678-ddac5bad-6964-497f-b0e9-284556bd4df9.png">

* 해당 상황에서 B -> A로 굳이 이 둘을 병합하기 위한 다른 커밋을 만들지 않고

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/188635904-ba072018-fbfd-40b5-adbd-f1b65f8c6941.png">

* 그냥 브랜치의 head만 A에서 B로 옮기는 것
	* 즉, 빨리감기를 해버린다고 생각하면 된다.
	* 이후 병합된 브랜치는 삭제한다.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/188636049-de4127d1-9865-49c4-9164-0b3b3da51cf8.png">

* 대신 fast forward의 단점은 어떤 브랜치를 사용했고, 언제 병합했는 지에 대한 기록이 남지 않게 된다는 것이다.
* 만약 병합 커밋을 만들어서 merge를 하려면

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/188636246-bd6f2e09-12fb-4b52-b367-404dfeba6ece.png">

* `git merge --no-ff (병합할 브랜치 명)` 을 입력해주면 된다.
	* ff = fast forward

### 1-2) 3-way-merge

<img width="600" alt="image" src="https://user-images.githubusercontent.com/51740388/188636591-fc10c79f-176f-455e-9ebc-080367344829.png">

* 그렇다면 위처럼 양쪽 브랜치 둘다 커밋된 마디가 하나 이상 있는 경우, 해당 commit들을 버리고 fast forward를 하면 안되니까 병합 커밋을 하나 만들 수 밖에 없다.
	* 그렇다면 해당 상황에서 왜 3-way-merge라고 하는가?
* git은 두 개의 커밋이 합쳐질 때 비교 대상이 필요하다.
	* B에서 변경된 건지, A에서 변경된 건지, 혹은 둘다에서 변경된건지 알 수 없다.
		* B와 A가 분기된 공통의 조상 commit, B, A 3개의 커밋을 보고 비교한다.
	* 차이가 있는 파일들마다 어떤 것을 병합에 반영하고, 어떤 것을 충돌로 인식해서 사용자에게 해결을 맡길 지 판단해야 한다.

## 2. Cherry-pick

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/188637545-6796c14b-f050-4084-92db-69032934c287.png">

<img width="260" alt="image" src="https://user-images.githubusercontent.com/51740388/188637712-c8cd76df-9154-4aab-8c94-89901488f6da.png">

* 예제 현 상황
	* 두 개는 같은 그림이다.
	* 그림상 root에서 다른 것들이 뻗어나오는 것처럼 보이는데, 이는 가장 긴 branch를 기준으로 GUI를 보여주기 때문인 것 같다.
	* source tree는 가장 최근에 있는 커밋을 쫙 펼쳐서 보여주는 형식이다.

<img width="257" alt="image" src="https://user-images.githubusercontent.com/51740388/188638387-efc0ea13-babc-4153-8149-2f87c4922443.png">

* Cherry를 git cherry-pick (Cherry의 커밋 아이디) 를 했을 때 생기는 그림
* cherry-pick은 merge, rebase와 달리 특정 커밋만 복제해서 가져온다.
	* 즉, main에서 생긴 Cherry와 이전의 Cherry는 별개의 commit이다.

## 3. 다른 가지의 잔 가지만 가져오기

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/188638988-d1e6147d-dc58-4a86-b5bd-9e6f78cce127.png">

* rebase --onto option을 사용한다.
	* 만약에 그냥 rebase를 사용하면 fruit, citrus 전체가 main으로 와질 것
	* 내가 원하는 것은 citrus브랜치만이다.
* git rebase --onto (A: 도착 브랜치) (B: 출발 브랜치) (C: 이동할 브랜치)
	* 나는 A에 있는 브랜치로 B브랜치에 있는 C브랜치를 옮겨 붙여 주겠다.
	* git rebase --onto 책정리.다재다능코틀린프로그래밍.codes.chap45.main fruit citrus

<img width="269" alt="image" src="https://user-images.githubusercontent.com/51740388/188639574-10720a55-6dea-4dc3-845c-2ed66d403783.png">

* 이제 책정리.다재다능코틀린프로그래밍.codes.chap45.main branch의 head를 cirtus의 Lime커밋으로 옮겨주자.
	* git swtich 책정리.다재다능코틀린프로그래밍.codes.chap45.main
	* git merge cirtus
		* 이러면 fast forward가 일어난다.

<img width="294" alt="image" src="https://user-images.githubusercontent.com/51740388/188639878-46632244-7530-480c-b985-f6fe7b826530.png">

## 4. 다른 가지의 마디들 하나로 뭉쳐서 가져오기

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/188640419-6f893496-5409-4640-af97-75b203666365.png">
<img width="288" alt="image" src="https://user-images.githubusercontent.com/51740388/188640554-1f8ac0f9-08e4-4c60-b32c-49b01df70627.png">

* 책정리.다재다능코틀린프로그래밍.codes.chap45.main 브랜치에서
	* git merge --squash root

<img width="453" alt="image" src="https://user-images.githubusercontent.com/51740388/188640722-0d872b16-1bf8-4e3f-b68f-5b832d823ccd.png">

* staged만 됐고, commit은 되지 않았다.
* git commit을 해보자.

<img width="489" alt="image" src="https://user-images.githubusercontent.com/51740388/188640961-dc5e1221-f65c-4b8a-8ff9-2a829974ce6a.png">

* :wq!

<img width="388" alt="image" src="https://user-images.githubusercontent.com/51740388/188641046-1b4f7ce2-76a4-49c5-924f-10d7ff056aa8.png">

* squashed 됐다는 커밋이 생겼다.

<img width="520" alt="image" src="https://user-images.githubusercontent.com/51740388/188641128-9cead97d-db04-464e-ae85-757c926d840c.png">

* 이 때, 중요한 거는 root 브랜치는 그대로 유지됐다는 것이다.

## 5. git flow

<img width="401" alt="image" src="https://user-images.githubusercontent.com/51740388/188641749-1f7b64f0-7af6-4925-9570-3f12bc78ab2a.png">

* 자세한 내용은 [해당사이트](https://nvie.com/posts/a-successful-git-branching-model/) 참조
