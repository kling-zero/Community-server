// eslint-disable-next-line camelcase
import { export_json_to_excel } from './export2Excel.js';

// 导出列表格式化数据的方法
const formatJson = (filterVal, jsonData, fileName) => {
  return jsonData.map((v) => filterVal.map((j) => v[j]));
};

/** 导出excel
 * @param { Array } dataList 数据源
 * @param { Object } tHeader 表头
 * @param { String } fileName 文件名
 **/
export default (dataList, tHeader, fileName) => {
  const filterVal = [];
  const tHead = [];
  // table表格中对应的属性名
  for (const key in tHeader) {
    
    filterVal.push(key);
    tHead.push(tHeader[key]);
  }
  // 表格绑定数据转json
  const data = formatJson(filterVal, dataList);
  export_json_to_excel(tHead, data, fileName); // 对应下载文件的名字
};
