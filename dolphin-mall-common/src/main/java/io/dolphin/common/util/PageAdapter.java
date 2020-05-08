package io.dolphin.common.util;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:18
 */
@Data
public class PageAdapter{

    private int begin;

    private int size;

    public PageAdapter(Page page) {
        int[] startEnd = PageUtil.transToStartEnd((int) page.getCurrent(), (int) page.getSize());
        this.begin = startEnd[0];
        this.size = (int)page.getSize();
    }
}
