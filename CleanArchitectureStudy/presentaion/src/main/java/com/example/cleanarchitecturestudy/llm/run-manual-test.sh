#!/bin/bash

# 25.04.28 기준 테스트 중 입니다.

# Cursor IDE LLM 모델 효율성 테스트 스크립트 (안드로이드 버전)
# 이 스크립트는 Cursor IDE에서 LLM 모델 테스트를 진행하기 위한 가이드입니다.

echo "===== Cursor IDE LLM 모델 효율성 테스트 (안드로이드 버전) ====="
echo "이 스크립트는 Cursor IDE에서 안드로이드 코드 생성을 위한 LLM 모델 테스트를 진행하기 위한 가이드입니다."
echo

# 모델 목록 출력
echo "테스트 가능한 모델:"
echo "1. Claude 3.7 Sonnet"
echo "2. Claude 3.7 Sonnet (Thinking)"
echo "3. GPT-4.1"
echo "4. Claude 3.5"
echo

# 테스트 유형 목록 출력
echo "테스트 유형:"
echo "1. 기본 코딩 능력 (Todo 앱 구현 - Jetpack Compose)"
echo "2. 버그 수정 (buggy-code.kt)"
echo "3. 리팩토링 (legacy-code.kt)"
echo "4. 문서화"
echo "5. 알고리즘 구현 (algorithm-test.kt)"
echo

# 사용자 입력 받기
read -p "테스트할 모델 번호를 선택하세요 (1-4): " model_choice
read -p "테스트 유형 번호를 선택하세요 (1-5): " test_choice

# 모델 설정 안내
echo
echo "===== 테스트 준비 ====="
echo "1. Cursor IDE를 실행하세요."
echo "2. 설정 > AI > 모델 선택에서 다음 모델을 선택하세요:"

case $model_choice in
  1) echo "   - Claude 3.7 Sonnet" ;;
  2) echo "   - Claude 3.7 Sonnet (Thinking)" ;;
  3) echo "   - GPT-4.1" ;;
  4) echo "   - Claude 3.5" ;;
  *) echo "   - 잘못된 선택입니다. 1-4 중에서 선택하세요." ; exit 1 ;;
esac

echo

# 선택한 테스트 유형에 따른 안내
echo "===== 테스트 실행 안내 ====="

case $test_choice in
  1)
    echo "기본 코딩 능력 테스트를 실행합니다."
    echo "프롬프트:"
    echo "Kotlin과 Jetpack Compose를 사용하여 다음 기능을 갖는 간단한 TODO 앱을 구현해주세요:"
    echo "1. TODO 항목 추가"
    echo "2. TODO 항목 삭제"
    echo "3. TODO 항목 완료 표시"
    echo "4. 필터링 기능 (전체/완료/미완료)"
    echo
    echo "상태 관리는 ViewModel과 StateFlow를 사용하고, 컴포넌트는 기능별로 분리해주세요."
    ;;
  2)
    echo "버그 수정 테스트를 실행합니다."
    echo "buggy-code.kt 파일을 열고 다음 프롬프트를 입력하세요:"
    echo "이 코드에 있는 모든 버그를 찾아 수정해주세요."
    ;;
  3)
    echo "리팩토링 테스트를 실행합니다."
    echo "legacy-code.kt 파일을 열고 다음 프롬프트를 입력하세요:"
    echo "이 레거시 코드를 현대적인 Kotlin 패턴을 사용하여 리팩토링해주세요."
    echo "- 클래스 기반 구조로 변경"
    echo "- var 대신 val 사용 (가능한 경우)"
    echo "- 반복문을 람다 및 고차 함수로 변경"
    echo "- 명시적 타입 선언 최소화"
    echo "- 전역 변수 사용 최소화"
    echo "- 관심사 분리 원칙 적용"
    echo "- 코루틴 활용"
    echo "- ViewBinding 또는 DataBinding 적용"
    ;;
  4)
    echo "문서화 테스트를 실행합니다."
    echo "legacy-code.kt나 algorithm-test.kt 파일을 열고 다음 프롬프트를 입력하세요:"
    echo "이 코드에 대한 KDoc 문서와 README.md 파일을 작성해주세요."
    echo "문서화는 다음 내용을 포함해야 합니다:"
    echo "- 각 함수의 목적과 매개변수 설명"
    echo "- 코드 사용 예시"
    echo "- 주요 로직 설명"
    echo "- 오류 처리 방법"
    ;;
  5)
    echo "알고리즘 구현 테스트를 실행합니다."
    echo "algorithm-test.kt 파일을 열고 다음 프롬프트를 입력하세요:"
    echo "이 파일의 비어있는 함수들을 가장 효율적인 방법으로 구현해주세요."
    echo "각 알고리즘의 시간 복잡도와 공간 복잡도를 주석으로 설명해주세요."
    ;;
  *)
    echo "잘못된 선택입니다. 1-5 중에서 선택하세요."
    exit 1
    ;;
esac

echo
echo "===== 결과 기록 안내 ====="
echo "테스트 결과를 다음 기준으로 평가하고 llm-test-plan.md의 표에 기록하세요:"
echo "- 응답 시간: 요청부터 응답까지 걸린 시간"
echo "- 코드 품질: 코드의 가독성, 효율성, 모범 사례 준수도"
echo "- 완성도: 요구사항을 얼마나 잘 충족했는지"
echo "- 정확성: 코드가 올바르게 작동하는지"
echo "- 토큰 사용량: 응답 생성에 사용된 토큰 수"
echo "- 비용: 해당 작업에 소요된 비용 (유료 사용자의 경우)"
echo
echo "테스트를 시작하려면 Cursor IDE에서 위의 프롬프트를 입력하세요."
echo "모든 테스트가 완료되면 결과를 llm-test-plan.md 파일에 기록하세요."
echo "===== 테스트 가이드 종료 =====" 