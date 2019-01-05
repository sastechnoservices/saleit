package com.saleit.domains;

public class Image {

	private String imageId;
	private String imageArray;
	public Image() {
		super();
	}
	public Image(String imageId, String imageArray) {
		super();
		this.imageId = imageId;
		this.imageArray = imageArray;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageArray() {
		return imageArray;
	}
	public void setImageArray(String imageArray) {
		this.imageArray = imageArray;
	}
	
	
}
