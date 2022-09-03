package dev.jorgecastillo.compose.app

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme
import org.junit.Rule
import org.junit.Test

/**
 * ### Exercise 7 👩🏾‍💻
 *
 * In this exercise we must create a Composable that uses BoxWithConstraints to display different
 *
 * To complete this exercise:
 *
 * 1. Use [Modifier.layout] to place the modified node (FloatingActionButton) at the corresponding
 *    corner given by its single argument. Remember to use [Pleaceable.placeRelative] in order to
 *    place the node (once measured) in x and y coordinates relative to its parent.
 *
 * 2. Run the test.
 */
class Exercise7Test {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(ComponentActivity::class.java)

    @Test
    fun composable_aligned_top_left() {
        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                Box(Modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .alignToCorner(Corner.TopLeft)
                            .testTag("FAB"),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Add),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag("FAB").assert(isAlignedToCorner(Corner.TopLeft))
        composeTestRule.onRoot().printToLog("Exercise 5")
    }
}
