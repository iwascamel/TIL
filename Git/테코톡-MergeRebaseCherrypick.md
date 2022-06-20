## 1. Merge?

> 두 branch를 합치는 것을 의미한다.

### 1-1) Fast-Forward

* 가르키고 있던 commit을 merge할 branch의 commit으로 이동하는 것을 의미한다.
  * Git은 현재 branch가 merge할 branch의 최신 정보를 모두 따라갈 때, fast-foward를 기본적으로 제공한다.

> A브랜치에 B브랜치를 merge할 때, B브랜치가 온전히 A브랜치 이후의 시점들만 가르키고 있다면, A브랜치는 B브랜치로 이동하기만 한다.

## 2. Rebase

* 합쳐지는 것은 merge와 동일하나, rebase는 깨끗한 commit 이력을 남긴다.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/174624804-185e7da9-ba63-4a63-b51d-562863cb6571.png">

<img width="700" alt="image" src="https://user-images.githubusercontent.com/51740388/174624987-7ddffbec-5bb2-4e0f-90d0-21d60277f0fd.png">

## 3. cherry-pick

다른 브랜치에 있는 커밋을 선택적으로 내 브랜치에 적용시키는 것

