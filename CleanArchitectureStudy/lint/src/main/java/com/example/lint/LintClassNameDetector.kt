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
                val length = className.length

                if (lengthChecker(node)) {
                    reportUsage(context,
                        node,
                        "Class Line is over 100 Characters.\n" +
                                "If you fix this Lint Error, Press Ctrl + Alt + L",
                        null)
                }

                if (className.matches(Regex(".*_.*"))) {
                    val name = underBarChecker(className)

                    reportUsage(context,
                        node,
                        "Perhaps, This code style requires not use UnderScore.\n" +
                                "You can modify it to $name",
                        fix(context, node))
                }

                if (Pattern.matches(lowerCase, className[0].toString())) {
                    val charCheck = className[0]
                    val name = className.replace("$charCheck", "${charCheck.uppercaseChar()}")

                    reportUsage(context,
                        node,
                        "Perhaps, This code style requires the first letter must be capitalized.\n" +
                                "You can modify it to $name",
                        null)
                }

                if (dtoPattern.matcher(className).find()
                    && className.substring(length - 3, length) != "Dto"
                    && className.substring(length - 3, length).equals("dto", true)
                ) {
                    val upperCase = changeDto(className, length)
                    reportUsage(context,
                        node,
                        "Perhaps, This code style requires *Dto.\n" +
                                "You can modify it to $upperCase",
                        null)
                }

                if (entityPattern.matcher(className).find()
                    && className.substring(length - 6, length) != "Entity"
                    && className.substring(length - 6, length).equals("Entity", true)
                ) {
                    val upperCase = changeEntity(className, length)

                    reportUsage(context,
                        node,
                        "Perhaps, This code style requires *Entity.\n" +
                                "You can modify it to $upperCase",
                        null)
                }

                if (className.matches(Regex("Entity.*")) || className.matches(Regex("Dto.*"))) {
                    context.report(
                        ISSUE,
                        node,
                        context.getLocation(node.javaPsi),
                        "Is this Class name you want? A should be written as Suffix",
                        null
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
        .with("@SuppressLint(\"$ID\")\n")
        .beginning()
        .shortenNames()
        .reformat(true)
        .range(context.getLocation(node as UElement))
        .build()

    private fun reportUsage(context: JavaContext, node: UClass, message: String, fix: LintFix?) {
        context.report(
            ISSUE,
            node,
            context.getLocation(node.javaPsi),
            message,
            fix
        )
    }

    private fun lengthChecker(node: UClass): Boolean {
        val lineChecker = node.javaPsi.toString().split("\n")
        var firstLine: String? = null

        for (index in lineChecker.indices) {
            if (lineChecker[index].contains("KtUltraLightClass:")) {
                firstLine = lineChecker[index].removeRange(0, 18)
                break
            }
        }

        return firstLine != null && firstLine.length > 99
    }
}