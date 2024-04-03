#include "stdafx.h"
#include "TestExcel.h"
#include "ExcelComponent.h"
#include "CharsetConvertHepler.h"
using namespace std;

void TestExcel::testExcel()
{
	//创建测试数据
	vector<vector<std::string>> data;
	stringstream ss;
	for (int i = 1; i <= 10; i++)
	{
		vector<std::string> row;
		for (int j = 1; j <= 5; j++)
		{
			ss.clear();
			ss
				<< CharsetConvertHepler::ansiToUtf8("单元格坐标：(") << i
				<< CharsetConvertHepler::ansiToUtf8(",") << j << ")";
			row.push_back(ss.str());
			ss.str("");
		}
		data.push_back(row);
	}

	//定义保存数据位置和页签名称
	std::string fileName = "./public/excel/1.xlsx";
	std::string sheetName = CharsetConvertHepler::ansiToUtf8("数据表");

	//保存到文件
	ExcelComponent excel;
	excel.writeVectorToFile(fileName, sheetName, data);

	//从文件中读取
	auto readData = excel.readIntoVector(fileName, sheetName);
	for (auto row : readData)
	{
		for (auto cellVal : row)
		{
			cout << CharsetConvertHepler::utf8ToAnsi(cellVal) << ",";
		}
		cout << endl;
	}
}
