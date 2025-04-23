package com.example.cleanarchitecturestudy.view.example.blur

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityBlurSampleBinding

class BlurSampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlurSampleBinding
    private lateinit var adapter: BlurSampleAdapter
    private lateinit var glideRequestManager: RequestManager

    private val imageUrls = listOf(
        "https://images.unsplash.com/photo-1610878180933-123728745d22?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1575936123452-b67c3203c357?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1000&auto=format&fit=crop",
        "https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?q=80&w=1000&auto=format&fit=crop"
    )

    private var currentImageIndex = 0
    private var isImageChanging = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_blur_sample)
        
        // Glide 초기화
        glideRequestManager = Glide.with(this)
        
        setupRecyclerView()
        setupButton()
        
        // 초기 배경 이미지 로드
        loadBackgroundImage(imageUrls[currentImageIndex])
    }
    
    private fun setupRecyclerView() {
        adapter = BlurSampleAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        
        // 아이템 간 간격 설정
        binding.recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = 12
                outRect.bottom = 12
            }
        })
        
        // 40개의 아이템 생성
        val items = List(40) { index ->
            BlurSampleAdapter.BlurSampleItem(
                text1 = "항목 ${index + 1}의 첫 번째 줄",
                text2 = "항목 ${index + 1}의 두 번째 줄 설명입니다."
            )
        }
        
        adapter.setItems(items)
    }
    
    private fun setupButton() {
        binding.btnChangeImage.setOnClickListener {
            if (!isImageChanging) {
                changeBackgroundImage()
            }
        }
    }
    
    private fun changeBackgroundImage() {
        // 다음 이미지 인덱스 설정
        currentImageIndex = (currentImageIndex + 1) % imageUrls.size
        
        // 새 이미지 로드
        loadBackgroundImage(imageUrls[currentImageIndex])
    }
    
    private fun loadBackgroundImage(imageUrl: String) {
        isImageChanging = true
        
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
        
        glideRequestManager
            .load(imageUrl)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    isImageChanging = false
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    isImageChanging = false
                    return false
                }
            })
            .into(binding.ivBackground)
    }
} 