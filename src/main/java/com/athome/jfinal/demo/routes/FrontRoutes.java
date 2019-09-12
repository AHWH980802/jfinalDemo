package com.athome.jfinal.demo.routes;

import com.athome.jfinal.demo.controller.RoutesController;
import com.jfinal.config.Routes;

/**
 * @author 萧一旬
 * @date Create in 15:30 2019/9/3
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setMappingSuperClass(true);
        add("/routes", RoutesController.class );
    }
}
