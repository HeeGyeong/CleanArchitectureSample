package com.example.lint

import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity.ERROR
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

/**
 * Log에 대한 Lint
 *
 * android.util.Log의 메서드를 사용하는 경우 Error 발생
 */
class LintLogDetector : Detector(), SourceCodeScanner {

    companion object {
        private val IMPLEMENTATION = Implementation(
            LintLogDetector::class.java,
            Scope.JAVA_FILE_SCOPE
        )

        val ISSUE: Issue = Issue
            .create(
                id = "Lint-LogDetector",
                briefDescription = "The android Log should not be used",
                explanation = """
                This explanation is sample.
                we can write multi line explanation.
            """,
                category = CORRECTNESS,
                priority = 9,
                severity = ERROR,
                androidSpecific = true,
                implementation = IMPLEMENTATION
            )
    }

    override fun getApplicableMethodNames(): List<String> =
        listOf("v", "d", "i", "w", "e", "wtf")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        super.visitMethodCall(context, node, method)
        val evaluator = context.evaluator
        // 감지된 Method들이 util.Log의 Method일 경우에만 report 수행.
        if (evaluator.isMemberInClass(method, "android.util.Log")) {
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
            message = "android.util.Log usage is forbidden."
        )
    }
}