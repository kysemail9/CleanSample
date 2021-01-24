package com.kys.daggerhiltclean.framework.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kys.daggerhiltclean.business.domain.models.Result
import com.kys.daggerhiltclean.business.domain.state.DataState
import com.kys.daggerhiltclean.business.interactors.GetResults
import com.kys.daggerhiltclean.framework.presentation.MainStateEvent.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(

    private val getResults: GetResults,
    @Assisted private val savedStateHandle: SavedStateHandle

): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Result>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Result>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {


            when(mainStateEvent){

                is GetResultsEvent -> {

                    getResults.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

            }
        }
    }

}


sealed class MainStateEvent{

    object GetResultsEvent: MainStateEvent()

    object None: MainStateEvent()
}


















