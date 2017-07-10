package readdata;

import java.io.Console;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class Attributes {
	private static final String[] LOAIVITRI = {"mattien", "hemxehoi", "nhahaimattien","hem"};
	private static final String[] LOAIGIATIEN = {"triệu/m²","triệu", "tỷ"};
	private static final String[] QUAN = {"quận 10","quận 11","quận 12","quận 3","quận 4","quận 5"
			,"quận 6","quận 7","quận 8","quận 9","quận 1","quận 2","quận bình tân","quận bình thạnh","quận gò vấp",
			"huyện hóc môn","quận tân bình","quận tân phú","quận thủ đức","huyện bình chánh","huyện nhà bè","quận phú nhuận",
			"huyện cần giờ","huyện củ chi"};
	private static final String[] FINALQUAN = {"quan10","quan11","quan12","quan3","quan4","quan5","quan6","quan7","quan8","quan9",
			"quan1","quan2","binhtan","binhthanh","govap","hocmon","tanbinh","tanphu","thuduc","binhchanh","nhabe","phunhuan","cangio","cuchi"};
	private String regex;
	private String loaivitri;
	private ObjectFile dataFile;
	private House house;
	public House getHouse(ObjectFile objectFile) {
		setDataFile(objectFile);
		setHouse();
		return house;
	}
	public void setHouse(){
		House house = new House();
		house.setDientich(this.getDientich());
		house.setGiatien(this.getGiaTien());
		house.setMasoDK(dataFile.getMasoDK());
		house.setQuan(this.getQuan());
		house.setSotang(this.getTang());
		house.setVitri(this.getViTri());
		this.house = house;
		
	}
	public ObjectFile getDataFile() {
		return dataFile;
	}
	public void setDataFile(ObjectFile dataFile) {
		this.dataFile = dataFile;
	}
		public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public Attributes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Attributes(String loaivitri, String regex) {
		super();
		this.loaivitri = loaivitri;
		this.regex = regex;
	}
	public ArrayList<Attributes> tudienlist(){
		ArrayList<Attributes> tudienlst = new ArrayList<>();
		Attributes hxh12 = new Attributes(LOAIVITRI[1], "mặt tiền hxh");
		Attributes hxh13 = new Attributes(LOAIVITRI[1], "mặt tiền hẻm xe hơi");
		tudienlst.add(hxh12);tudienlst.add(hxh13);
		
		Attributes hxh1 = new Attributes(LOAIVITRI[1], "bán nhà hẻm xe hơi");
		Attributes hxh2 = new Attributes(LOAIVITRI[1], "bán nhà hxh");
		Attributes hxh3 = new Attributes(LOAIVITRI[1], "mt hxh");
		Attributes hxh4 = new Attributes(LOAIVITRI[1], "bán gấp nhà hẻm xe hơi");
		Attributes hxh5 = new Attributes(LOAIVITRI[1], "bán căn nhà hẻm xe hơi");
		Attributes hxh6 = new Attributes(LOAIVITRI[1], "bán căn nhà hẻm xe tả");
		tudienlst.add(hxh1);tudienlst.add(hxh2);
		tudienlst.add(hxh3);tudienlst.add(hxh4);
		tudienlst.add(hxh5);tudienlst.add(hxh6);		
		Attributes hxh7 = new Attributes(LOAIVITRI[1], "bán gấp nhà hxh");
		Attributes hxh8 = new Attributes(LOAIVITRI[1], "bán gấp nhà hẻm ô tô");
		Attributes hxh9 = new Attributes(LOAIVITRI[1], "bán gấp nhà hẻm ôtô");
		Attributes hxh10 = new Attributes(LOAIVITRI[1], "bán hẻm xe hơi");
		Attributes hxh11 = new Attributes(LOAIVITRI[1], "bán nhà riêng hxh");
		
		Attributes hem1 = new Attributes(LOAIVITRI[3], "mặt tiền hẻm");
		Attributes hem2 = new Attributes(LOAIVITRI[3], "mt hẻm");
		Attributes hem3 = new Attributes(LOAIVITRI[3], "bán nhà hẻm");
		tudienlst.add(hem1);tudienlst.add(hem2);
		tudienlst.add(hem3);
		tudienlst.add(hxh7);tudienlst.add(hxh8);
		tudienlst.add(hxh9);tudienlst.add(hxh10);
		tudienlst.add(hxh11);
		Attributes mt1 = new Attributes(LOAIVITRI[0], "bán nhà mặt tiền");
		Attributes mt2 = new Attributes(LOAIVITRI[0], "bán gấp nhà mt");
		Attributes mt3 = new Attributes(LOAIVITRI[0], "bán nhà mt");
		Attributes mt4 = new Attributes(LOAIVITRI[0], "bán nhà riêng măt tiền");
		Attributes mt5 = new Attributes(LOAIVITRI[0], "bán căn nhà mặt tiền");
		Attributes mt6 = new Attributes(LOAIVITRI[0], "bán gấp căn nhà mặt tiền");
		Attributes mt7 = new Attributes(LOAIVITRI[0], "bán gấp căn nhà mt");
		tudienlst.add(mt1);tudienlst.add(mt2);
		tudienlst.add(mt3);tudienlst.add(mt4);
		tudienlst.add(mt5);tudienlst.add(mt6);
		tudienlst.add(mt7);
		
		Attributes haimt1 = new Attributes(LOAIVITRI[2], "bán nhà 2 mặt tiền");
		Attributes haimt2 = new Attributes(LOAIVITRI[2], "nhà hai mặt tiền");
		Attributes haimt3 = new Attributes(LOAIVITRI[2], "bán gấp nhà 2 mặt tiền");
		Attributes haimt4 = new Attributes(LOAIVITRI[2], "bán căn nhà 2 mặt tiền");
		tudienlst.add(haimt1);tudienlst.add(haimt2);
		tudienlst.add(haimt3);tudienlst.add(haimt4);

		Attributes hem13 = new Attributes(LOAIVITRI[3], "nhà sau lưng mặt tiền");
		Attributes hem4 = new Attributes(LOAIVITRI[3], "bán nhà hẻm");
		Attributes hem5 = new Attributes(LOAIVITRI[3], "bán gấp nhà hẻm");
		Attributes hem6 = new Attributes(LOAIVITRI[3], "bán nhanh nhà hẻm");
		Attributes hem7 = new Attributes(LOAIVITRI[3], "nhà bán hẻm");
		Attributes hem8 = new Attributes(LOAIVITRI[3], "bán gấp căn nhà hẻm");
		Attributes hem9 = new Attributes(LOAIVITRI[3], "bán căn nhà hẻm");
		Attributes hem10 = new Attributes(LOAIVITRI[3], "căn nhà nằm trong hẻm");
		Attributes hem11 = new Attributes(LOAIVITRI[3], "bán nhà 2 mặt hẻm");
		tudienlst.add(hem4);tudienlst.add(hem5);
		tudienlst.add(hem6);tudienlst.add(hem7);
		tudienlst.add(hem8);tudienlst.add(hem9);
		tudienlst.add(hem10);tudienlst.add(hem11);tudienlst.add(hem13);
		Attributes hxh14 = new Attributes(LOAIVITRI[1], "hxh");
		Attributes hxh15 = new Attributes(LOAIVITRI[1], "hẻm xe hơi");
		Attributes hem12 = new Attributes(LOAIVITRI[3], "nhà hẻm");
		Attributes mt8 = new Attributes(LOAIVITRI[0], "nhà mặt tiền");
		Attributes hem14 = new Attributes(LOAIVITRI[3], "nhà 2 mặt hẻm");
		Attributes hem15 = new Attributes(LOAIVITRI[3], "hẻm");
		Attributes hem16 = new Attributes(LOAIVITRI[3], "nhà cách mặt tiền");
		tudienlst.add(hxh14);tudienlst.add(hxh15);
		tudienlst.add(hem12);tudienlst.add(mt8);
		tudienlst.add(hem14);tudienlst.add(hem15);
		tudienlst.add(hem16);
		return tudienlst;
	}
	public String getViTri(){
		String text = this.dataFile.getMota();
		ArrayList<Attributes> tudienlist = tudienlist();
		for (Attributes Attributes : tudienlist) {
			Pattern pattern = Pattern.compile(Attributes.regex); 
			Matcher matcher = pattern.matcher(text);
			if(matcher.find()) return Attributes.loaivitri;
		}
		 
		return null;
	}
	public String getDientich(){
		String text = this.dataFile.getDientich();
		String dientich = text.replace("m²","");
		
		return dientich;
	}
	public String getGiaTien(){
		String clgiatien = this.dataFile.getGiatien();
		String cldientich = this.dataFile.getDientich();
		for (String string : LOAIGIATIEN) {
			Pattern pattern = Pattern.compile(string); 
			Matcher matcher = pattern.matcher(clgiatien);
			if(matcher.find()){
				String giatien = clgiatien.substring(0, clgiatien.length() - string.length() - 2);
				System.out.println(giatien);
				if(string == "tỷ") return Double.parseDouble(giatien) * 1000 + "";
				if(string == "triệu/m²") return Double.parseDouble(giatien) * Double.parseDouble(cldientich.replace("m²","")) + "";
				
				return Double.parseDouble(giatien) + "";
			}
		}
		return null;
	}
	public String getQuan(){
		String quan = this.dataFile.getQuan();
		for (int i = 0;i < QUAN.length;i++) {
			Pattern pattern = Pattern.compile(QUAN[i]); 
			Matcher matcher = pattern.matcher(quan);
			if(matcher.find()){
				return FINALQUAN[i];
			}
		}
		return null;
	}
	public String getTang(){
		String tang = this.dataFile.getSotang();
		if(tang.length() > 7){
			String sotang = tang.substring(0,tang.length()-7);
			return sotang;
		}
		return null;
	}

}
