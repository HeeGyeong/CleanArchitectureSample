# Clean Architecture Sample

## 프로젝트 소개

이 프로젝트는 Clean Architecture를 이해하고 적용하기 위한 샘플 코드입니다. 

기본적인 구조, API 통신, 의존성 주입(DI) 등의 사용 방법을 안내하기 위해 만들어졌습니다. 

이 샘플은 개발자들이 Clean Architecture의 개념을 쉽게 이해하고 실습할 수 있도록 돕기 위해 설계되었습니다.

추가적으로, 실무에 사용될만한 다양한 예제들을 추가하고 있습니다.

- **최신 업데이트**
  - 2025.05: XML + Compose UI 예제 추가
  - 2025.04: XML UI 관련 예제 추가
  - 2025.04: 최신 버전 빌드 가능하도록 수정완료

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

- **변경 사항**
  - 2025.04: Lint의 경우 라이브러리 최신화를 하면서 주석처리 되었습니다. 

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


# 25.05 기준. 이하 내용은 테스트 중입니다. 참고용으로만 확인해주세요

# Cursor IDE LLM 모델 효율성 테스트

이 프로젝트는 Cursor IDE에서 사용 가능한 다양한 LLM 모델들의 안드로이드 코드 생성 성능을 비교 테스트하기 위한 도구입니다.

버그 수정 코드는 빌드를 위해 주석처리가 되어있습니다. 버그 수정 테스트를 하려면 해당 주석을 풀고 Cursor를 사용해주세요.

## 개요

Cursor IDE는 다양한 LLM 모델을 지원합니다. 이 테스트 도구를 사용하면 다음과 같은 모델들의 안드로이드 코드 생성 성능을 객관적으로 비교할 수 있습니다:

- Claude 3.7 Sonnet
- Claude 3.7 Sonnet (Thinking)
- GPT-4.1
- Claude 3.5
- 기타 모델

## 테스트 분야

다음 5가지 영역에서 각 모델의 성능을 테스트합니다:

1. **기본 코딩 능력**: 간단한 앱 구현 (예: Jetpack Compose Todo 앱)
2. **버그 수정**: 의도적으로 버그가 있는 코드 제공 후 수정 요청
3. **리팩토링**: 레거시 코드 리팩토링 요청
4. **문서화**: 코드 문서화 요청 (KDoc, README 작성)
5. **알고리즘 구현**: 복잡한 알고리즘 구현 요청

## 테스트 방법

### 수동 테스트 방법

1. Cursor IDE를 실행합니다.
2. 테스트하려는 모델을 선택합니다.
3. 테스트 유형에 맞는 프롬프트를 실행합니다.
4. 결과를 `llm-test-plan.md`에 있는 표에 직접 기록합니다.
5. 다른 모델로 동일한 프롬프트를 실행하고 결과를 비교합니다.

### 자동화 테스트 방법 (미구현)

현재 Cursor API를 직접 호출하는 자동화 테스트는 구현되어 있지 않습니다. 대신 실제 안드로이드 앱에서 생성된 코드를 테스트하는 방법은 다음과 같습니다:

1. 테스트용 안드로이드 프로젝트 생성
2. 생성된 코드를 프로젝트에 통합
3. 앱 빌드 및 실행
4. 결과 평가

## 파일 구조

- `llm-test-plan.md`: 테스트 계획 및 메트릭 설명
- `buggy-code.kt`: 버그 수정 테스트용 코드
- `legacy-code.kt`: 리팩토링 테스트용 코드
- `algorithm-test.kt`: 알고리즘 구현 테스트용 코드
- `run-manual-test.sh`: 수동 테스트 실행 스크립트
- `README.md`: 프로젝트 설명

## 테스트 프롬프트 예시

### 기본 코딩 능력 테스트

```
Kotlin과 Jetpack Compose를 사용하여 다음 기능을 갖는 간단한 TODO 앱을 구현해주세요:
1. TODO 항목 추가
2. TODO 항목 삭제
3. TODO 항목 완료 표시
4. 필터링 기능 (전체/완료/미완료)

상태 관리는 ViewModel과 StateFlow를 사용하고, 컴포넌트는 기능별로 분리해주세요.
```

