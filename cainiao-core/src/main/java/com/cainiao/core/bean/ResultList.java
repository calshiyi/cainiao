package com.cainiao.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : ResultList
 * @Description : 查询结果List,适用于分页，或者需要知道总记录数
 * @Author : Cai
 * @Date: 2019-12-10 14:05
 */
public class ResultList<E> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 页数
     */
    private int pageNum;

    /**
     * 总页
     */
    private int total = 0;

    /**
     * 结果
     */
    private List<E> result = new ArrayList<E>();

    public ResultList() {
    }

    public static <E> ResultList<E> emptyList() {
        return new ResultList<E>();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }

    public ResultList(int pageSize, int pageNum, int total, List<E> result) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
        this.result = result;
    }
}
