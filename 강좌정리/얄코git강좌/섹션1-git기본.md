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

