package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_random.*

class ExampleFragment : WolmoFragment<ExamplePresenter>() {

    override fun layout(): Int = R.layout.fragment_random

    override fun init() {
        vToolbar.title = "Product list"
    }
}
