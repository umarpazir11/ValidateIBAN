package com.test.validateiban

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.test.validateiban.base.BaseTest
import com.test.validateiban.ui.ibanbic.BicIbanViewModel
import com.test.validateiban.ui.routingcode.SearchRoutingCodeViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner::class)
class IBANUnitTest : BaseTest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Force tests to be executed synchronously

    // FOR DATA
    private lateinit var activity: FragmentActivity
    private lateinit var viewModel: SearchRoutingCodeViewModel

    @Before
    override fun setUp(){
        super.setUp()
        this.activity = Robolectric.setupActivity(FragmentActivity::class.java)
        this.viewModel = ViewModelProviders.of(this.activity, viewModelFactory)[SearchRoutingCodeViewModel::class.java]
    }

    @Test
    fun getIban_whenSuccess() {
        // Pre-test
        assertEquals(null, this.viewModel.bankData.value, "Result should be null because stream not started yet")
        // Execute View Model
        this.viewModel.fetchBics("70020270")
        // Checks
        assertNotEquals(0, this.viewModel.bankData.value?.size, "Result must not be 0")
        assertEquals(false, this.viewModel.isLoading.value, "Should be reset to 'false' because stream ended")
        assertEquals(null, this.viewModel.errorMessage.value, "No error must be founded")
    }
}