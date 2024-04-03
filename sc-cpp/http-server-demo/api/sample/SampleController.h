#ifndef _SAMPLE_CONTROLLER_
#define _SAMPLE_CONTROLLER_

#include "../../domain/query/sample/SampleQuery.h"
#include "../../domain/dto/sample/SampleDTO.h"
#include "../../domain/dto/IDDTO.h"
#include "../../domain/vo/sample/SampleVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/JsonVO.h"

class SampleController
{
public:
	CREATE_API_FUN_QUERY_PAYLOAD(querySample, execQuerySample, SampleQuery);
	CREATE_API_FUN_BODY(addSample, execAddSample, SampleDTO);
	CREATE_API_FUN_BODY(modifySample, execModifySample, SampleDTO);
	CREATE_API_FUN_BODY(removeSample, execRemoveSample, SampleDTO);
	CREATE_API_FUN_BODY(removeById, execRemoveById, ID);
	CREATE_API_FUN_JSON(jsonSample, execJsonSample, SampleDTO);
private:
	//演示查询数据
	JsonVO<PageVO<SampleVO>> execQuerySample(SampleQuery query, PayloadDTO payload);
	//演示新增数据
	JsonVO<uint64_t> execAddSample(SampleDTO dto);
	//演示修改数据
	JsonVO<long> execModifySample(SampleDTO dto);
	//演示删除数据
	JsonVO<long> execRemoveSample(SampleDTO dto);
	JsonVO<long> execRemoveById(ID id);
	//演示JSON提交
	JsonVO<SampleVO> execJsonSample(SampleDTO dto);
};

#endif // _SAMPLE_CONTROLLER_