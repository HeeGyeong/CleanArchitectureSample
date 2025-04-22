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
    
    // 현재 보이는 이미지뷰 (1 또는 2)
    private var currentVisibleImageView = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_view)
        
        setupUI()
        // 첫 이미지 로드
        loadImageToView(binding.ivImage1, imageList[currentImageIndex])
    }
    
    private fun setupUI() {
        binding.btnPrevious.setOnClickListener {
            showPreviousImage()
        }
        
        binding.btnNext.setOnClickListener {
            showNextImage()
        }
    }
    
    private fun loadImageToView(imageView: View, imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(imageView as android.widget.ImageView)
    }
    
    private fun showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--
            switchImageWithAnimation(false)
        }
    }
    
    private fun showNextImage() {
        if (currentImageIndex < imageList.size - 1) {
            currentImageIndex++
            switchImageWithAnimation(true)
        }
    }
    
    private fun switchImageWithAnimation(isNext: Boolean) {
        // 현재 보이는 이미지뷰와 숨겨진 이미지뷰를 결정
        val currentImageView = if (currentVisibleImageView == 1) binding.ivImage1 else binding.ivImage2
        val nextImageView = if (currentVisibleImageView == 1) binding.ivImage2 else binding.ivImage1
        
        // 미리 다음 이미지를 로드하고 준비
        loadImageToView(nextImageView, imageList[currentImageIndex])
        nextImageView.visibility = View.VISIBLE
        
        // 애니메이션 설정
        val slideOutAnimation = if (isNext) {
            AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
        } else {
            AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
        }
        
        val slideInAnimation = if (isNext) {
            AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        } else {
            AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        }
        
        // 현재 이미지 슬라이드 아웃
        currentImageView.startAnimation(slideOutAnimation)
        // 새 이미지 슬라이드 인
        nextImageView.startAnimation(slideInAnimation)
        
        // 애니메이션 종료 후 처리
        slideOutAnimation.setAnimationListener(object : AnimationEndListener() {
            override fun onAnimationEnd(p0: android.view.animation.Animation?) {
                // 이전 이미지뷰는 숨김
                currentImageView.visibility = View.INVISIBLE
            }
        })
        
        // 현재 보이는 이미지뷰 스위칭
        currentVisibleImageView = if (currentVisibleImageView == 1) 2 else 1
    }
    
    // 애니메이션 리스너를 간단히 구현하기 위한 추상 클래스
    private abstract class AnimationEndListener : android.view.animation.Animation.AnimationListener {
        override fun onAnimationStart(p0: android.view.animation.Animation?) {}
        override fun onAnimationRepeat(p0: android.view.animation.Animation?) {}
    }
} 