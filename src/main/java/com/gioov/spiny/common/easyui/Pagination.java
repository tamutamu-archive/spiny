package com.gioov.spiny.common.easyui;

import java.util.List;

/**
 * @author godcheese
 * @date 2018/5/12
 */
public class Pagination {

    /**
     * 返回例如：{rows:[{},{}], total:2}
     *
     * @param <E>
     */
    public class Result<E> {
        private List<E> rows;
        private int total;

        public List<E> getRows() {
            return rows;
        }

        public void setRows(List<E> rows) {
            this.rows = rows;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
