package com.example.demo.model;

import java.util.Objects;

import javax.persistence.*;

@Entity(name = "MonAnChiTiet")
@Table(name = "monanchitiet")
public class MonAnChiTiet {
	
	@EmbeddedId
	private MonAnChiTietID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("monan_Id")
    private MonAn monan;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nguyenlieu_Id")
    private NguyenLieu nguyenlieu;
	
	@Column(name="MONANCHITIET_SOLUONG")
	private Float soluong;
	
	
	public MonAnChiTiet() {
		super();
	}
	

	public MonAnChiTiet(MonAnChiTietID id, MonAn monan, NguyenLieu nguyenlieu, Float soluong) {
		super();
		this.id = new MonAnChiTietID(monan.getMONAN_ID(), nguyenlieu.getNGUYENLIEU_ID());
		this.monan = monan;
		this.nguyenlieu = nguyenlieu;
		this.soluong = soluong;
	}

	public MonAnChiTietID getId() {
		return id;
	}

	public void setId(MonAnChiTietID id) {
		this.id = id;
	}

	public MonAn getMonan() {
		return monan;
	}

	public void setMonan(MonAn monan) {
		this.monan = monan;
	}

	public NguyenLieu getNguyenlieu() {
		return nguyenlieu;
	}

	public void setNguyenlieu(NguyenLieu nguyenlieu) {
		this.nguyenlieu = nguyenlieu;
	}

	public Float getSoluong() {
		return soluong;
	}

	public void setSoluong(Float soluong) {
		this.soluong = soluong;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        MonAnChiTiet that = (MonAnChiTiet) o;
        return Objects.equals(monan, that.monan) &&
               Objects.equals(nguyenlieu, that.nguyenlieu);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(monan, nguyenlieu);
    }

}
