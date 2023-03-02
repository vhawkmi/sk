package com.github.vhawkmi.sk.generator.viewmodel

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator.viewmodel
 * @ClassName:      ViewModelTemplate
 * @Description:     java类作用描述
 */
fun simpleViewModelTemplate(packageName : String,modelName : String,desc : String) = """
package ${packageName}.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alibaba.fastjson.JSONObject
import com.jdd.base.ui.widget.LoadingLayout
import com.qiuku8.android.common.utils.KtNetResult
import com.qiuku8.android.common.utils.startHttp
import com.qiuku8.android.common.utils.toast
import com.qiuku8.android.module.topic.uistatus.${modelName}UiStatus
import com.qiuku8.android.network.Action
import com.qiuku8.android.network.DomainUrl
import com.qiuku8.android.ui.base.BaseViewModel2
import kotlinx.coroutines.launch

/**
 * 
 * @Description:    ${desc}
 */
class ${modelName}ViewModel(application: Application): BaseViewModel2(application) {

    var uiStatusLiveData = MutableLiveData<${modelName}UiStatus>()

    private var pageNo = 1


    /**
     * 网络请求，按需改写
     **/
    fun doRequest(isFirst : Boolean,isRefresh : Boolean){
        if (isRefresh){
            pageNo = 1
            if (isFirst){
                var uiStatus = ${modelName}UiStatus()
                uiStatus.loadingStatus = LoadingLayout.Loading
                uiStatusLiveData.postValue(uiStatus)
            }
        }

        viewModelScope.launch {

            var param=  JSONObject().apply {
                    put("key", value)
                   
                }.toJSONString()
                
            var result = startHttp<>(
                DomainUrl.URL_UNCT_PUBLIC_SKTY,
                Action.,
                param
            )

            when(result.status){
                KtNetResult.SUCCESS ->{
                    // todo 个性化数据处理
                    pageNo++
                }
                KtNetResult.FAILURE ->{
                    var uiStatus = ${modelName}UiStatus()
                    if (isRefresh){
                        uiStatus.loadingStatus = LoadingLayout.Error
                        uiStatus.isRefreshing = false
                        result.message
                            .toast()
                    }else{
                        uiStatus.loadingStatus = LoadingLayout.Success
                        uiStatus.isRefreshing = false
                        result.message
                            .toast()
                    }
                    uiStatusLiveData.postValue(uiStatus)
                }
                KtNetResult.EMPTY ->{
                    var uiStatus = ${modelName}UiStatus()
                    if (isRefresh){
                        uiStatus.loadingStatus = LoadingLayout.Empty
                        uiStatus.isRefreshing = false
                        result.message
                            .toast()
                    }else{
                        uiStatus.loadingStatus = LoadingLayout.Success
                        uiStatus.isRefreshing = false
                        uiStatus.noMoreData = true
                        result.message
                            .toast()
                    }
                    uiStatusLiveData.postValue(uiStatus)
                }
            }
        }
    }

}
"""