#ifndef _EXCELCOMPONENT_H_
#define _EXCELCOMPONENT_H_
#include <xlnt/xlnt.hpp>
#include <string>
#include <vector>
class ExcelComponent
{
private:
	xlnt::workbook wb;
	xlnt::worksheet sheet;
	double rowHeight = 20;
	double colWidth = 20;
	//初始化工作薄
	void initWorkbook(std::string fileName = "");
	//创建Sheet
	void createSheet(std::string sheetName);
public:
	//设置行高
	void setRowHeight(double rowHeight);
	//设置列宽
	void setColWidth(double colWidth);
	//读取指定页签内容到容器,注意文件路径使用/
	std::vector<std::vector<std::string>> readIntoVector(std::string fileName, std::string sheetName);
	//保存指定页签内容到文件,注意文件路径使用/
	void writeVectorToFile(std::string fileName, std::string sheetName, std::vector<std::vector<std::string>>& data);
};
#endif // _EXCELCOMPONENT_H_
