package ar.com.wolox.android.example.ui.viewpager.random

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_random.*
import javax.inject.Inject

class RandomFragment @Inject constructor() : WolmoFragment<RandomPresenter>(), IRandomView {

    override fun layout(): Int = R.layout.fragment_random

    override fun init() {
        vToolbar.title = getString(R.string.page_1_toolbar_title)
    }

    override fun setListeners() {
    }

    override fun setUsername(username: String) {
    }

    override fun onRandomNumberUpdate(someNumber: Int) {
    }
}
