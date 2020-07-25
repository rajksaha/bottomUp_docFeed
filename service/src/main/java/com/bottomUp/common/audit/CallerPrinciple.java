package com.bottomUp.common.audit;


import com.bottomUp.domain.BottomUpUserDetail;

/**
 * Created by raj on 1/25/16.
 */
public class CallerPrinciple {

    private static final ThreadLocal<BottomUpUserDetail> userThreadLocal = new ThreadLocal<BottomUpUserDetail>() {
        @Override
        protected BottomUpUserDetail initialValue() {
            return null;
        }
    };

    public static BottomUpUserDetail getUser() {
        return userThreadLocal.get();
    }

    public static String getUsername() {
        BottomUpUserDetail bottomUpUserDetail = getUser();
        return bottomUpUserDetail == null ? "anonymous" : bottomUpUserDetail.getUsername();
    }

    public static void setUser(BottomUpUserDetail bottomUpUserDetail) {
        userThreadLocal.set(bottomUpUserDetail);
    }
}
