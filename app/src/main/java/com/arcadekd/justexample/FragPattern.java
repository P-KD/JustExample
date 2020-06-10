package com.arcadekd.justexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class FragPattern extends Fragment
{
    private View view;
    private PatternLockView pattern_view;
    private PatternLockViewListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_pattern_lock, container, false);

        pattern_view = view.findViewById(R.id.patternLockView);

        listener = new PatternLockViewListener()
        {
            @Override
            public void onStarted()
            {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern)
            {
                Log.e("pattern_progress", PatternLockUtils.patternToString(pattern_view, progressPattern));
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern)

            {
                Log.e("pattern_complete", PatternLockUtils.patternToString(pattern_view, pattern));
            }

            @Override
            public void onCleared()
            {

            }
        };

        pattern_view.addPatternLockListener(listener);

        return view;
    }
}
