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
import org.jetbrains.uast.UVariable

/**
 * 변수 이름에 대한 Lint를 적용한다.
 *
 * Error를 발생시키는 Lint 조건
 * 1. 언더바 사용 시 전체 대문자가 아닌 경우
 *      전체 대문자로 변경한다.
 * 2. dto로 사용 시
 *      Dto로 변경한다.
 * 3. entity로 사용 시
 *      Entity로 변경한다.
 */
class LintVariableDetector : Detector(), Detector.UastScanner {

    companion object {
        private const val ID = "Lint-VariableDetector"
        private const val DESCRIPTION = "Variable name convention violation."
        private const val EXPLANATION =
            "This Variable name is against convention."
        private val CATEGORY = Category.CORRECTNESS
        private const val PRIORITY = 1
        private val SEVERITY = Severity.ERROR
        private val IMPLEMENTATION = Implementation(
            LintVariableDetector::class.java,
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
        // 모든 변수를 감지한다.
        return listOf(UVariable::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {

            override fun visitVariable(node: UVariable) {
                val name = node.name ?: return

                if (name.matches(Regex(".*_.*")) && name.indexOf('_') != 0) {
                    val upperCase = name.replaceRange(0, name.length, name.uppercase())
                    if (name != upperCase) {
                        context.report(
                            ISSUE,
                            node as UElement,
                            context.getNameLocation(node),
                            "Maybe, This code style requires all caps. For example, $upperCase",
                            LintFix.create()
                                .replace()
                                .text(name)
                                .with(upperCase)
                                .build()
                        )
                    }
                }

                if (name.matches(Regex(".*dto"))) {
                    val upperCase = charUpperCase(name, name.length - 3)
                    context.report(
                        ISSUE,
                        node as UElement,
                        context.getNameLocation(node),
                        "Maybe, This code style requires *Dto. For example, $upperCase",
                        LintFix.create()
                            .replace()
                            .text(name)
                            .with(upperCase)
                            .build()
                    )
                }

                if (name.matches(Regex(".*entity"))) {
                    val upperCase = charUpperCase(name, name.length - 6)
                    context.report(
                        ISSUE,
                        node as UElement,
                        context.getNameLocation(node),
                        "Maybe, This code style requires *Entity. For example, $upperCase",
                        LintFix.create()
                            .replace()
                            .text(name)
                            .with(upperCase)
                            .build()
                    )
                }
            }
        }
    }
}