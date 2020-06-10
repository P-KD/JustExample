package com.arcadekd.justexample;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class FragCall extends Fragment
{
    private View view;
    private TextView tv_call;

    private Button btn_qr;
    private Button btn_copy;
    private ImageView iv_qr;

    private final String LABEL = "WALLET";
    private final String HOMEPAGE = "http://naver.com";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_call, container, false);

        initUIComponent();

        btn_copy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(LABEL, HOMEPAGE);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getContext(), "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_qr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_qrcode);

                iv_qr = dialog.findViewById(R.id.iv_qr);

                String text = "https://naver.com";

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try
                {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 300, 300);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    iv_qr.setImageBitmap(bitmap);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                iv_qr.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return view;
    }

    private void initUIComponent()
    {
        tv_call = view.findViewById(R.id.tv_call);
        btn_copy = view.findViewById(R.id.btn_copy);
        btn_qr = view.findViewById(R.id.btn_qr);

        tv_call.setText("Call Fragment");
    }
}