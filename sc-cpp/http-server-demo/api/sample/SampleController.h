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
	//��ʾ��ѯ����
	JsonVO<PageVO<SampleVO>> execQuerySample(SampleQuery query, PayloadDTO payload);
	//��ʾ��������
	JsonVO<uint64_t> execAddSample(SampleDTO dto);
	//��ʾ�޸�����
	JsonVO<long> execModifySample(SampleDTO dto);
	//��ʾɾ������
	JsonVO<long> execRemoveSample(SampleDTO dto);
	JsonVO<long> execRemoveById(ID id);
	//��ʾJSON�ύ
	JsonVO<SampleVO> execJsonSample(SampleDTO dto);
};

#endif // _SAMPLE_CONTROLLER_