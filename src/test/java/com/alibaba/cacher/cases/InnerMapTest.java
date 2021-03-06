package com.alibaba.cacher.cases;

import com.alibaba.cacher.Utils;
import com.alibaba.cacher.cases.base.TestBase;
import com.alibaba.cacher.exception.CacherException;
import com.alibaba.cacher.service.impl.InnerMapService;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jifang.zjf
 * @since 2017/6/21 下午7:34.
 */
public class InnerMapTest extends TestBase {

    @Resource
    private InnerMapService service;

    @Test
    public void unmodifiableMap() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);

        service.unmodifiableMap(list);
        service.unmodifiableMap(list);
        list.add(Utils.nextRadom());
        service.unmodifiableMap(list);
    }

    @Test
    public void synchronizedMap() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);

        service.synchronizedMap(list);
        service.synchronizedMap(list);
        list.add(Utils.nextRadom());
        service.synchronizedMap(list);
    }

    @Test
    public void checkedMap() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);

        service.checkedMap(list);
        service.checkedMap(list);
        list.add(Utils.nextRadom());
        service.checkedMap(list);
    }


    @Test(expected = CacherException.class)
    public void immutableMap() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);

        service.immutableMap(list);
        service.immutableMap(list);
        list.add(Utils.nextRadom());
        service.immutableMap(list);
    }
}
