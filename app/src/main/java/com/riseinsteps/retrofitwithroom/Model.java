package com.riseinsteps.retrofitwithroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_table")
public class Model {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;

    public Model() {
    }

    public Model(Integer page, Integer per_page, Integer total, Integer total_pages) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
}
