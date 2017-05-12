package com.szp.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private File file;
	private String fileFileName;
	private String fileContentType;
	private String startRow;
	private String endRow;
	private String startCell;
	private String endCell;

	private Map<String, Object> parameters = (Map<String, Object> )ActionContext.getContext().get("request");
	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Override
	public String execute() throws Exception {
		
		
		
		
		
		//获取文件上传的文件流
		FileInputStream inputStream = new FileInputStream(file);
		//删除缓存文件
		file.delete();
		//创建工作簿对象
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		//关闭文件流
		inputStream.close();
		//创建第一个表对象
		HSSFSheet sheet = workbook.getSheetAt(0);
		//获取表的所有行数
		int rows = sheet.getPhysicalNumberOfRows();
		//获取表的所有列数
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		//创建存放表内容的二位数组
		String[][] content = new String[rows][cells];
		//循环遍历
		for (int i = 0; i < rows; i++) {
			//获取行对象
			HSSFRow row = sheet.getRow(i);
			//循环遍历列
			for (int j = 0; j < cells; j++) {
				//获取列对象
				HSSFCell cell = row.getCell(j);
				//用于存放单元格内容
				String info = null;
				//判空，否则有可能报空指针
				if (cell != null) {//判断单元格内容格式
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_STRING:
						info = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						info = String.valueOf(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						info = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						info = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						try {
							info = String.valueOf(cell.getNumericCellValue());
						} catch (IllegalStateException e) {
							info = String.valueOf(cell.getRichStringCellValue());
						}
						break;
					}
				}
				content[i][j] = info;
			}
		}
		//创建行数组，用于遍历下拉列表
		int[] rowsArray = new int[rows];
		int[] cellsArray = new int[cells];
		
		for (int i = 0; i < rowsArray.length; i++) {
			rowsArray[i] = i;
		}

		for (int i = 0; i < cellsArray.length; i++) {
			cellsArray[i] = i;
		}
		//
		session.put("content", content);
		session.put("rows", rowsArray);
		session.put("cells", cellsArray);
		session.put("flag", false);

		// Map<String, Object> application =
		// ActionContext.getContext().getApplication();

		return SUCCESS;
	}

	public String show() {
		// Map<String, Object> application =
		// ActionContext.getContext().getApplication();
		parameters.put("flag", true);
		parameters.put("startRow", Integer.parseInt(startRow));
		parameters.put("endRow", Integer.parseInt(endRow));
		parameters.put("startCell", Integer.parseInt(startCell));
		parameters.put("endCell", Integer.parseInt(endCell));
		return SUCCESS;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getStartRow() {
		return startRow;
	}

	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}

	public String getEndRow() {
		return endRow;
	}

	public void setEndRow(String endRow) {
		this.endRow = endRow;
	}

	public String getStartCell() {
		return startCell;
	}

	public void setStartCell(String startCell) {
		this.startCell = startCell;
	}

	public String getEndCell() {
		return endCell;
	}

	public void setEndCell(String endCell) {
		this.endCell = endCell;
	}

}
