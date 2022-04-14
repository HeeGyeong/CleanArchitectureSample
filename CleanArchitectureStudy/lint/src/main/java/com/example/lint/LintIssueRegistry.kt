package com.example.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

class LintIssueRegistry : IssueRegistry() {

    // lint api 버전 설정
    override val api = CURRENT_API

    // 검사를 수행 할 이슈 등록
    override val issues =
        listOf(
            LintLogDetector.ISSUE, // Log 사용 금지
            LintContentViewDetector.ISSUE, // contentView 사용 금지
            LintTextViewStyleDetector.ISSUE, // textAppear 반드시 사용
            LintXMLHardCodingDetector.ISSUE, // hardCoding 금지
            LintCodeStringDetector.ISSUE, // lint Text 금지
            LintMethodNameDetector.ISSUE, // Method Name에 _ 금지
            LintClassNameDetector.ISSUE, // Class Name Convention
            LintVariableDetector.ISSUE
        )
}