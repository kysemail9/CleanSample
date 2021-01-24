package com.kys.daggerhiltclean

import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.kys.daggerhiltclean.di.ProductionModule
import com.kys.daggerhiltclean.framework.presentation.MainActivity
import com.kys.daggerhiltclean.framework.presentation.MainFragment
import com.kys.daggerhiltclean.framework.presentation.MainFragmentFactory
import com.kys.daggerhiltclean.util.launchFragmentInHiltContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@UninstallModules(ProductionModule::class)
@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun hiltTest(){
        assertThat(someString, containsString("TEST string"))
    }

    @Test
    fun mainFragmentTest(){
        val scenario = launchFragmentInHiltContainer<MainFragment>(
            factory = fragmentFactory
            // Note : need to provide NavController to make this test case work.
        )
    }

    @Test
    fun mainActivityTest(){
        val scenario = launchActivity<MainActivity>(
        )
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    object ProductionModule {
        @Singleton
        @Provides
        fun provideString(): String{
            return "This is a TEST string I'm providing for injection"
        }
    }
}
























