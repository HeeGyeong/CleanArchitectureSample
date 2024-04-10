package com.example.lint

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import org.junit.Test
import java.io.File

class CustomLintDetectorTest : LintDetectorTest() {

    override fun getDetector() = LintVariableDetector()

    override fun getIssues() = listOf(LintVariableDetector.ISSUE)

    @Test
    fun testSampleKotlinFile() {
        lint()
            .sdkHome(File("Your SDK Path"))
            .files(
                kotlin(
                    """
                    class TestClass {
                        fun checkMethod() {
                            val sampleTest = "123"
                        }
                    }
                    """
                ).indented()
            )
            .run()
            .expectClean()
    }
}