package com.example.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

/**
 * Method 이름에 대한 Lint를 적용한다.
 *
 * 언더바 사용시 Error를 발생 시킨다.
 *
 * 언더바를 제거하고, Camel Case로 자동 수정을 진행한다.
 *
 */
class LintMethodNameDetector : Detector(), Detector.UastScanner {

    companion object {
        private const val ID = "Lint-MethodNameDetector"
        private const val DESCRIPTION = "Method name convention violation."
        private const val EXPLANATION =
            "This method name is against convention."
        private val CATEGORY = Category.CORRECTNESS
        private const val PRIORITY = 1
        private val SEVERITY = Severity.ERROR
        private val IMPLEMENTATION = Implementation(
            LintMethodNameDetector::class.java,
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
        // 모든 Method를 감지한다.
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitMethod(node: UMethod) {
                val methodName = node.name
                // 찾고자 하는 Method Name
                if (methodName.matches(Regex(".*_.*"))) {
                    val name = underBarChecker(methodName)
                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node),
                        EXPLANATION,
                        LintFix.create()
                            .replace()
                            .text(methodName)
                            .with(name)
                            .build()
                    )
                }
            }
        }
    }
}