package com.github.vhawkmi.sk.generator.fragment

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator.fragment
 * @ClassName:      FragmentTemplate
 * @Description:     java类作用描述
 */


fun simpleFragmentTemplate(packageName : String,modelName : String,viewName : String,desc : String) = """
    package ${packageName}.ui

    import androidx.fragment.app.viewModels
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.qiuku8.android.R
    import com.qiuku8.android.databinding.Fragment${modelName}Binding
    import com.qiuku8.android.module.topic.viewmodel.${modelName}ViewModel
    import com.qiuku8.android.ui.base.BaseBindingFragment

    /**
     *
     * @Description:  ${desc}  
     */
    class ${modelName}Fragment : BaseBindingFragment<Fragment${modelName}Binding>(), Searchable {

        private val viewModel: ${modelName}ViewModel by viewModels()

        private var mAdapter = ${modelName}Adapter()

        override fun getLayout(): Int {
            return R.layout.${viewName}
        }

        override fun initDatas(savedInstanceState: Bundle?) {
            lifecycle.addObserver(viewModel)
            addObserver()
        }

        private fun addObserver() {
            viewModel.uiStatusLiveData.observe(this){uiStatus ->
                uiStatus.loadingStatus?.let { loadingStatus ->
                    binding.layoutLoading.status = loadingStatus
                }
                uiStatus.noMoreData?.let { noMore ->
                    binding.layoutRefresh.setNoMoreData(noMore)
                }
                uiStatus.isRefreshing?.let {
                    binding.layoutRefresh.finishRefresh()
                    binding.layoutRefresh.finishLoadMore()
                }
               // todo 特征处理
            }
        }

        override fun initViews() {
            binding.layoutLoading.setOnReloadListener {
                viewModel.searchByKeyWords(lastKeyWord, isFirst = true, isRefresh = true)
            }

            binding.layoutRefresh.setEnableRefresh(true)
            binding.layoutRefresh.setEnableLoadMore(true)
            binding.layoutRefresh.setOnRefreshListener {
                viewModel.searchByKeyWords(lastKeyWord, isFirst = false, isRefresh = true)
            }
        

            binding.recycleSearchResult.let {
                it.layoutManager = LinearLayoutManager(requireActivity())
                it.adapter = mAdapter
            }

            
        }


        override fun initEvents() {

        }
        
    }
"""


