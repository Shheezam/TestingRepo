package ph.macadamia.game

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import ph.macadamia.game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemUI()

        var counterTile1 = 0
        var counterTile2 = 0
        var counterTile3 = 0
        var counterTile4 = 0
        var counterTile5 = 0


        binding.tile1.setOnClickListener {
            counterTile1++
            changeTile(binding.tile1, counterTile1 % 3)
        }

        binding.tile2.setOnClickListener {
            counterTile2++
            changeTile(binding.tile2, counterTile2 % 3)
        }
        binding.tile3.setOnClickListener {
            counterTile3++
            changeTile(binding.tile3, counterTile3 % 3)
        }
        binding.tile4.setOnClickListener {
            counterTile4++
            changeTile(binding.tile4, counterTile4 % 3)
        }
        binding.tile5.setOnClickListener {
            counterTile5++
            changeTile(binding.tile5, counterTile5 % 3)
        }


    }

    fun changeTile(tile: AppCompatButton, tileType : Int) {
        when (tileType) {
            0 -> tile.setBackgroundColor(Color.BLACK)
            1 -> tile.setBackgroundResource(R.drawable.square)
            2 -> tile.setBackgroundResource(R.drawable.triangle)


        }
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}