package Models;

import java.util.Scanner;

public class House extends Services {
	Scanner sc = new Scanner(System.in);
	private String tieuchuanPhong;
	private String mota;
	private int sotang;
	
	public House() {
		// TODO Auto-generated constructor stub
	}
	
	public House(String id, String tenDV, String dtichSD, float chiPhi, int soLuong, String kieuThue,
			String tieuchuanPhong, String mota, int sotang) {
		super(id, tenDV, dtichSD, chiPhi, soLuong, kieuThue);
		this.tieuchuanPhong = tieuchuanPhong;
		this.mota = mota;
		this.sotang = sotang;
	}



	@Override
	public void showInfo() {
		System.out.println("ID: " + super.getId() + " TenDV " + super.getTenDV() + " Dientich " + super.getDtichSD()
		+ " Chi Phi " + super.getSoLuong() + " kieu thue " + super.getKieuThue() + " TC phong " + this.tieuchuanPhong + " so tang " + this.sotang);
	}



	public String getTieuchuanPhong() {
		return tieuchuanPhong;
	}



	public void setTieuchuanPhong(String tieuchuanPhong) {
		this.tieuchuanPhong = tieuchuanPhong;
	}



	public String getMota() {
		return mota;
	}



	public void setMota(String mota) {
		this.mota = mota;
	}



	public int getSotang() {
		return sotang;
	}



	public void setSotang(int sotang) {
		this.sotang = sotang;
	}
	@Override
	public void input() {
		super.input();
		System.out.println("Tieu chuan phong");
		setTieuchuanPhong(sc.nextLine());
		System.out.println("Mo ta");
		setMota(sc.nextLine());
		System.out.println("So tang");
		setSotang(Integer.parseInt(sc.nextLine()));
	}

	
	
	
}
