package io.dolphin.common.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;

import java.util.List;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:18
 */
public class PageParam<T> extends Page<T> {

    /**
     * 查询数据列表
     */
    @ApiParam(hidden = true)
    private List<T> records;
    /**
     * 总数
     */
    @ApiParam(hidden = true)
    private long total = 0;

    /**
     * 每页显示条数，默认 10
     */
    @ApiParam(value = "每页大小，默认10",required = false, defaultValue = "10")
    private long size = 10;

    /**
     * 当前页
     */
    @ApiParam(value = "当前页，默认1",required = false,defaultValue = "1")
    private long current = 1;

    /**
     * 是否进行 count 查询
     */
    @ApiParam(hidden = true)
    private boolean isSearchCount = true;

    @Override
    @ApiParam(hidden = true)
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @ApiParam(hidden = true)
    public boolean getSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    @Override
    @ApiParam(hidden = true)
    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    @Override
    public Page<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public Page<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public Page<T> setCurrent(long current) {
        this.current = current;
        return this;
    }
}
