package restaurant_cafe.util;

import java.util.List;

import restaurant_cafe.bean.ItemBean;

public class Cast {

    @SuppressWarnings("unchecked")
    public static List<ItemBean> castList(Object object) {
        return (List<ItemBean> )object;
    }
}
