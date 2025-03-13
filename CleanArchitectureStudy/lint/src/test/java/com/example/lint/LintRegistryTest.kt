package com.example.lint

//import com.android.tools.lint.client.api.LintClient
//import com.android.tools.lint.detector.api.CURRENT_API
//import com.android.tools.lint.detector.api.TextFormat
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test

//class LintRegistryTest {
//    var registry: LintIssueRegistry? = null
//
//    @Before
//    fun setUp() {
//        LintClient.clientName = "init LintClient Name"
//        registry = LintIssueRegistry()
//    }
//
//    @Test
//    fun checkUseApiVersion() {
//        val apiVersion = registry!!.api
//        assertEquals(apiVersion, CURRENT_API)
//    }
//
//    @Test
//    fun testNumberOfIssues() {
//        val size = registry!!.issues.size
//        assertEquals(size, 8)
//    }
//
//    @Test
//    fun testGetIssues() {
//        val issues = registry!!.issues
//        assertEquals(issues[0], LintLogDetector.ISSUE)
//    }
//
//    @Test
//    fun `check Issue ID - explanation`() {
//        val output = LintIssueRegistry().issues
//            .joinToString(separator = "\n") { "- ${it.id} - ${it.getExplanation(TextFormat.RAW)}" }
//
//        val issueId = LintIssueRegistry().issues[0].id
//
//        val issuesData = """
//- Lint-LogDetector - This explanation is sample.
//we can write multi line explanation.
//- IssueIdCheck - 린트의 설명 부분에 나오는 텍스트 입니다.
//- Lint-MissingTextAppearance - We should use textAppearance to style a TextView in order to provide consistent design
//- Lint-NoUseHardCoding - We should use string XML file in TextView. Perhaps this one uses hardcoding strings
//- Lint-CodeStringDetector - This is Code Convention Checker sample.
//- Lint-MethodNameDetector - This method name is against convention.
//- Lint-ClassNameDetector - This class name is against convention.
//- Lint-VariableDetector - This Variable name is against convention.
//        """.trimIndent()
//
//        assertEquals(issuesData, output)
//        assertEquals(issueId, "Lint-LogDetector")
//    }
//}