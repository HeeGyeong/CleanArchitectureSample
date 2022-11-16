# Clean Architecture Sample

## Description
Clean Architecture 스터디를 위하여 작성한 Sample Code.

Clean Architecture 개념을 이해하 위하여 기본적인 구조, API 통신, DI 등의 기본적인 사용 방법을 가이드 하기 위하여 만들었습니다.

추가적으로 사용성이 높아보이는 라이브러리와 기능 등을 추가하여 쉽게 가져다 쓸 수 있는 레퍼런스로 사용하기 위해 샘플 프로젝트를 확장 중 입니다.

## Architecture 
Clean Architecture의 기본적인 구조.

Data, Domain, Presentation 구조이며, Lint 사용을 위하여 Lint 모듈도 추가해 두었으나 Clean Architecture 구조에서는 제외하고 보아도 무관합니다.

기본적인 WebView에 대한 구조도 붙여두었으며, assets에 html 파일을 선언하여 테스트했습니다.

## Gradle
Gradle에서의 공통된 코드를 최소화하고, 관리의 용의성을 높이기 위하여 Gradle을 공통화 하였습니다.

Modular Architecture에 작업한 Gradle의 형태의 이전 버전으로, dependencies에 대한 설정을 따로 관리하지 않는 형태입니다.

좀 더 확장된 Gradle 공통화 코드를 확인하고 싶은 경우, [Modular Architecture](https://github.com/HeeGyeong/ModuleArchitecture)에서 확인하면 됩니다.

2022.09. Library Version에 관련된 gradle 파일 추가

[Gradle 파일을 분리하는 방법](https://heegs.tistory.com/110)은 블로그에서 확인하면 됩니다.

## Blog
Clean Architecture에 대한 설명은 다음 블로그에 작성해 두었습니다.

[Tistory Blog](https://heegs.tistory.com/61?category=915533 "Clean Architecture Example")


# Utility

## Lint
여러가지 Custom Lint에 대한 조건을 작성하여 Module로 붙여두었습니다.

각 Detector Class에 어느 부분을 감지하는지에 대한 주석을 추가해두었습니다.

@SuppressLint("Lint-ID")를 통해 Lint를 무시할 수 있습니다.

## DI
Koin에서 Hilt로 마이그레이션 작업을 진행하였으며,

두 가지 DI의 사용 방법을 모두 확인할 수 있도록 Koin을 완전히 제거하지 않고 Application단에서 주석처리만 해두었습니다.

Koin은 Module, Hilt는 Hilt Package를 확인하면 됩니다.

## Test Code
**두 가지 Test 모두, Detail한 Test Code가 아닌 이러한 형태로 사용할 수 있다 정도의 가이드입니다.**


### Instrumented Test
Presentation Layer에서 Espresso를 사용하 기본적은 Test Code를 작성해두었습니다.

### Lint Unit Test
Lint Unit Test도 간단하게 작성을 해두었으며, 추후에 확인하여 작업하기 위한 기본 베이스 입니다.

## Android 12
Splash Screen 관련하여 확인할 수 있는 코드 추가.

## Code Coverage
Code Coverage를 확인할 수 있도록 Jacoco라이브러리를 추가하였습니다.

[Jacoco 사용 방법](https://heegs.tistory.com/131 "How to use Jacoco basics")은 블로그에 작성해 두었습니다.

## Ktor
JetBrains에서 만든 Framework로 Kotlin을 사용하여 비동기 서버 및 클라이언트를 구축할 때 사용하는 오픈소스 입니다.

[Ktor 사용 방법](https://heegs.tistory.com/133 "How to use Ktor")은 블로그에 작성해 두었습니다.

## RecyclerView Drag & Drop
RecyclerView의 Item을 Drag & Drop을 하여 순서를 쉽게 변경할 수 있는 기능을 구현 해두었습니다.

기본적인 구조에 기본적인 기능만 구현하였기 때문에, 필요에 맞춰 별도의 Error Handling 작업이 필수적으로 들어가야 합니다.

[RecyclerView Drag & Drop](https://heegs.tistory.com/139 "RecyclerView Drag & Drop")에 대한 설명은 블로그에 작성해 두었습니다.
