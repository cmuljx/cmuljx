package cdc.jjs.control.rabise.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.service.RabiseService;

public class RabiseDataToExcel extends ActionSupport {

private static final long serialVersionUID = 48L;
	
	private String queryLaboratoryNumber;
	private String queryName;
	private String queryTime1;
	private String queryTime2;	
	public String getQueryLaboratoryNumber() {
		return queryLaboratoryNumber;
	}
	public void setQueryLaboratoryNumber(String queryLaboratoryNumber) {
		this.queryLaboratoryNumber = queryLaboratoryNumber;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQueryTime1() {
		return queryTime1;
	}
	public void setQueryTime1(String queryTime1) {
		this.queryTime1 = queryTime1;
	}
	public String getQueryTime2() {
		return queryTime2;
	}
	public void setQueryTime2(String queryTime2) {
		this.queryTime2 = queryTime2;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	private String checkNum;
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	
	private InputStream excelFile;
	private String fileName;
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String execute() throws Exception {
		fileName = "rabise.xls";
        fileName= new String(fileName.getBytes("UTF-8"),"ISO8859-1");
		HSSFWorkbook wb = rabiseService.rabiseDataToExcel(queryLaboratoryNumber, queryName, queryTime1, queryTime2);		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
        wb.write(output);
        byte[] ba = output.toByteArray();
        setExcelFile(new ByteArrayInputStream(ba));
        output.flush();
        output.close();
		return SUCCESS;
	}



}
