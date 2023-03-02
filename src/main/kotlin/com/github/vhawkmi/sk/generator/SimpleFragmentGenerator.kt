package com.github.vhawkmi.sk.generator

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.vhawkmi.sk.defaultPackageNameParameter

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator
 * @ClassName:      SimpleFragmentGenerator
 * @Description:     生成器
 */

val simpleFragmentGenerator
    get() = template {
        minApi = MIN_API
        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)


        val modelName = stringParameter {
            name = "Model Name"
            default = "XxxModel"
            help = "请输入model的名字"
            constraints = listOf(Constraint.NONEMPTY)
//            suggest = { "${activityClass.value}Model" }

        }

        val layoutName = stringParameter {
            name = "layout name"
            default = "fragment_xxx"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "activity_${camelCaseToUnderlines(modelName.value)}" }
        }


        val descName = stringParameter {
            name = "Desc Name"
            default = "描述信息"
            help = "请输入描述"
            constraints = listOf(Constraint.NONEMPTY)
//            suggest = { "${activityClass.value}Model" }

        }

        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(modelName),
            TextFieldWidget(layoutName),
            TextFieldWidget(descName),
            PackageNameWidget(packageName),
            EnumWidget(language)
        )

        recipe = {
            simpleFragmentRecipe(
                moduleData = it as ModuleTemplateData,
                packageName = packageName.value,
                modelName = modelName.value,
                layoutName = layoutName.value,
                desc = descName.value,
                language = language.value
            )
        }

    }

