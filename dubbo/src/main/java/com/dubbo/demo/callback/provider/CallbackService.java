package com.dubbo.demo.callback.provider;

import com.dubbo.demo.callback.consumer.CallbackListener;

public interface CallbackService {
  void addListener(String key, CallbackListener listener);
}
