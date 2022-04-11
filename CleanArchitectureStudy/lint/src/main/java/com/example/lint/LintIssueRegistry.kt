package com.example.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

class LintIssueRegistry : IssueRegistry() {

    // lint api 버전 설정
    override val api = CURRENT_API

    // 검사를 수행 할 이슈 등록
    override val issues =
        listOf(LintLogDetector.ISSUE,
            LintContentViewDetector.ISSUE,
            LintTextViewStyleDetector.ISSUE)
}