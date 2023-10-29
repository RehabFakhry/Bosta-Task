package com.bosta.bostatask.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bosta.bostatask.ui.utils.EventHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T, E>(initialState: T): ViewModel() {

    abstract val TAG: String
    protected open fun log(message: String) = Log.v(TAG, message)

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<EventHandler<E>>()
    val effect = _effect.asSharedFlow()


    protected fun<T> tryToExecute(
        function: suspend() -> T,
        onSuccess: (T) -> Unit,
        onError: (t:Exception) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ){
        viewModelScope.launch(dispatcher) {
            try {
                val result = function()
                Log.d(TAG, "tryToExecute:$result")
                onSuccess(result)
            } catch (e: Exception){
                Log.e(TAG, "tryToExecute: ${e.message}")
                onError(e)
            }
        }
    }
}