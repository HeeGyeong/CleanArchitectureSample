package com.example.cleanarchitecturestudy.view.example.image

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding
    private val imageList = listOf(
        "https://images.unsplash.com/photo-1610878180933-123728745d22?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1575936123452-b67c3203c357?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1000&auto=format&fit=crop"
    )
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_view)
        
        setupUI()
        loadCurrentImage()
    }
    
    private fun setupUI() {
        binding.btnPrevious.setOnClickListener {
            showPreviousImage()
        }
        
        binding.btnNext.setOnClickListener {
            showNextImage()
        }
    }
    
    private fun loadCurrentImage() {
        Glide.with(this)
            .load(imageList[currentImageIndex])
            .centerCrop()
            .into(binding.ivImage)
    }
    
    private fun showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--
            animateImageSlide(false)
        }
    }
    
    private fun showNextImage() {
        if (currentImageIndex < imageList.size - 1) {
            currentImageIndex++
            animateImageSlide(true)
        }
    }
    
    private fun animateImageSlide(isNext: Boolean) {
        // 이미지가 사라지는 애니메이션
        val slideOutAnimation = if (isNext) {
            AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
        } else {
            AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
        }
        
        // 이미지가 나타나는 애니메이션
        val slideInAnimation = if (isNext) {
            AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        } else {
            AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        }
        
        slideOutAnimation.setAnimationListener(object : AnimationEndListener() {
            override fun onAnimationEnd(p0: android.view.animation.Animation?) {
                // 이미지가 사라진 후 새 이미지 로드
                binding.ivImage.visibility = View.INVISIBLE
                loadCurrentImage()
                
                // 새 이미지에 슬라이드 인 애니메이션 적용
                binding.ivImage.startAnimation(slideInAnimation)
                binding.ivImage.visibility = View.VISIBLE
            }
        })
        
        // 현재 이미지에 슬라이드 아웃 애니메이션 적용
        binding.ivImage.startAnimation(slideOutAnimation)
    }
    
    // 애니메이션 리스너를 간단히 구현하기 위한 추상 클래스
    private abstract class AnimationEndListener : android.view.animation.Animation.AnimationListener {
        override fun onAnimationStart(p0: android.view.animation.Animation?) {}
        override fun onAnimationRepeat(p0: android.view.animation.Animation?) {}
    }
} 