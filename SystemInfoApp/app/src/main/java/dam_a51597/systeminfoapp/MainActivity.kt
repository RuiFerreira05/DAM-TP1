package dam_a51597.systeminfoapp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val multilineText = findViewById<EditText>(R.id.MultiLineText)
        val systemInfo = buildString {
            append("Manufacturer: ${android.os.Build.MANUFACTURER}\n")
            append("Model: ${android.os.Build.MODEL}\n")
            append("Brand: ${android.os.Build.BRAND}\n")
            append("Type: ${android.os.Build.TYPE}\n")
            append("User: ${android.os.Build.USER}\n")
            append("Base: ${android.os.Build.VERSION_CODES.BASE}\n")
            append("Incremental: ${android.os.Build.VERSION.INCREMENTAL}\n")
            append("SDK: ${android.os.Build.VERSION.SDK_INT}\n")
            append("Version Code: ${android.os.Build.VERSION.RELEASE}\n")
            append("Display: ${android.os.Build.DISPLAY}\n")
        }

        multilineText.setText(systemInfo)

    }
}