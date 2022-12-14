package com.example.bottomsheetdialogeaxm

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private val url: String = "https://tekken5953.tistory.com/"
    private val title: String = "devJaeYL's Tistory blog"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val link: TextView = view.findViewById(R.id.bottom_link)
        val name: TextView = view.findViewById(R.id.bottom_title)
        link.text = url
        name.text = title

        view.setOnClickListener {
            dismiss()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            val chooser = Intent.createChooser(intent, "Open With")
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                Log.e(javaClass.name, "Link error is $e")
                Toast.makeText(context, "링크로 이동할 수 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}