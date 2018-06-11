package com.chinadci.backendservice.common.entity;

import java.util.Dictionary;
import java.util.List;

public class ReturnCountAndObjects<T>
{
    /// <summary>
    /// 结果总数
    /// </summary>
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /// <summary>
    /// 总页数
    /// </summary>
    private int pagecount;

    public int getPageCount() {
        return pagecount;
    }

    public void setPageCount(int pagecount) {
        this.pagecount = pagecount;
    }

    /// <summary>
    /// 页码
    /// </summary>
    private int pageindex;

    public int getPageIndex() {
        return pageindex;
    }

    public void setPageIndex(int pageindex) {
        this.pageindex = pageindex;
    }

    /// <summary>
    /// 返回记录数
    /// </summary>
    private int recordnum;

    public int getRecordNum() {
        return recordnum;
    }

    public void setRecordNum(int recordnum) {
        this.recordnum = recordnum;
    }

    /// <summary>
    /// 列值
    /// </summary>
    private Dictionary<String, String> columns;

    public Dictionary<String, String> getColumns() {
        return columns;
    }

    public void setColumns(Dictionary<String, String> columns) {
        this.columns = columns;
    }

    /// <summary>
    /// 当前返回的对象
    /// </summary>
    private List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }
}
