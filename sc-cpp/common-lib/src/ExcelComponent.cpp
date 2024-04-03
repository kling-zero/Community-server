#include "pch.h"
#include "../include/ExcelComponent.h"
#include "../include/CommonMacros.h"
#include <iostream>

void ExcelComponent::initWorkbook(std::string fileName /*= ""*/)
{
	wb = xlnt::workbook();
	if (!fileName.empty())
	{
		try
		{
			wb.load(fileName);
		}
		catch (xlnt::exception e)
		{
			std::cout << e.what() << std::endl;
		}
	}
}

void ExcelComponent::createSheet(std::string sheetName)
{
	sheet = wb.active_sheet();
	sheet.title(sheetName);
}

void ExcelComponent::setRowHeight(double rowHeight)
{
	this->rowHeight = rowHeight;
}

void ExcelComponent::setColWidth(double colWidth)
{
	this->colWidth = colWidth;
}

std::vector<std::vector<std::string>> ExcelComponent::readIntoVector(std::string fileName, std::string sheetName)
{
	std::vector<std::vector<std::string>> result;
	initWorkbook(fileName);
	if (!wb.contains(sheetName))
	{
		return result;
	}
	auto sheet = wb.sheet_by_title(sheetName);
	for (auto row : sheet.rows(false))
	{
		std::vector<std::string> aSingleRow;
		for (auto cell : row)
		{
			aSingleRow.push_back(cell.to_string());
		}
		result.push_back(aSingleRow);
	}
	return result;
}

void ExcelComponent::writeVectorToFile(std::string fileName, std::string sheetName, std::vector<std::vector<std::string>>& data)
{
	initWorkbook();
	createSheet(sheetName);
	int row = 1;
	int col = 1;
	for (auto aSignRow : data)
	{
		col = 1;
		for (auto cellVal : aSignRow)
		{
			//���õ�Ԫ��ֵ
			sheet.cell(xlnt::cell_reference(col, row)).value(cellVal);
			//�����п��
			sheet.column_properties(col).custom_width = true;
			sheet.column_properties(col).width = colWidth;
			col++;
		}
		//�����и߶�
		sheet.row_properties(row).custom_height = true;
		sheet.row_properties(row).height = rowHeight;
		row++;
	}

	//�ж�Ŀ¼�Ƿ���ڣ������ڴ���Ŀ¼
	auto dir = fileName.substr(0, fileName.find_last_of("/") + 1);
	const size_t dirLen = dir.length();
	if (dirLen > MAX_DIR_LEN)
	{
		std::cout << "��񱣴�ʧ��<�ļ�·��̫��>" << std::endl;
		return;
	}
	char tmpDirPath[MAX_DIR_LEN] = { 0 };
	for (size_t i = 0; i < dirLen; i++)
	{
		tmpDirPath[i] = dir[i];
		if (tmpDirPath[i] == '/')
		{
			if (ACCESS(tmpDirPath, 0) != 0)
			{
				if (MKDIR(tmpDirPath) != 0)
				{
					std::cout << "��񱣴�ʧ��<�����ļ�ʧ��>��" << tmpDirPath << std::endl;
					return;
				}
			}
		}
	}

	//���浽�ļ�
	wb.save(fileName);
}
