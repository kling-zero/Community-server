//package com.zeroone.star.project.reportmanagement;
//
//
//import com.zeroone.star.project.query.reportmanagement.NoFeeRoomsQuery;
//import com.zeroone.star.project.query.reportmanagement.RepairStatisticQuery;
//import com.zeroone.star.project.query.reportmanagement.ReportFeeMonthSummaryQuery;
//import com.zeroone.star.project.vo.JsonVO;
//import com.zeroone.star.project.vo.PageVO;
//import com.zeroone.star.project.vo.reportmanagement.*;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//public interface ReportFeeMonthStatisticsApi {
//
//    /**
//     * 查询 报表费用汇总数据
//     * @param reportFeeMonthSummaryQuery
//     * @return
//     */
//    JsonVO<PageVO<ReportFeeMonthStatisticVO>> queryReportFeeSummary(ReportFeeMonthSummaryQuery reportFeeMonthSummaryQuery);
//
//    /**
//     * 查询 报修汇总数据
//     * @param repairStatisticQuery
//     * @return
//     */
//    JsonVO<PageVO<RepairStatisticVO>> queryRepair(RepairStatisticQuery repairStatisticQuery);
//
//    /**
//     * 下载 费用汇总execel表
//     * @param reportFeeMonthSummaryQuery
//     * @return
//     */
//    ResponseEntity<byte[]> downLoadFeeMonthStatisticExcel(ReportFeeMonthSummaryQuery reportFeeMonthSummaryQuery);
//
//    /**
//     * 下载 报修数据汇总表
//     * @param repairStatisticQuery
//     * @return
//     */
//    ResponseEntity<byte[]> downLoadRepairStatisticExcel(RepairStatisticQuery repairStatisticQuery);
//
//    /**
//     * 获取 费用项目菜单
//     * @return
//     */
//    JsonVO<List<ReportFeeTypeMenuVO>> getFeeTypeMenu();
//
//    /**
//     * 获取 报修状态菜单
//     * @return
//     */
//    JsonVO<List<RepairStateMenuVO>> getRepairStateMenu();
//
//    /**
//     * 获取未收费房屋
//     * @param noFeeRoomsQuery
//     * @return
//     */
//    JsonVO<PageVO<NoFeeRoomsVO>> queryNoFeeRooms(NoFeeRoomsQuery noFeeRoomsQuery);
//}
