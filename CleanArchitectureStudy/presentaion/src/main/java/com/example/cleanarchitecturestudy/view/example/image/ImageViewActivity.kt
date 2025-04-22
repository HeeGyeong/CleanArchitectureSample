package com.example.cleanarchitecturestudy.view.example.image

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding
    private lateinit var glideRequestManager: RequestManager
    private val imageList = listOf(
        // 자연 풍경
        "https://images.unsplash.com/photo-1610878180933-123728745d22?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1575936123452-b67c3203c357?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1426604966848-d7adac402bff?q=80&w=1000&auto=format&fit=crop",
        
        // 도시 풍경
        "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1480714378408-67cf0d13bc1b?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1514565131-fce0801e5785?q=80&w=1000&auto=format&fit=crop",
        
        // 음식
        "https://images.unsplash.com/photo-1504674900247-0877df9cc836?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?q=80&w=1000&auto=format&fit=crop",
        
        // 동물
        "https://images.unsplash.com/photo-1546182990-dffeafbe841d?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1474511320723-9a56873867b5?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1437622368342-7a3d73a34c8f?q=80&w=1000&auto=format&fit=crop",
        
        // 건축물
        "https://images.unsplash.com/photo-1501084817091-a4f3d1d19e07?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1519999482648-25049ddd37b1?q=80&w=1000&auto=format&fit=crop",
        
        // 기술 및 디자인
        "https://images.unsplash.com/photo-1483478550801-ceba5fe50e8e?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1550745165-9bc0b252726f?q=80&w=1000&auto=format&fit=crop",
        
        // 여행
        "https://images.unsplash.com/photo-1530521954074-e64f6810b32d?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1528127269322-539801943592?q=80&w=1000&auto=format&fit=crop"
    )
    
    private var currentImageIndex = 0
    private var previousImageIndex = 0
    private var activeImageView = 1 // 1 또는 2로 현재 활성화된 이미지뷰 추적
    private var isImageSwitching = false // 이미지 전환 중인지 여부 (중복 클릭 방지)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_view)
        
        // Glide RequestManager 초기화 - 활동 생명주기에 연결
        glideRequestManager = Glide.with(this)
        
        setupUI()
        
        // 이미지뷰 배경 설정 (흰색 깜빡임 방지) - 검은색이나 어두운 색으로 설정
        val backgroundColor = ContextCompat.getColor(this, android.R.color.black)
        binding.ivImage1.setBackgroundColor(backgroundColor)
        binding.ivImage2.setBackgroundColor(backgroundColor)
        
        // 초기 상태 설정
        binding.ivImage1.visibility = View.VISIBLE
        binding.ivImage2.visibility = View.INVISIBLE
        
        // 첫 번째 이미지 로드 및 주변 이미지 미리 로드
        loadInitialImage()
        // preloadAdjacentImages(currentImageIndex) // 성능 테스트를 위해 주석 처리
    }
    
    private fun setupUI() {
        binding.btnPrevious.setOnClickListener {
            if (!isImageSwitching && currentImageIndex > 0) {
                showPreviousImage()
            }
        }
        
        binding.btnNext.setOnClickListener {
            if (!isImageSwitching && currentImageIndex < imageList.size - 1) {
                showNextImage()
            }
        }
    }
    
    /**
     * 주변 이미지들을 미리 로드합니다.
     * @param centerIndex 현재 보여지는 이미지 인덱스
     */
    private fun preloadAdjacentImages(centerIndex: Int) {
        // 성능 테스트를 위해 전체 함수 주석 처리
        /*
        // 앞의 이미지 미리 로드
        if (centerIndex > 0) {
            glideRequestManager
                .load(imageList[centerIndex - 1])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload()
        }
        
        // 뒤의 이미지 미리 로드
        if (centerIndex < imageList.size - 1) {
            glideRequestManager
                .load(imageList[centerIndex + 1])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload()
        }
        
        // 두 단계 앞의 이미지 미리 로드 (여유가 있다면)
        if (centerIndex > 1) {
            glideRequestManager
                .load(imageList[centerIndex - 2])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload()
        }
        
        // 두 단계 뒤의 이미지 미리 로드 (여유가 있다면)
        if (centerIndex < imageList.size - 2) {
            glideRequestManager
                .load(imageList[centerIndex + 2])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload()
        }
        */
    }
    
    private fun loadInitialImage() {
        // 첫 번째 이미지 로드 - placeholder와 error 이미지 설정
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .placeholder(ColorDrawable(ContextCompat.getColor(this, android.R.color.black)))
            .error(ColorDrawable(ContextCompat.getColor(this, android.R.color.black)))
            
        glideRequestManager
            .load(imageList[currentImageIndex])
            .apply(requestOptions)
            .into(binding.ivImage1)
            
        // 다음 이미지도 미리 로드해둠
        // 성능 테스트를 위해 주석 처리
        /*
        if (imageList.size > 1) {
            glideRequestManager
                .load(imageList[1])
                .apply(requestOptions)
                .into(binding.ivImage2)
        }
        */
    }
    
    private fun showPreviousImage() {
        if (currentImageIndex > 0) {
            previousImageIndex = currentImageIndex
            currentImageIndex--
            switchImages()
            // 이미지 전환 후 주변 이미지 미리 로드
            // preloadAdjacentImages(currentImageIndex) // 성능 테스트를 위해 주석 처리
        }
    }
    
    private fun showNextImage() {
        if (currentImageIndex < imageList.size - 1) {
            previousImageIndex = currentImageIndex
            currentImageIndex++
            switchImages()
            // 이미지 전환 후 주변 이미지 미리 로드
            // preloadAdjacentImages(currentImageIndex) // 성능 테스트를 위해 주석 처리
        }
    }
    
    private fun switchImages() {
        // 이미지 전환 상태 플래그 설정
        isImageSwitching = true
        
        // 현재 안 보이는 이미지뷰 선택
        val inactiveImageView = if (activeImageView == 1) binding.ivImage2 else binding.ivImage1
        val activeImageView = if (activeImageView == 1) binding.ivImage1 else binding.ivImage2
        
        // 새 이미지를 안 보이는 이미지뷰에 미리 로드 (리스너 추가)
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .placeholder(ColorDrawable(ContextCompat.getColor(this, android.R.color.black)))
            .error(ColorDrawable(ContextCompat.getColor(this, android.R.color.black)))
        
        glideRequestManager
            .load(imageList[currentImageIndex])
            .apply(requestOptions)
            // listener가 핵심 라인
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    // 이미지 로드 실패 시에도 플래그 해제
                    isImageSwitching = false
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    // 이미지가 완전히 로드된 후에만 이미지뷰 전환
                    activeImageView.visibility = View.INVISIBLE
                    inactiveImageView.visibility = View.VISIBLE

                    // 활성 이미지뷰 토글
                    this@ImageViewActivity.activeImageView = if (this@ImageViewActivity.activeImageView == 1) 2 else 1

                    // 이미지 전환 완료 플래그 해제
                    isImageSwitching = false
                    return false
                }
            })
            .into(inactiveImageView)
    }
} 