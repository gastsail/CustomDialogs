package com.gaston.dialogbuilder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.gaston.dialogbuilder.R
import kotlinx.android.synthetic.main.custom_dialog.*

/**
 * Created by Gastón Saillén on 08 November 2019
 */
class CustomDialog private constructor(
    private val positiveButtonText: String?,
    private val negativeButtonText: String?,
    private val titleText: String?,
    private val descriptionText: String?,
    private val isNegativeButtonVisible: Boolean?,
    private var dialogClickListener: DialogButtonClickListener? = null
) : DialogFragment() {

    interface DialogButtonClickListener{
        fun onPositiveButtonClick()
        fun onNegateiveButtonClick()
    }

    data class Builder(private var positiveButtonText: String? = null,
                       private var negativeButtonText: String? = null,
                       private var titleText: String? = null,
                       private var descriptionText: String? = null,
                       private var isNegativeButtonVisible: Boolean = true){

        fun setPositiveButtonText(positiveButtonText:String) = apply { this.positiveButtonText = positiveButtonText }
        fun setNegativeButtonText(negativeButtonText:String) = apply { this.negativeButtonText = negativeButtonText }
        fun setTitle(titleText:String) = apply { this.titleText = titleText }
        fun setDescription(descriptionText:String) = apply { this.descriptionText = descriptionText }
        fun isNegativeButtonEnabled(isNegativeButtonVisible:Boolean) = apply { this.isNegativeButtonVisible = isNegativeButtonVisible }
        fun build() = CustomDialog(positiveButtonText,negativeButtonText,titleText,descriptionText,isNegativeButtonVisible)
    }

    fun setDialogButtonClickListener(listener:DialogButtonClickListener) = apply { dialogClickListener = listener }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_dialog,container)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog_title.text = titleText
        dialog_description.text = descriptionText
        btn_aceptar.text = positiveButtonText
        btn_aceptar.setOnClickListener { dialogClickListener!!.onPositiveButtonClick() }
        btn_cancelar.text = negativeButtonText
        btn_cancelar.setOnClickListener { dialogClickListener!!.onNegateiveButtonClick() }
        if(isNegativeButtonVisible!!) btn_cancelar.visibility = View.GONE
    }

}