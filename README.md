# Clean Architecture Sample


## Architecture 
Clean Architecture를 스터디 하면서 Clean Architecture의 기본적인 구조를 만들어두었습니다.

기본적인 WebView에 대한 구조도 붙여두었으며, assets에 html파일을 선언하여 테스트했습니다.

## Gradle
Gradle에서의 공통된 코드르 최소화하고, 관리의 용의성을 높이기 위하여 Gradle을 공통화 하였습니다.

Modular Architecture에 작업한 Gradle의 형태의 이전 버전으로, dependencies에 대한 설정을 따로 관리하지 않는 형태입니다.

## Lint
여러가지 Custom Lint에 대한 조건을 작성하여 Module로 붙여두었습니다.

각 Detector Class에 어느 부분을 감지하는지에 대한 주석을 추가해두었습니다.

## DI
Koin으로 작업 되어있으며, 현재 Hilt로 Migration 작업 중에 있습니다. (06.13)

## Test Code
### Instrumented Test
Presentation Layer에서 Espresso를 사용하 기본적은 Test Code를 작성해두었습니다.

### Lint Unit Test
Lint Unit Test도 간단하게 작성을 해두었으며, 추후에 확인하여 작업하기 위한 기본 베이스 입니다.


**위의 두 가지 Test 모두, Detail한 Test Code가 아닌 이러한 형태로 사용할 수 있다 정도의 가이드입니다.**

## Blog
Clean Architecture에 대한 설명은 다음 블로그에 작성해 두었습니다.

[Tistory Blog](https://heegs.tistory.com/61?category=915533 "Clean Architecture Example")
