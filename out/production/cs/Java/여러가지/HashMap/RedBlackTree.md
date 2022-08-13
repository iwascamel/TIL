# Red Black Tree

## Red Black Tree의 배경

### 균형이진트리

<img width="350" src="https://res.craft.do/user/full/a1071f7c-889c-0318-fab2-4aba6c1f6845/doc/D9E638B5-C704-4745-A2CB-8343590DBF0B/B9375ABD-ADB2-4F5B-8067-A533C652ECF9_2/Image.png">

이진트리에서는 위와 같은 극단값이 나올 수 있다.
Red Black Tree는 위와 같이 극단값을 방지하기 위한 이진트리이다.

> 즉 균형잡힌 트리를 만들기 위해서 <u>특정 조건</u>을 만들어준 이진트리

<img width="700" src="https://res.craft.do/user/full/a1071f7c-889c-0318-fab2-4aba6c1f6845/doc/D9E638B5-C704-4745-A2CB-8343590DBF0B/EE675076-E7BF-4EB4-9D1E-711C14C4EB41_2/Image.png">

아래와 같은 조건을 갖는다.

1. 모든 노드는 색깔을 가져야 한다 red/black
2. root는 반드시 black
3. leaf(none) → black
4. red node의 자식은 반드시 black
5. 각 노드에서 leaf node로 가는 경로가는 black 노드의 개수는 항상 같아야 한다.

<hr/>

* 출처
[자료구조 - 균형탐색이진트리 - Red-Black 트리](https://www.youtube.com/watch?v=SHdYv41iCmE)