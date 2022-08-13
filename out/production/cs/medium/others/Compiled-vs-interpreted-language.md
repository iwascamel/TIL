# Compiled vs interpreted language

## 1. begining

* 이분법적 x
  *  programming languages are not themselves compiled or interpreted and can be implemented with either a compiler or an interpreter. 
     *  프로그래밍 언어는 이분법적으로 컴파일만 사용하거나, 인터프리터 방식만 사용하지는 않는다.
        *  부분적으로는 컴파일, 인터프리터 방식을 사용한다.
        *  다만 편의적으로 이분법적으로 나눠보자.

* 진화단계
  * machine language -> interpreter -> high level language ( like c)

* assembler 내장
  * most modern computers com with assemblers built in
    * 현대의 컴퓨터들은 assembler들이 내장돼있다.

## 2. Compile language vs Interpreter language

### 2-1) compile - compile vs interpreter

* Compiled languages must be translated to machine-readable instructions before any code is executed
  * 컴파일 언어는 실행되기 이전에 반드시 기계어로 변환돼야 한다.
* Interpretered languages are programming languages for which instructions are not precompiled
  * 인터프리터 언어들은 지시어가 실행되기 이전에 pre-compiled 되지 않는다.
  * line-by-line으로 실행된다.
  * 인터프리터 언어들은 highly adaptable하지 않다.
    * 즉, 적응력이 뛰어나다.

### 2-2) compile vs interpreter 비교

| 항목            | compile | interpreter                                |
| ---------------| ------- | ------------------------------------------ |
| 속도            | 빠름    | 느림                                       |
| 실행전 추가시간    | 필요 o  | 필요 x                                     |
| 플랫폼 종속적      | o      | x: 인터프리터가 소스코드를 실행하기 때문에         |
| 유연성           | x       | more flexible                            |

### 2-3) disadvantage of compiler 

* However, when a programmer wants to update software written in a compiled language, the entire program needs to be edited, re-compiled, and re-launched.
  * 만약 software update가 일어난다면 재컴파일, 재실행이 필요로 된다.

## 3. Compiler vs Interpreter By Metaphor

* 음식을 만드는 상황이 있다는 과정
  * 컴파일 언어의 경우
    * 음식을 절차대로 다 만들었는데, 새로운 절차를 추가해야 된다면, 만들었던 음식은 다 새로 만들어야 한다.
  * 인터프리터 언어의 경우
    * line by line으로 실행되기 때문에 좀 더 유동적으로 instructions 추가/삭제시 유연한 부분이 존재한다.
  * apple pie
    * 만약 apple pie와 같이 오랜 기간동안 변하지 perfect recipe라면 compile 언어가 훨씬 낫지만, 그렇지 않다면 interpreter 언어가 낫다.

<hr/>

* [Compiled vs interpreted language](https://learningdaily.dev/compiled-vs-interpreted-language-basics-for-beginning-devs-ac1297667189)
* date
  * 22.07.15