### 버그 수정 테스트

```
buggy-code.kt 파일에는 여러 버그가 있습니다. 모든 버그를 찾아 수정해주세요.
```

### 리팩토링 테스트

```
legacy-code.kt 파일을 현대적인 Kotlin 패턴을 사용하여 리팩토링해주세요:
- 클래스 기반 구조로 변경
- var 대신 val 사용 (가능한 경우)
- 반복문을 람다 및 고차 함수로 변경
- 명시적 타입 선언 최소화
- 전역 변수 사용 최소화
- 관심사 분리 원칙 적용
- 코루틴 활용
- ViewBinding 또는 DataBinding 적용
```

### 문서화 테스트

```
이 코드에 대한 KDoc 문서와 README.md 파일을 작성해주세요.
문서화는 다음 내용을 포함해야 합니다:
- 각 함수의 목적과 매개변수 설명
- 코드 사용 예시
- 주요 로직 설명
- 오류 처리 방법
```

### 알고리즘 구현 테스트

```
algorithm-test.kt 파일의 비어있는 함수들을 가장 효율적인 방법으로 구현해주세요.
각 알고리즘의 시간 복잡도와 공간 복잡도를 주석으로 설명해주세요.
```

## 테스트 실행 방법

### 1. 스크립트 사용하기

제공된 스크립트를 사용하여 테스트를 실행할 수 있습니다:

```bash
chmod +x run-manual-test.sh
./run-manual-test.sh
```

스크립트가 테스트 유형과 모델 선택을 안내해 줍니다.

### 2. 테스트 계획 확인

`llm-test-plan.md` 파일을 열어 테스트 계획과 측정 메트릭을 확인합니다.

### 3. 결과 기록하기

각 테스트의 결과를 다음 기준으로 평가하고 기록합니다:

- **응답 시간**: 요청부터 응답까지 걸린 시간
- **코드 품질**: 코드의 가독성, 효율성, 모범 사례 준수도
- **완성도**: 요구사항을 얼마나 잘 충족했는지
- **정확성**: 코드가 올바르게 작동하는지
- **토큰 사용량**: 응답 생성에 사용된 토큰 수 (Cursor 대시보드에서 확인 가능)
- **비용**: 해당 작업에 소요된 비용 (유료 사용자의 경우)

## 안드로이드 프로젝트에서 생성된 코드 테스트하기

생성된 코드를 실제 안드로이드 프로젝트에서 테스트하려면:

1. Android Studio 또는 Cursor IDE에서 새 안드로이드 프로젝트를 생성합니다.
2. 필요한 의존성을 build.gradle 파일에 추가합니다:

```kotlin
// build.gradle.kts (app)
dependencies {
    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    
    // 코루틴
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    
    // 테스트
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
}
```

3. 생성된 코드를 프로젝트에 복사합니다.
4. 필요한 경우 import 문을 수정합니다.
5. 앱을 빌드하고 실행하여 코드가 제대로 작동하는지 확인합니다.

## 결과 분석

각 모델별 결과를 비교하여 다음을 분석할 수 있습니다:

1. 어떤 모델이 안드로이드 코드 생성에 가장 적합한지
2. 비용 대비 성능이 가장 좋은 모델은 무엇인지
3. 응답 시간과 코드 품질 간의 상관관계가 있는지
4. 안드로이드 개발 특성에 따라 어떤 모델을 선택해야 하는지

## 주의사항

- 테스트 결과는 프롬프트 작성 방식, Cursor IDE 버전, 기타 요인에 따라 달라질 수 있습니다.
- 각 모델은 지속적으로 업데이트되므로, 테스트 결과는 시간이 지남에 따라 변할 수 있습니다.
- 생성된 코드가 최신 안드로이드 API 및 라이브러리와 호환되는지 확인하세요.
- 비용은 사용자의 구독 플랜에 따라 달라질 수 있습니다.
