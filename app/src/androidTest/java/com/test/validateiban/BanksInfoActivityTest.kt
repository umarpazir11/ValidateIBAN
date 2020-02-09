package com.test.validateiban


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class BanksInfoActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(BanksInfoActivity::class.java)

    @Test
    fun banksInfoActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextRoutingCode),
                childAtPosition(
                    allOf(
                        withId(R.id.main),
                        withParent(withId(R.id.view_pager))
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("70020270"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.btnSearch), withText("Find"),
                childAtPosition(
                    allOf(
                        withId(R.id.main),
                        withParent(withId(R.id.view_pager))
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())


        val tabView = onView(
            allOf(
                withContentDescription("IBAN/BIC"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabs),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editText),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(longClick())


        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editText),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("DE89370400440532013000"), closeSoftKeyboard())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.btnValidate), withText("Validate"),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val tabView2 = onView(
            allOf(
                withContentDescription("PostCode"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabs),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        tabView2.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.editTextPostCode),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.editTextPostCode),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("01445"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.editTextCountryCode),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("DE"), closeSoftKeyboard())



        val appCompatButton3 = onView(
            allOf(
                withId(R.id.btnValidate), withText("Validate"),
                childAtPosition(
                    withParent(withId(R.id.view_pager)),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
