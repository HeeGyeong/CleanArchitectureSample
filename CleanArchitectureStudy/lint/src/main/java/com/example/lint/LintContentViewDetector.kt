package com.example.lint

import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity.WARNING
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class LintContentViewDetector : Detector(), SourceCodeScanner {

    companion object {
        private val IMPLEMENTATION = Implementation(
            LintContentViewDetector::class.java,
            Scope.JAVA_FILE_SCOPE
        )

        val ISSUE: Issue = Issue
            .create(
                id = "IssueIdCheck",
                briefDescription = "요약된 설명 입니다.",
                explanation = "린트의 설명 부분에 나오는 텍스트 입니다.",
                category = CORRECTNESS, // lint Category에 맞춰서 작성
                priority = 5, // 우선 순위. 1 ~ 10 사이의 정수
                severity = WARNING, // Error의 경우 빨간 줄, Warning의 경우 노란색 라인으로 표기된다.
                implementation = IMPLEMENTATION // 해당 Detector가 수행 될 범위.
            )
    }

    // Lint로 검출할 Method Name을 List형태로 반환.
    override fun getApplicableMethodNames(): List<String> {
        return listOf("setContentView")
    }

    // getApplicableMethodNames()에서 작성한 함수명이 발견되면 호출.
    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        val evaluator = context.evaluator
        // databinding으로 사용하는 경우에는 lint 표시를 하지 않겠다.
        if (!evaluator.isMemberInClass(method, "androidx.databinding.DataBindingUtil")) {
            reportUsage(context, node)
        }
    }

    private fun reportUsage(context: JavaContext, node: UCallExpression) {
        context.report(
            issue = ISSUE,
            scope = node,
            location = context.getCallLocation(
                call = node,
                includeReceiver = true,
                includeArguments = true
            ),
            message = "마우스 오버 시 나오는 텍스트 입니다."
        )
    }

}