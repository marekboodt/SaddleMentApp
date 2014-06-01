package com.example.saddlement;

public class PakkettenTabel {
	
	private int id;
	//private int pakketID;
	private String afleveradres;
	private String status;
	//private int gewicht;
	//private String afmetingen;
	//private String aankomst;
	
	
	public PakkettenTabel(){}
	
	public PakkettenTabel(String afleveradres, String status){
		super();
	//	this.pakketID = pakketID;
		this.afleveradres = afleveradres;
		this.status = status;
	//	this.gewicht = gewicht;
		//this.afmetingen = afmetingen;
	//	this.aankomst = aankomst;
	}
	
	/*
	
	@Override
	public String toString() {
		return "PakkettenTabel [id=" + id + ", "
				+ "pakketID=" + pakketID + ", "
				+ "afleveradres=" + afleveradres + ","
				+ "status=" + status + ", "
				+ "gewicht=" + gewicht + ", "
				+ "afmetingen=" + afmetingen + ", "
				+ "aankomst=" + aankomst
				+ "]";
		
	}
	*/
	@Override
    public String toString() {
        return "Book [id=" + id + ", afleveradres=" + afleveradres + ", status=" + status
                + "]";
    }

	public String getAfleveradres() {
		return afleveradres;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAfleveradres(String afleveradres) {
		// TODO Auto-generated method stub
		this.afleveradres = afleveradres;
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
}
