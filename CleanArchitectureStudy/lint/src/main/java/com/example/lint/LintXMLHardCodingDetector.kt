package com.example.lint

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Attr


/**
 * TextView의 text속성 값에 하드코딩 되어있는 경우 error 발생
 *
 * LintTextViewStyleDetector는 해당 아이템 전체에 Lint를 발생 시키는 반면,
 * LintXMLHardCodingDetector는 해당 속성 값에만 Lint를 발생 시킨다.
 */
class LintXMLHardCodingDetector : ResourceXmlDetector() {

    companion object {
        // use Detector Class
        private const val CHECK_ITEM = "TextView"
        private const val CHECK_ATTRIBUTE = "text"
        private const val PREFIX = "@string/"

        // Issue Attribute
        private const val ID = "Lint-NoUseHardCoding"
        private const val DESCRIPTION = "No Use HardCoding"
        private const val EXPLANATION =
            "We should use string XML file in TextView. Perhaps this one uses hardcoding strings"
        private val CATEGORY = Category.LINT
        private const val PRIORITY = 1
        private val SEVERITY = Severity.ERROR
        private val IMPLEMENTATION = Implementation(
            LintXMLHardCodingDetector::class.java,
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

    override fun getApplicableAttributes(): Collection<String> {
        return listOf(CHECK_ATTRIBUTE)
    }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        val content = attribute.value
        val parentItem = attribute.ownerElement.nodeName

        // Item에 대한 조건을 걸고 싶지 않으면 parentItem를 제거한다.
        if (!content.startsWith(PREFIX) && parentItem == CHECK_ITEM) {
            context.report(
                issue = ISSUE,
                location = context.getLocation(attribute),
                message = EXPLANATION
            )
        }
    }
}