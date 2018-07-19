package cdc.jjs.control.inf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.csvreader.CsvReader;
import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.service.InfService;

public class InfDataImportAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private InfService infService;
	public InfService getInfService() {
		return infService;
	}
	public void setInfService(InfService infService) {
		this.infService = infService;
	}
	
	private File InfImport;
	private String InfImportContentType;
	private String InfImportFileName;
	public File getInfImport() {
		return InfImport;
	}
	public void setInfImport(File infImport) {
		InfImport = infImport;
	}
	public String getInfImportContentType() {
		return InfImportContentType;
	}
	public void setInfImportContentType(String infImportContentType) {
		InfImportContentType = infImportContentType;
	}
	public String getInfImportFileName() {
		return InfImportFileName;
	}
	public void setInfImportFileName(String infImportFileName) {
		InfImportFileName = infImportFileName;
	}
	
	private String savePath;
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	private String importTip;
	public String getImportTip() {
		return importTip;
	}
	public void setImportTip(String importTip) {
		this.importTip = importTip;
	}
	
	@Override
	public String execute() throws Exception {
		
		FileOutputStream fos = new FileOutputStream(getSavePath() + "/" + "Inf.CSV");
		FileInputStream fis = new FileInputStream(InfImport);	
		byte[] buffer = new byte[2048];
		int len = 0;
		while((len = fis.read(buffer)) > 0) {
			fos.write(buffer , 0 , len); 
		}
		fis.close();
		fos.close();
		

		CsvReader csvReader = new CsvReader(savePath + "/" + "Inf.CSV" , ',' , Charset.forName("GBK"));
		csvReader.readHeaders();
		String[] head = csvReader.getHeaders();
		
		List<String> list = Arrays.asList(head);
		
		if(list.contains("接种日期") && list.contains("原始标本PCR鉴定结果") && list.contains("毒株送检日期(NIC)") && list.contains("毒株送检日期(省级)")) {
			long startTime=System.currentTimeMillis();
			System.out.println(infService.saveAndUpdateInf(getSavePath() + "/" + "Inf.CSV"));
			long endTime=System.currentTimeMillis();
			System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		}
		
		csvReader.close();
		
		importTip="导入完成";
				
		return SUCCESS;
	}
	
	
	

}
