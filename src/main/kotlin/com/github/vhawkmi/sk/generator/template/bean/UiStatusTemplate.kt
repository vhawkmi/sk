package com.github.vhawkmi.sk.generator.template.bean

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator.bean
 * @ClassName:      UiStatusTemplate
 * @Description:     java类作用描述
 */

fun simpleUiStatusTemplate(packageName : String,modelName : String,desc : String) = """
    package ${packageName}.bean

    import com.qiuku8.android.ui.base.UiStatus

    /**
     *
     * @Description:     ${desc}
     */
    class ${modelName}UiStatus : UiStatus(){

        

    }
"""