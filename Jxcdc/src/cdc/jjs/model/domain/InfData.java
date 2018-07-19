package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="inf_data")
public class InfData implements Serializable {

	private static final long serialVersionUID = 48L;
	
	@Id
	@Column(name="inf_id")
	private String infID;
	
	@Column(name="laboratory_number")
	private String laboratoryNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="age")
	private String age;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="address")
	private String address;
	
	@Column(name="accident_date")
	@Temporal(TemporalType.DATE)
	private Date accidentDate;
	
	@Column(name="sampling_date")
	@Temporal(TemporalType.DATE)
	private Date samplingDate;
	
	@Column(name="sampling_company")
	private String samplingCompany;
	
	@Column(name="specimen_species")
	private String SpecimenSpecies;
	
	@Column(name="specimen_source")
	private String SpecimenSource;
	
	@Column(name="collection_date")
	@Temporal(TemporalType.DATE)
	private Date collectionDate;
	
	@Column(name="collection_company")
	private String collectionCompany;
	
	@Column(name="week")
	private String week;

	@Column(name="year")
	private String year;
	
	@OneToOne(targetEntity=InfNuclein.class,mappedBy="infData")
	private InfNuclein infNuclein;
	
	@OneToOne(targetEntity=InfCell.class,mappedBy="infData")
	private InfCell infCell;
	
	@OneToOne(targetEntity=InfEgg.class,mappedBy="infData")
	private InfEgg infEgg;

	public String getInfID() {
		return infID;
	}

	public void setInfID(String infID) {
		this.infID = infID;
	}

	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}

	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public Date getSamplingDate() {
		return samplingDate;
	}

	public void setSamplingDate(Date samplingDate) {
		this.samplingDate = samplingDate;
	}

	public String getSamplingCompany() {
		return samplingCompany;
	}

	public void setSamplingCompany(String samplingCompany) {
		this.samplingCompany = samplingCompany;
	}

	public String getSpecimenSpecies() {
		return SpecimenSpecies;
	}

	public void setSpecimenSpecies(String specimenSpecies) {
		SpecimenSpecies = specimenSpecies;
	}

	public String getSpecimenSource() {
		return SpecimenSource;
	}

	public void setSpecimenSource(String specimenSource) {
		SpecimenSource = specimenSource;
	}

	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionCompany() {
		return collectionCompany;
	}

	public void setCollectionCompany(String collectionCompany) {
		this.collectionCompany = collectionCompany;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public InfNuclein getInfNuclein() {
		return infNuclein;
	}

	public void setInfNuclein(InfNuclein infNuclein) {
		this.infNuclein = infNuclein;
	}

	public InfCell getInfCell() {
		return infCell;
	}

	public void setInfCell(InfCell infCell) {
		this.infCell = infCell;
	}

	public InfEgg getInfEgg() {
		return infEgg;
	}

	public void setInfEgg(InfEgg infEgg) {
		this.infEgg = infEgg;
	}
	
	

}
