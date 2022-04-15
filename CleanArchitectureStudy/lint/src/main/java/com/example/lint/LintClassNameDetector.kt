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
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import java.util.regex.Pattern

/**
 * Class 이름에 대한 Lint를 적용한다.
 *
 * Error를 발생시키는 Lint 조건
 * 1. 언더바 사용
 * 2. 첫 글자 소문자 사용
 * 3. dto로 사용
 * 4. entity로 사용
 */
class LintClassNameDetector : Detector(), Detector.UastScanner {

    companion object {
        private const val ID = "Lint-ClassNameDetector"
        private const val DESCRIPTION = "Class name convention violation."
        private const val EXPLANATION =
            "This class name is against convention."
        private val CATEGORY = Category.CORRECTNESS
        private const val PRIORITY = 1
        private val SEVERITY = Severity.ERROR
        private val IMPLEMENTATION = Implementation(
            LintClassNameDetector::class.java,
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
        // 모든 Class를 감지한다.
        return listOf(UClass::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                val className = node.name ?: return

                if (className.matches(Regex(".*_.*"))) {
                    val name = underBarChecker(className)

                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node.javaPsi),
                        "Detect class name in underBar.. change > $name",
                        fix(context, node)
                    )
                }

                if (Pattern.matches(lowerCase, className[0].toString())) {
                    val charCheck = className[0]
                    val name = className.replace("$charCheck", "${charCheck.uppercaseChar()}")

                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node.javaPsi),
                        "Detect class name in lowerCase.. change > $name"
                    )
                }

                if (className.matches(Regex(".*dto"))) {
                    val upperCase = charUpperCase(className, className.length - 3)

                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node.javaPsi),
                        "Maybe, This code style requires *Dto. For example, $upperCase"
                    )
                }

                if (className.matches(Regex(".*entity"))) {
                    val upperCase = charUpperCase(className, className.length - 6)

                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node.javaPsi),
                        "Maybe, This code style requires *Entity. For example, $upperCase"
                    )
                }
            }
        }
    }

    fun fix(context: JavaContext, node: UClass): LintFix = LintFix.create()
        .replace()
//        .name("Add SuppressLint")
        .text("")
//        .pattern("Sample_Class(.*)")
        .with("@SuppressLint(\"Lint-ClassNameDetector\")\n")
        .beginning()
        .shortenNames()
        .reformat(true)
        .range(context.getLocation(node as UElement))
        .build()
}