package readdata;

import java.util.ArrayList;

public class ObjectFile {
	private String diachi;
	private String giatien;
	private String dientich;
	private String quan;
	private String dienthoai;
	private String masoDK;
	private String loaitinrao;
	private String ngaydk;
	private String ngayhethan;
	private String sotang;
	private String sophong;
	private String matien;
	private String duongvao;
	private String sotoilet;
	private String noithat;
	private String nguoilienhe;
	private String diachiNLH;
	private String sdtNLH;
	private String mota;
	private String link;
	public ObjectFile(ArrayList<String> lstObj) {
		super();
		this.diachi = lstObj.get(0);
		this.giatien = lstObj.get(1);
		this.dientich = lstObj.get(2);
		this.quan = lstObj.get(3);
		this.dienthoai = lstObj.get(4);
		this.masoDK = lstObj.get(5);
		this.loaitinrao = lstObj.get(6);
		this.ngaydk = lstObj.get(7);
		this.ngayhethan = lstObj.get(8);
		this.sotang = lstObj.get(9);
		this.sophong = lstObj.get(10);
		this.matien = lstObj.get(11);
		this.duongvao = lstObj.get(12);
		this.sotoilet = lstObj.get(13);
		this.noithat = lstObj.get(14);
		this.nguoilienhe = lstObj.get(15);
		this.diachiNLH = lstObj.get(16);
		this.sdtNLH = lstObj.get(17);
		this.mota = lstObj.get(18);
		this.link = lstObj.get(19);
	}
	
	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getDientich() {
		return dientich;
	}

	public void setDientich(String dientich) {
		this.dientich = dientich;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getMasoDK() {
		return masoDK;
	}

	public void setMasoDK(String masoDK) {
		this.masoDK = masoDK;
	}

	public String getLoaitinrao() {
		return loaitinrao;
	}

	public void setLoaitinrao(String loaitinrao) {
		this.loaitinrao = loaitinrao;
	}

	public String getNgaydk() {
		return ngaydk;
	}

	public void setNgaydk(String ngaydk) {
		this.ngaydk = ngaydk;
	}

	public String getNgayhethan() {
		return ngayhethan;
	}

	public void setNgayhethan(String ngayhethan) {
		this.ngayhethan = ngayhethan;
	}

	public String getSotang() {
		return sotang;
	}

	public void setSotang(String sotang) {
		this.sotang = sotang;
	}

	public String getSophong() {
		return sophong;
	}

	public void setSophong(String sophong) {
		this.sophong = sophong;
	}

	public String getMatien() {
		return matien;
	}

	public void setMatien(String matien) {
		this.matien = matien;
	}

	public String getDuongvao() {
		return duongvao;
	}

	public void setDuongvao(String duongvao) {
		this.duongvao = duongvao;
	}

	public String getSotoilet() {
		return sotoilet;
	}

	public void setSotoilet(String sotoilet) {
		this.sotoilet = sotoilet;
	}

	public String getNoithat() {
		return noithat;
	}

	public void setNoithat(String noithat) {
		this.noithat = noithat;
	}

	public String getNguoilienhe() {
		return nguoilienhe;
	}

	public void setNguoilienhe(String nguoilienhe) {
		this.nguoilienhe = nguoilienhe;
	}

	public String getDiachiNLH() {
		return diachiNLH;
	}

	public void setDiachiNLH(String diachiNLH) {
		this.diachiNLH = diachiNLH;
	}

	public String getSdtNLH() {
		return sdtNLH;
	}

	public void setSdtNLH(String sdtNLH) {
		this.sdtNLH = sdtNLH;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "ObjectFile [diachi=" + diachi + ", giatien=" + giatien + ", dientich=" + dientich + ", quan=" + quan
				+ ", dienthoai=" + dienthoai + ", masoDK=" + masoDK + ", loaitinrao=" + loaitinrao + ", ngaydk="
				+ ngaydk + ", ngayhethan=" + ngayhethan + ", sotang=" + sotang + ", sophong=" + sophong + ", matien="
				+ matien + ", duongvao=" + duongvao + ", sotoilet=" + sotoilet + ", noithat=" + noithat
				+ ", nguoilienhe=" + nguoilienhe + ", diachiNLH=" + diachiNLH + ", sdtNLH=" + sdtNLH + ", mota=" + mota
				+ ", link=" + link + "] \n";
	}
	
	

}
