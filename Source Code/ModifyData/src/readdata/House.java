package readdata;

import java.util.ArrayList;
import java.util.Date;

public class House {
	private String masoDK;
	private String giatien;
	private String dientich;
	private String quan;
	private String sotang;
	private String vitri;
	public String getMasoDK() {
		return masoDK;
	}
	public ArrayList<String> getHouse(){
		ArrayList<String> lstAttrs = new ArrayList<>();
		lstAttrs.add(masoDK);
		lstAttrs.add(giatien);
		lstAttrs.add(dientich);
		lstAttrs.add(quan);
		lstAttrs.add(sotang);
		lstAttrs.add(vitri);
		return lstAttrs;
	}
	public void setMasoDK(String masoDK) {
		this.masoDK = masoDK;
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
	public String getSotang() {
		return sotang;
	}
	public void setSotang(String sotang) {
		this.sotang = sotang;
	}
	
	public House(String masoDK, String giatien, String dientich, String quan, String sotang, String vitri) {
		super();
		this.masoDK = masoDK;
		this.giatien = giatien;
		this.dientich = dientich;
		this.quan = quan;
		this.sotang = sotang;
		this.vitri = vitri;
	}
	public String getVitri() {
		return vitri;
	}
	public void setVitri(String vitri) {
		this.vitri = vitri;
	}
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "House [masoDK=" + masoDK + ", giatien=" + giatien + ", dientich=" + dientich + ", quan=" + quan
				+ ", sotang=" + sotang + ", vitri=" + vitri + "]";
	}
	
	

}
