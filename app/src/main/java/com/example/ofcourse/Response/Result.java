package com.example.ofcourse.Response;

import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("pendidikan")
	private String pendidikan;

	@SerializedName("upah")
	private int upah;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("ket_guru")
	private String ketGuru;

	@SerializedName("nama_mapel")
	private String namaMapel;

	@SerializedName("id_guru")
	private int idGuru;

	@SerializedName("nama_guru")
	private String namaGuru;

	@SerializedName("alamat")
	private String alamat;

	public void setPendidikan(String pendidikan){
		this.pendidikan = pendidikan;
	}

	public String getPendidikan(){
		return pendidikan;
	}

	public void setUpah(int upah){
		this.upah = upah;
	}

	public int getUpah(){
		return upah;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setKetGuru(String ketGuru){
		this.ketGuru = ketGuru;
	}

	public String getKetGuru(){
		return ketGuru;
	}

	public void setNamaMapel(String namaMapel){
		this.namaMapel = namaMapel;
	}

	public String getNamaMapel(){
		return namaMapel;
	}

	public void setIdGuru(int idGuru){
		this.idGuru = idGuru;
	}

	public int getIdGuru(){
		return idGuru;
	}

	public void setNamaGuru(String namaGuru){
		this.namaGuru = namaGuru;
	}

	public String getNamaGuru(){
		return namaGuru;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}