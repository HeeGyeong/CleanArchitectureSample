package com.example.cleanarchitecturestudy.view.rank

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturestudy.base.BaseViewModel
import com.example.domain.model.Ranking
import com.example.domain.usecase.rank.ChangeCategoryUseCase
import com.example.domain.usecase.rank.ChangeOptionUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class RankViewModel(
    private val changeCategoryUseCase: ChangeCategoryUseCase
) : BaseViewModel() {

    private val _rankingList = MutableLiveData<MutableList<Ranking>>()
    val rankingList: LiveData<MutableList<Ranking>> get() = _rankingList

    fun requestRank() {
        Thread {
            compositeDisposable.add(
                changeCategoryUseCase.execute("001001000000000")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.d("useCase" , "rankingViewModel doOnSubscribe .. example showProgress")
                    }
                    .doAfterTerminate {
                        Log.d("useCase" , "rankingViewModel doAfterTerminate .. example hideProgress")
                    }
                    .subscribe({ ranking ->
                        Log.d("useCase" , "rankingViewModel _rankingList.value ? ${_rankingList.value}")
                        _rankingList.value = ranking as ArrayList<Ranking>
                    }, {
                        Log.e("useCase", "rankingViewModel insert Error")
                    })
            )
        }.start()
    }
}