package se.idoapps.kotlintestingdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import se.idoapps.kotlintestingdemo.R
import se.idoapps.kotlintestingdemo.common.app
import se.idoapps.kotlintestingdemo.viewmodel.ShowProfileViewModelInterface
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ShowProfileViewModelInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.app.appComponent.inject(this)

        setContentView(R.layout.activity_main)

        viewModel.loadProfile()

        textView.text = viewModel.currentProfile?.birthDate?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }
}
