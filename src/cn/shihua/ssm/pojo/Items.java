package cn.shihua.ssm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Items {
    private Integer id;

    private String name;

    private Float price;

    private String pic;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", createtime=" + createtime
				+ ", detail=" + detail + "]";
	}
    
    
}