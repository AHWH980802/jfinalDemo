package com.athome.jfinal.demo.config;

import com.athome.jfinal.demo.controller.HelloController;
import com.athome.jfinal.demo.entity.User;
import com.athome.jfinal.demo.routes.FrontRoutes;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;


/**
 * @author 萧一旬
 * @date Create in 20:08 2019/9/2
 */
public class DemoConfig extends JFinalConfig {

    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class,80,true);
    }

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new FrontRoutes());

        routes.setBaseViewPath("/base");
        routes.add("/hello", HelloController.class,"/hello");
        routes.setMappingSuperClass(true);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        PropKit.use("database.properties");
        //数据库连接插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("url"),PropKit.get("username"),PropKit.get("password"));
        plugins.add(druidPlugin);

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.addMapping("user", User.class);
        plugins.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
