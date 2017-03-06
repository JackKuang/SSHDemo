package com.hurenjieee.entity;
// Generated 2017-3-6 18:59:56 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CollectiveId generated by hbm2java
 */
@Embeddable
public class CollectiveId implements java.io.Serializable {

    private Long    colId;
    private String  colName;
    private Integer colYear;
    private Long    colMajId;

    public CollectiveId() {}

    public CollectiveId(Long colId, String colName, Integer colYear, Long colMajId) {
        this.colId = colId;
        this.colName = colName;
        this.colYear = colYear;
        this.colMajId = colMajId;
    }

    @Column(name = "col_id")
    public Long getColId(){
        return this.colId;
    }

    public void setColId(Long colId){
        this.colId = colId;
    }

    @Column(name = "col_name",length = 16)
    public String getColName(){
        return this.colName;
    }

    public void setColName(String colName){
        this.colName = colName;
    }

    @Column(name = "col_year")
    public Integer getColYear(){
        return this.colYear;
    }

    public void setColYear(Integer colYear){
        this.colYear = colYear;
    }

    @Column(name = "col_maj_id")
    public Long getColMajId(){
        return this.colMajId;
    }

    public void setColMajId(Long colMajId){
        this.colMajId = colMajId;
    }

    public boolean equals(Object other){
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof CollectiveId)) return false;
        CollectiveId castOther = (CollectiveId) other;

        return ((this.getColId() == castOther.getColId())
                || (this.getColId() != null && castOther.getColId() != null && this.getColId().equals(castOther.getColId())))
                && ((this.getColName() == castOther.getColName())
                        || (this.getColName() != null && castOther.getColName() != null && this.getColName().equals(castOther.getColName())))
                && ((this.getColYear() == castOther.getColYear())
                        || (this.getColYear() != null && castOther.getColYear() != null && this.getColYear().equals(castOther.getColYear())))
                && ((this.getColMajId() == castOther.getColMajId())
                        || (this.getColMajId() != null && castOther.getColMajId() != null && this.getColMajId().equals(castOther.getColMajId())));
    }

    public int hashCode(){
        int result = 17;

        result = 37 * result + (getColId() == null ? 0 : this.getColId().hashCode());
        result = 37 * result + (getColName() == null ? 0 : this.getColName().hashCode());
        result = 37 * result + (getColYear() == null ? 0 : this.getColYear().hashCode());
        result = 37 * result + (getColMajId() == null ? 0 : this.getColMajId().hashCode());
        return result;
    }

}