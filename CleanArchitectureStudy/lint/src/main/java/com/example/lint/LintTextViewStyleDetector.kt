package com.example.lint

import com.android.tools.lint.detector.api.Category.Companion.TYPOGRAPHY
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity.WARNING
import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Element
import java.util.*

/**
 * TextView에 대한 Lint 적용
 *
 * textAppearance속성이 존재하지 않으면, 해당 아이템 전체에 Warning 발생.
 */
class LintTextViewStyleDetector : ResourceXmlDetector() {

    companion object {
        private const val SCHEMA = "http://schemas.android.com/apk/res/android"
        private const val TEXTVIEW = "TextView"
        private const val CHECK_ATTRIBUTE = "textAppearance"

        private const val ID = "Lint-MissingTextAppearance"
        private const val DESCRIPTION = "textAppearance attribute is missing"
        private const val EXPLANATION =
            "We should use textAppearance to style a TextView in order to provide consistent design"
        private val CATEGORY = TYPOGRAPHY
        private const val PRIORITY = 4
        private val SEVERITY = WARNING
        private val IMPLEMENTATION = Implementation(
            LintTextViewStyleDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
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

    // Lint로 검출할 Resource
    override fun getApplicableElements(): Collection<String>? {
        return Collections.singletonList(TEXTVIEW)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        // 해당 스키마에서 찾고자 하는 룰이 없으면 실행된다.
        if (!element.hasAttributeNS(SCHEMA, CHECK_ATTRIBUTE)) {
            context.report(
                issue = ISSUE,
                location = context.getLocation(element),
                message = EXPLANATION
            )
        }
    }
}