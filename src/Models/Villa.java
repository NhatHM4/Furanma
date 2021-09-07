package Models;

import java.util.Scanner;

public class Villa extends Services {
	Scanner sc = new Scanner(System.in);
	private String tieuchuanPhong;
	private String mota;
	private float dtichHoBoi;
	private int soTang;

	public Villa(String id, String tenDV, String dtichSD, float chiPhi, int soLuong, String kieuThue,
			String tieuchuanPhong, String mota, float dtichHoBoi, int soTang) {
		super(id, tenDV, dtichSD, chiPhi, soLuong, kieuThue);
		this.tieuchuanPhong = tieuchuanPhong;
		this.mota = mota;
		this.dtichHoBoi = dtichHoBoi;
		this.soTang = soTang;
	}
	
	public Villa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showInfo() {
		System.out.println("ID: " + super.getId() + " TenDV " + super.getTenDV() + " Dientich " + super.getDtichSD()
				+ " Chi Phi " + super.getSoLuong() + " kieu thue " + super.getKieuThue() + " TC phong " + this.tieuchuanPhong);
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

	public float getDtichHoBoi() {
		return dtichHoBoi;
	}

	public void setDtichHoBoi(float dtichHoBoi) {
		this.dtichHoBoi = dtichHoBoi;
	}

	public int getSoTang() {
		return soTang;
	}

	public void setSoTang(int soTang) {
		this.soTang = soTang;
	}

	@Override
	public void  input() {
		super.input();
		System.out.println("Tieu chuan phong");
		setTieuchuanPhong(sc.nextLine());
		System.out.println("Mo ta");
		setMota(sc.nextLine());
		System.out.println("Dien tich ho boi");
		setDtichHoBoi(Float.parseFloat(sc.nextLine()));
		System.out.println("So tang");
		setSoTang(Integer.parseInt(sc.nextLine()));
	}
}
