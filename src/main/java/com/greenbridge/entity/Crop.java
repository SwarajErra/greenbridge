package com.greenbridge.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cropId;
	private String cropName;
	private Double approximateQuantity;
	private String qualityDescriotion;
	private byte[] samplePic;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Farmer farmer;
	
	


	
	
	
    public Crop() {
    	
    }


	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	public Double getApproximateQuantity() {
		return approximateQuantity;
	}


	public void setApproximateQuantity(Double approximateQuantity) {
		this.approximateQuantity = approximateQuantity;
	}


	public String getQualityDescriotion() {
		return qualityDescriotion;
	}


	public void setQualityDescriotion(String qualityDescriotion) {
		this.qualityDescriotion = qualityDescriotion;
	}


	public byte[] getSamplePic() {
		return samplePic;
	}

	
	public Integer getCropId() {
		return cropId;
	}


	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}


	public void setSamplePic(byte[] samplePic) {
		this.samplePic = samplePic;
	}
    
    
	
	
	
	
	

}
