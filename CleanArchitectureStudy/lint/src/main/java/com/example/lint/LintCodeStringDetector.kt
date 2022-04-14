package com.example.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Detector.UastScanner
import org.jetbrains.uast.UElement
import org.jetbrains.uast.ULiteralExpression
import org.jetbrains.uast.evaluateString

/**
 * Code에서 사용되는 Strig에 대한 Lint.
 *
 * 현재 임시로 작성해둔 부분으로, 필요에 따라 커스텀이 필요하다.
 *
 * lint 라는 텍스트 발견 시, Sample로 변경이 가능하다.
 */
class LintCodeStringDetector : Detector(), UastScanner {

    companion object {
        private const val ID = "Lint-CodeStringDetector"
        private const val DESCRIPTION = "No Use this String"
        private const val EXPLANATION =
            "This is Code Convention Checker sample."
        private val CATEGORY = Category.CORRECTNESS
        private const val PRIORITY = 1
        private val SEVERITY = Severity.WARNING
        private val IMPLEMENTATION = Implementation(
            LintCodeStringDetector::class.java,
            Scope.JAVA_FILE_SCOPE
        )

        val ISSUE: Issue = Issue
            .create(
                ID,
                DESCRIPTION,
                EXPLANATION,
                CATEGORY,
                PRIORITY,
                SEVERITY,
                IMPLEMENTATION
            )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement?>> {
        // 모든 문자열을 감지한다.
        return listOf(ULiteralExpression::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitLiteralExpression(node: ULiteralExpression) {

                if (findString(node.evaluateString())) {
                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node),
                        "Detect \"lint\" String. Change to Sample",
                        LintFix.create()
                            .replace()
                            .text("lint")
                            .with("Sample")
                            .build()
                    )
                }
            }
        }
    }

    private fun findString(string: String?): Boolean {

        return if (string == null) {
            false
        } else {
            string.contains("lint") && string.matches(Regex(".*\\blint\\b.*"))
        }
    }
}