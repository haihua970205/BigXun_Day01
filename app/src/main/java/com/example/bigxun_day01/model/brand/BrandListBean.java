package com.example.bigxun_day01.model.brand;

import java.util.List;

public class BrandListBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"count":49,"totalPages":5,"pageSize":10,"currentPage":1,"data":[{"id":1001000,"name":"MUJI制造商","floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png"},{"id":1001002,"name":"内野制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png"},{"id":1001003,"name":"Adidas制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/335334d0deaff6dc3376334822ab3a2f.png"},{"id":1001007,"name":"优衣库制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0d72832e37e7e3ea391b519abbbc95a3.png"},{"id":1001008,"name":"膳魔师制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5fd51e29b9459dae7df8040c8219f241.png"},{"id":1001010,"name":"星巴克制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5668bc50f2f2e551891044525710dc84.png"},{"id":1001012,"name":"Wedgwood制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/68940e8e23f96dbeb3548d943d83d5e4.png"},{"id":1001013,"name":"Royal Doulton制造商","floor_price":24.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0de643a02043fd9680b11e21c452adaa.png"},{"id":1001015,"name":"日本KEYUCA制造商","floor_price":14.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9b85b45f23da558be101dbcc273b1d6d.png"},{"id":1001016,"name":"爱慕制造商","floor_price":35,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5104f84110eac111968c63c18ebd62c0.png"}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 49
         * totalPages : 5
         * pageSize : 10
         * currentPage : 1
         * data : [{"id":1001000,"name":"MUJI制造商","floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png"},{"id":1001002,"name":"内野制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png"},{"id":1001003,"name":"Adidas制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/335334d0deaff6dc3376334822ab3a2f.png"},{"id":1001007,"name":"优衣库制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0d72832e37e7e3ea391b519abbbc95a3.png"},{"id":1001008,"name":"膳魔师制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5fd51e29b9459dae7df8040c8219f241.png"},{"id":1001010,"name":"星巴克制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5668bc50f2f2e551891044525710dc84.png"},{"id":1001012,"name":"Wedgwood制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/68940e8e23f96dbeb3548d943d83d5e4.png"},{"id":1001013,"name":"Royal Doulton制造商","floor_price":24.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0de643a02043fd9680b11e21c452adaa.png"},{"id":1001015,"name":"日本KEYUCA制造商","floor_price":14.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9b85b45f23da558be101dbcc273b1d6d.png"},{"id":1001016,"name":"爱慕制造商","floor_price":35,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5104f84110eac111968c63c18ebd62c0.png"}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1001000
             * name : MUJI制造商
             * floor_price : 12.9
             * app_list_pic_url : http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png
             */

            private int id;
            private String name;
            private double floor_price;
            private String app_list_pic_url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getFloor_price() {
                return floor_price;
            }

            public void setFloor_price(double floor_price) {
                this.floor_price = floor_price;
            }

            public String getApp_list_pic_url() {
                return app_list_pic_url;
            }

            public void setApp_list_pic_url(String app_list_pic_url) {
                this.app_list_pic_url = app_list_pic_url;
            }
        }
    }
}
