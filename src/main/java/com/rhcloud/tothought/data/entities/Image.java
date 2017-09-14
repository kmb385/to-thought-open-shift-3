package com.rhcloud.tothought.data.entities;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="IMAGE")
public class Image {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMAGE_ID")
	public Integer imageId;
	
	@Column(name="NAME")
	public String name;
	
	@Column(name="TYPE")
	public String type;
	
	@Column(name="FILE", columnDefinition="longblob")
	public byte[] file;
	
	public Image(){
		
	}
	
	public Image(MultipartFile file){
		try {
			this.file = file.getBytes();
			this.name = file.getOriginalFilename();
			this.type = file.getContentType();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
