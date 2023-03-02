package com.github.vhawkmi.sk.generator

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.vhawkmi.sk.generator.template.bean.simpleUiStatusTemplate
import com.github.vhawkmi.sk.generator.template.fragment.simpleFragmentTemplate
import com.github.vhawkmi.sk.generator.template.layout.simpleLayoutTemp
import com.github.vhawkmi.sk.generator.viewmodel.simpleViewModelTemplate

/**
 *
 * @Description:     生成文件
 */

fun RecipeExecutor.simpleFragmentRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    modelName: String,
    layoutName: String,
    desc: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension

    if (language == Language.Kotlin) {
        // 生成 Fragment
        save(
            simpleFragmentTemplate(packageName = packageName, modelName = modelName, viewName = layoutName, desc = desc),
            srcOut.resolve("ui/${modelName}.${ktOrJavaExt}")
        )
        // 生成 ViewModel
        save(simpleViewModelTemplate(packageName, modelName, desc), srcOut.resolve("viewmodel/${modelName}.${ktOrJavaExt}"))
        // 生成UIStatus
        save(simpleUiStatusTemplate(packageName, modelName, desc), srcOut.resolve("bean/${modelName}.${ktOrJavaExt}"))

        //生成 fragment_layout
        save(simpleLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
    }
}

