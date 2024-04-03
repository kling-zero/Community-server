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
	//��ʼ��������
	void initWorkbook(std::string fileName = "");
	//����Sheet
	void createSheet(std::string sheetName);
public:
	//�����и�
	void setRowHeight(double rowHeight);
	//�����п�
	void setColWidth(double colWidth);
	//��ȡָ��ҳǩ���ݵ�����,ע���ļ�·��ʹ��/
	std::vector<std::vector<std::string>> readIntoVector(std::string fileName, std::string sheetName);
	//����ָ��ҳǩ���ݵ��ļ�,ע���ļ�·��ʹ��/
	void writeVectorToFile(std::string fileName, std::string sheetName, std::vector<std::vector<std::string>>& data);
};
#endif // _EXCELCOMPONENT_H_
