package com.github.vhawkmi.sk.generator.bean

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator.bean
 * @ClassName:      UiStatusTemplate
 * @Description:     java类作用描述
 * @Author:         作者名
 * @CreateDate:     2023/3/2 14:48
 * @UpdateUser:     更新者：
 * @UpdateDate:     2023/3/2 14:48
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */

fun simpleUiStatusTemplate(packageName : String,modelName : String,desc : String) = """
    package ${packageName}.uistatus

    import com.qiuku8.android.ui.base.UiStatus

    /**
     *
     * @Description:     ${desc}
     */
    class ${modelName}UiStatus : UiStatus(){

        

    }
"""