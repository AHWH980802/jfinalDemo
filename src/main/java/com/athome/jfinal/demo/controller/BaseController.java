package com.athome.jfinal.demo.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;

/**
 * @author 萧一旬
 * @date Create in 15:12 2019/9/3
 */
public class BaseController extends Controller {

    // 不希望成为 action，仅供子类调用，或拦截器中调用
    @NotAction
    public void getLoginUser() {
        renderText("getLoginUser");
    }

}
