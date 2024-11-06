# Clean Architecture Sample

## 프로젝트 소개

이 프로젝트는 Clean Architecture를 이해하고 적용하기 위한 샘플 코드입니다. 

기본적인 구조, API 통신, 의존성 주입(DI) 등의 사용 방법을 안내하기 위해 만들어졌습니다. 

이 샘플은 개발자들이 Clean Architecture의 개념을 쉽게 이해하고 실습할 수 있도록 돕기 위해 설계되었습니다.

### 주요 목표

- **모듈화**: 각 레이어의 책임을 명확히 하여 유지보수성을 높입니다.
- **테스트 용이성**: 각 레이어가 독립적으로 테스트 가능하도록 설계되었습니다.
- **확장성**: 새로운 기능 추가 시 기존 코드에 최소한의 영향을 미치도록 합니다.

## 아키텍처

이 프로젝트는 Clean Architecture의 기본적인 구조를 따릅니다. 주요 구성 요소는 다음과 같습니다:

* **Data Layer**: 데이터 소스와 관련된 모든 작업을 처리합니다.
* **Domain Layer**: 비즈니스 로직을 포함하며, 애플리케이션의 핵심 기능을 정의합니다.
* **Presentation Layer**: 사용자 인터페이스와 관련된 모든 작업을 처리합니다.

## Gradle 설정

Gradle에서의 공통된 코드를 최소화하고 관리의 용이성을 높이기 위해 Gradle을 공통화하였습니다. 

Modular Architecture에 작업한 Gradle의 형태의 이전 버전으로, dependencies에 대한 설정을 따로 관리하지 않는 형태입니다.

## 테스트 코드

두 가지 테스트 모두, 상세한 테스트 코드가 아닌 이러한 형태로 사용할 수 있다는 정도의 가이드입니다.

### Instrumented Test

Presentation Layer에서 Espresso를 사용하여 기본적인 테스트 코드를 작성해두었습니다.

### Lint Unit Test

Lint Unit Test도 간단하게 작성해두었으며, 추후에 확인하여 작업하기 위한 기본 베이스입니다.

각 Detector Class에 어떤 부분을 감지하는지에 대한 주석이 추가되어 있습니다. `@SuppressLint("Lint-ID")`를 통해 Lint를 무시할 수 있습니다.

## 코드 커버리지

코드 커버리지를 확인할 수 있도록 Jacoco 라이브러리를 추가하였습니다. Jacoco 사용 방법은 [블로그](https://heegs.tistory.com/131)에 작성되어 있습니다.

## Ktor

JetBrains에서 만든 Framework로, Kotlin을 사용하여 비동기 서버 및 클라이언트를 구축할 때 사용하는 오픈소스입니다. 
Ktor 사용 방법은 [블로그](https://heegs.tistory.com/133)에 작성되어 있습니다.

## RecyclerView Drag & Drop

RecyclerView의 Item을 Drag & Drop하여 순서를 쉽게 변경할 수 있는 기능이 구현되어 있습니다. 

기본적인 구조에 기본적인 기능만 구현하였기 때문에, 필요에 맞춰 별도의 Error Handling 작업이 필수적으로 들어가야 합니다.

RecyclerView Drag & Drop에 대한 설명은 [블로그](https://heegs.tistory.com/139)에 작성되어 있습니다.

## 주의사항

* 일부 예제(예: Permission 관련)는 기본 설정이 필요할 수 있습니다.
* Compose 버전 1.4.0-alpha04 이하에서는 키보드 관련 이슈가 있을 수 있습니다.

## 더 자세한 내용

각 예제에 대한 자세한 설명은 [Tistory Blog](https://heegs.tistory.com)에서 확인하실 수 있습니다.

## About

이 프로젝트는 Clean Architecture를 이해하고 적용하기 위한 샘플 코드입니다. 기본적인 구조, API 통신, 의존성 주입(DI) 등의 사용 방법을 안내하기 위해 만들어졌습니다.
