package br.com.hugoamac.catalogo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "produto")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codigo_interno", nullable = false)
	private Long codIn;

	@Column(name = "codigo_tablet", nullable = false)
	private Long codTablet;

	@Column(name = "produto", nullable = false)
	private String name;

	@Column(name = "codigo_fornecedor", nullable = true)
	private Long codSupplier;

	@Column(name = "fornecedor", nullable = true)
	private String supplier;

	@Column(name = "barra_unidade", nullable = false)
	private String barUnity;

	@Column(name = "barra_caixa", nullable = true)
	private String barBox;

	@Column(name = "ean_display", nullable = true)
	private String eanDisplay;

	@Column(name = "peso_unidade", nullable = true)
	private String weightUnity;

	@Column(name = "peso_compra", nullable = true)
	private String weightBuy;

	@Column(name = "altura", nullable = false)
	private String heigth;

	@Column(name = "largura", nullable = true)
	private String width;

	@Column(name = "comprimento", nullable = true)
	private String depth;

	@Column(name = "mult_venda", nullable = true)
	private String multipleSale;

	@Column(name = "ncm", nullable = true)
	private String ncm;

	@Column(name = "img", nullable = true)
	private String img;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv1;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv2;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv3;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv4;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv5;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv6;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv7;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv8;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv9;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv10;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv11;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv12;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv13;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv14;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean pdv15;

	@CreatedDate
	@Column(name = "criado_em")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "atualizado_em")
	private Date updatedAt;

	@Transient
	private MultipartFile file;

	public Product() {

	}

	public Product(Long codIn, Long codTablet, String name, Long codSupplier, String supplier, String barUnity,
			String barBox, String eanDisplay, String weightUnity, String weightBuy, String heigth, String width,
			String depth, String multipleSale, String ncm, String img, boolean pdv1, boolean pdv2, boolean pdv3,
			boolean pdv4, boolean pdv5, boolean pdv6, boolean pdv7, boolean pdv8, boolean pdv9, boolean pdv10,
			boolean pdv11, boolean pdv12, boolean pdv13, boolean pdv14, boolean pdv15) {
		super();
		this.codIn = codIn;
		this.codTablet = codTablet;
		this.name = name;
		this.codSupplier = codSupplier;
		this.supplier = supplier;
		this.barUnity = barUnity;
		this.barBox = barBox;
		this.eanDisplay = eanDisplay;
		this.weightUnity = weightUnity;
		this.weightBuy = weightBuy;
		this.heigth = heigth;
		this.width = width;
		this.depth = depth;
		this.multipleSale = multipleSale;
		this.ncm = ncm;
		this.img = img;
		this.pdv1 = pdv1;
		this.pdv2 = pdv2;
		this.pdv3 = pdv3;
		this.pdv4 = pdv4;
		this.pdv5 = pdv5;
		this.pdv6 = pdv6;
		this.pdv7 = pdv7;
		this.pdv8 = pdv8;
		this.pdv9 = pdv9;
		this.pdv10 = pdv10;
		this.pdv11 = pdv11;
		this.pdv12 = pdv12;
		this.pdv13 = pdv13;
		this.pdv14 = pdv14;
		this.pdv15 = pdv15;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodIn() {
		return codIn;
	}

	public void setCodIn(Long codIn) {
		this.codIn = codIn;
	}

	public Long getCodTablet() {
		return codTablet;
	}

	public void setCodTablet(Long codTablet) {
		this.codTablet = codTablet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCodSupplier() {
		return codSupplier;
	}

	public void setCodSupplier(Long codSupplier) {
		this.codSupplier = codSupplier;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBarUnity() {
		return barUnity;
	}

	public void setBarUnity(String barUnity) {
		this.barUnity = barUnity;
	}

	public String getBarBox() {
		return barBox;
	}

	public void setBarBox(String barBox) {
		this.barBox = barBox;
	}

	public String getEanDisplay() {
		return eanDisplay;
	}

	public void setEanDisplay(String eanDisplay) {
		this.eanDisplay = eanDisplay;
	}

	public String getWeightUnity() {
		return weightUnity;
	}

	public void setWeightUnity(String weightUnity) {
		this.weightUnity = weightUnity;
	}

	public String getWeightBuy() {
		return weightBuy;
	}

	public void setWeightBuy(String weightBuy) {
		this.weightBuy = weightBuy;
	}

	public String getHeigth() {
		return heigth;
	}

	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getMultipleSale() {
		return multipleSale;
	}

	public void setMultipleSale(String multipleSale) {
		this.multipleSale = multipleSale;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isPdv1() {
		return pdv1;
	}

	public void setPdv1(boolean pdv1) {
		this.pdv1 = pdv1;
	}

	public boolean isPdv2() {
		return pdv2;
	}

	public void setPdv2(boolean pdv2) {
		this.pdv2 = pdv2;
	}

	public boolean isPdv3() {
		return pdv3;
	}

	public void setPdv3(boolean pdv3) {
		this.pdv3 = pdv3;
	}

	public boolean isPdv4() {
		return pdv4;
	}

	public void setPdv4(boolean pdv4) {
		this.pdv4 = pdv4;
	}

	public boolean isPdv5() {
		return pdv5;
	}

	public void setPdv5(boolean pdv5) {
		this.pdv5 = pdv5;
	}

	public boolean isPdv6() {
		return pdv6;
	}

	public void setPdv6(boolean pdv6) {
		this.pdv6 = pdv6;
	}

	public boolean isPdv7() {
		return pdv7;
	}

	public void setPdv7(boolean pdv7) {
		this.pdv7 = pdv7;
	}

	public boolean isPdv8() {
		return pdv8;
	}

	public void setPdv8(boolean pdv8) {
		this.pdv8 = pdv8;
	}

	public boolean isPdv9() {
		return pdv9;
	}

	public void setPdv9(boolean pdv9) {
		this.pdv9 = pdv9;
	}

	public boolean isPdv10() {
		return pdv10;
	}

	public void setPdv10(boolean pdv10) {
		this.pdv10 = pdv10;
	}

	public boolean isPdv11() {
		return pdv11;
	}

	public void setPdv11(boolean pdv11) {
		this.pdv11 = pdv11;
	}

	public boolean isPdv12() {
		return pdv12;
	}

	public void setPdv12(boolean pdv12) {
		this.pdv12 = pdv12;
	}

	public boolean isPdv13() {
		return pdv13;
	}

	public void setPdv13(boolean pdv13) {
		this.pdv13 = pdv13;
	}

	public boolean isPdv14() {
		return pdv14;
	}

	public void setPdv14(boolean pdv14) {
		this.pdv14 = pdv14;
	}

	public boolean isPdv15() {
		return pdv15;
	}

	public void setPdv15(boolean pdv15) {
		this.pdv15 = pdv15;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", codIn=" + codIn + ", codTablet=" + codTablet + ", name=" + name
				+ ", codSupplier=" + codSupplier + ", supplier=" + supplier + ", barUnity=" + barUnity + ", barBox="
				+ barBox + ", eanDisplay=" + eanDisplay + ", weightUnity=" + weightUnity + ", weightBuy=" + weightBuy
				+ ", heigth=" + heigth + ", width=" + width + ", depth=" + depth + ", multipleSale=" + multipleSale
				+ ", ncm=" + ncm + ", img=" + img + ", pdv1=" + pdv1 + ", pdv2=" + pdv2 + ", pdv3=" + pdv3 + ", pdv4="
				+ pdv4 + ", pdv5=" + pdv5 + ", pdv6=" + pdv6 + ", pdv7=" + pdv7 + ", pdv8=" + pdv8 + ", pdv9=" + pdv9
				+ ", pdv10=" + pdv10 + ", pdv11=" + pdv11 + ", pdv12=" + pdv12 + ", pdv13=" + pdv13 + ", pdv14=" + pdv14
				+ ", pdv15=" + pdv15 + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
