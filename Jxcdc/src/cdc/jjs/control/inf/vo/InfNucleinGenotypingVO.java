package cdc.jjs.control.inf.vo;

public class InfNucleinGenotypingVO {
	
	private String group;
	private int year;
	private int week;
	private Long H3;
	private Long SH1;
	private Long victoria;
	private Long yamagata;
	private Long negative;
	private Long total;
	private double positiveRate;
	
	public InfNucleinGenotypingVO() {
		
	}
	
	public InfNucleinGenotypingVO(int year,int week,Long H3,Long SH1,Long victoria,Long yamagata,Long negative,Long total) {
		this.year = year;
		this.week = week;
		this.H3 = H3;
		this.SH1 = SH1;
		this.victoria = victoria;
		this.yamagata = yamagata;
		this.negative = negative;
		this.total = total;
	}
	
	public InfNucleinGenotypingVO(String group,Long H3,Long SH1,Long victoria,Long yamagata,Long negative,Long total) {
		this.group = group;
		this.H3 = H3;
		this.SH1 = SH1;
		this.victoria = victoria;
		this.yamagata = yamagata;
		this.negative = negative;
		this.total = total;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Long getH3() {
		return H3;
	}
	public void setH3(Long h3) {
		H3 = h3;
	}
	public Long getSH1() {
		return SH1;
	}
	public void setSH1(Long sH1) {
		SH1 = sH1;
	}
	public Long getVictoria() {
		return victoria;
	}
	public void setVictoria(Long victoria) {
		this.victoria = victoria;
	}
	public Long getYamagata() {
		return yamagata;
	}
	public void setYamagata(Long yamagata) {
		this.yamagata = yamagata;
	}
	public Long getNegative() {
		return negative;
	}
	public void setNegative(Long negative) {
		this.negative = negative;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	public double getPositiveRate() {
		return positiveRate;
	}

	public void setPositiveRate(double positiveRate) {
		this.positiveRate = positiveRate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
	
 
}
