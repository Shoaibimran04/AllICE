package ca.georgiancollege.comp3025_w2024_week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import ca.georgiancollege.comp3025_w2024_week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private var resultLabelValue: String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeOnClickListeners()
    }

    private fun initializeOnClickListeners()
    {
        // operator buttons
        binding.mulitplyButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.divideButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.addButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.subtractButton.setOnClickListener { view -> processOperatorButtons(view) }

        // extra buttons
        binding.clearButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.percentButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.backspaceButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.plusMinusButton.setOnClickListener { view -> processExtraButtons(view) }

        // number buttons
        binding.zeroButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.oneButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.twoButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.threeButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.fourButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.fiveButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.sixButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.sevenButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.eightButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.nineButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.decimalButton.setOnClickListener { view -> processNumberButtons(view) }
    }

    private fun processOperatorButtons(view: View)
    {

    }

    private fun processExtraButtons(view: View)
    {

    }

    private fun processNumberButtons(view: View)
    {
        if(view.tag.toString() == ".")
        {
            if(!resultLabelValue.contains("."))
            {
                resultLabelValue += view.tag.toString()
            }
        }
        else
        {
            resultLabelValue += view.tag.toString()
        }
        binding.resultTextView.text = resultLabelValue
    }
}