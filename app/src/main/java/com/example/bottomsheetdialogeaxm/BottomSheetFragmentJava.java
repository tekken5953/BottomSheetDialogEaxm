package com.example.bottomsheetdialogeaxm;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragmentJava extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String linkStr = "https://tekken5953.tistory.com/";
        final String titleStr = "devJaeYL's Tistory blog";

        TextView linkText = view.findViewById(R.id.jbottom_link);
        TextView titleText = view.findViewById(R.id.jbottom_title);

        linkText.setText(linkStr);
        titleText.setText(titleStr);

        view.setOnClickListener(v -> {
            dismiss();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkStr));
            Intent chooser = Intent.createChooser(intent, "Open With");

            try {
                startActivity(chooser);
            } catch (ActivityNotFoundException e) {
                Log.e(getClass().getSimpleName(), "Link error is " + e);
                Toast.makeText(getContext(), "링크로 이동할 수 없습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
