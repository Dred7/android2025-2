package com.example.a02_24_25;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
public class NonBackDispatcher implements OnBackInvokedDispatcher {

    public NonBackDispatcher() {
    }

    @Override
    public void registerOnBackInvokedCallback(int priority, @NonNull OnBackInvokedCallback callback) {

    }

    @Override
    public void unregisterOnBackInvokedCallback(@NonNull OnBackInvokedCallback callback) {

    }
}
