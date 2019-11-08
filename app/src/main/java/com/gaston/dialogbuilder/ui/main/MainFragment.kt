package com.gaston.dialogbuilder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gaston.dialogbuilder.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_customdialog1.setOnClickListener {

            val customDialog = CustomDialog.Builder()
                .setTitle("¿ Desea borrar esta cuenta ?")
                .setDescription(" Se borraran todos sus datos, esta seguro que desea continuar?")
                .setPositiveButtonText("Aceptar")
                .setNegativeButtonText("Cancelar")
                .build()

            customDialog.show(fragmentManager!!,"customdialog1")
            customDialog.isCancelable = false

            customDialog.setDialogButtonClickListener(object : CustomDialog.DialogButtonClickListener{
                override fun onPositiveButtonClick() {
                    Toast.makeText(requireActivity(),"Boton aceptar presionado",Toast.LENGTH_SHORT).show()
                }

                override fun onNegateiveButtonClick() {
                    customDialog.dismiss()
                }
            })


        }


        btn_customdialog2.setOnClickListener {
            val customDialog2 = CustomDialog.Builder()
                .setTitle("¿ Desea guardar esta informacion ?")
                .setDescription(" Se guardara la informacion en su telefono")
                .setPositiveButtonText("OK")
                .setNegativeButtonText("NO")
                .build()

            customDialog2.show(fragmentManager!!,"customdialog1")
            customDialog2.setDialogButtonClickListener(object : CustomDialog.DialogButtonClickListener{
                override fun onPositiveButtonClick() {
                    Toast.makeText(requireActivity(),"Boton ok presionado",Toast.LENGTH_SHORT).show()

                }

                override fun onNegateiveButtonClick() {
                    customDialog2.dismiss()
                }
            })

        }
    }

}
