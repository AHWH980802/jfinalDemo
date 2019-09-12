package com.athome.jfinal.demo.controller;

import com.athome.jfinal.demo.entity.User;
import com.jfinal.core.paragetter.Para;
import com.jfinal.json.FastJson;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * @author 萧一旬
 * @date Create in 20:10 2019/9/2
 */
public class HelloController extends BaseController {

    public void index() {
        Integer anInt = getInt(1);
        String para = get(0);
        String name = get("name");
        Integer age = getParaToInt("age");
        renderText("Hello JFinal World....." + anInt + "..........." + para + "----------" + name + "-------" + age + "----------" + getPara());
    }

    public void helloJFinal() {
        renderText("Hello JFinal...");
    }

    public void testProKit() {
        PropKit.use("config.txt");
        String userName = PropKit.get("userName");
        String blog = PropKit.get("blog");

        // Prop 配合用法
        Prop p = PropKit.use("config.txt");
        Boolean devMode = p.getBoolean("devMode");
        renderText(userName + "----------" + blog + "---------" + devMode);


    }

    public void testGetRawData() {
        String json = getRawData();
        User user = FastJson.getJson().parse(json, User.class);
//        renderText(user.toString());

        setAttr("rawData", getRawData());
        forwardAction("/hello/testForwardAction");


//        User user = getBean(User.class,"");
        /*String toJson = FastJson.getJson().toJson(user);
        renderText(toJson);*/
    }

    public void testForwardAction() {
        String json = getAttr("rawData");
        renderText(json + "-----testForwardAction");
    }

    public void testRender() {
        render("render.html");
    }

    public void testGetBean() {
        User user = getBean(User.class,"");
        renderText(user.toString());
    }

    public void testGetModel() {
        User user = getModel(User.class,"user");
        renderText(user.toString());
    }
}
