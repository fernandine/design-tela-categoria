package br.com.jfapps.teste

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import br.com.jfapps.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mWidth: Int? = null
    private var mHeight: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val metrics = DisplayMetrics()
        val result = windowManager

        //VERIFICANDO A VERSÃO DO ANDROID
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            mWidth = result.currentWindowMetrics.bounds.width()
            mHeight = result.currentWindowMetrics.bounds.height()
        } else {
            result.defaultDisplay.getMetrics(metrics)
            mWidth = metrics.widthPixels
            mHeight = metrics.heightPixels
        }
        val imageLogo = binding.imageLogo
        val containerCategory = binding.containerCategories

        containerCategory.y = (mHeight!! * 0.56).toFloat()

        imageLogo.y = (mHeight!! * 0.25).toFloat()
        imageLogo.scaleX = (mHeight!! * 0.0006).toFloat()
        imageLogo.scaleY = (mHeight!! * 0.0006).toFloat()

        Handler(Looper.getMainLooper()).postDelayed({
            containerCategory.animate().duration = 500
            containerCategory.animate().yBy(-(mHeight!! * 0.56).toFloat())

            imageLogo.animate().duration = 500
            imageLogo.animate().yBy(-(mHeight!! * 0.25).toFloat())
            imageLogo.animate().scaleX((mHeight!! * 0.00046).toFloat())
            imageLogo.animate().scaleY((mHeight!! * 0.00046).toFloat())

        },2000)


    }
}