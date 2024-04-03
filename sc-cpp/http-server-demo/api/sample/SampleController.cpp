#include "stdafx.h"
#include "SampleController.h"
#include "../../service/sample/SampleService.h"

JsonVO<PageVO<SampleVO>> SampleController::execQuerySample(SampleQuery query, PayloadDTO payload)
{
	//����һ��Service
	SampleService service;
	//��ѯ����
	PageVO<SampleVO> result = service.listAll(query);
	//��Ӧ���
	return JsonVO<PageVO<SampleVO>>(result, RS_SUCCESS);
}

JsonVO<uint64_t> SampleController::execAddSample(SampleDTO dto)
{
	JsonVO<uint64_t> result;
	SampleService service;
	//ִ����������
	uint64_t id = service.saveData(dto);
	if (id > 0) {
		result.success(id);
	}
	else {
		result.fail(id);
	}
	//��Ӧ���
	return result;
}

JsonVO<long> SampleController::execModifySample(SampleDTO dto)
{
	SampleService service;
	JsonVO<long> result;
	if (service.updateData(dto)) {
		result.success(dto.getId());
	}
	else {
		result.fail(dto.getId());
	}
	return result;
}

JsonVO<long> SampleController::execRemoveSample(SampleDTO dto)
{
	SampleService service;
	JsonVO<long> result;
	//ִ������ɾ��
	if (service.removeData(dto.getId())) {
		result.success(dto.getId());
	}
	else {
		result.fail(dto.getId());
	}
	//��Ӧ���
	return result;
}

JsonVO<long> SampleController::execRemoveById(ID id)
{
	SampleDTO dto;
	dto.setId(id.getId());
	return execRemoveSample(dto);
}

JsonVO<SampleVO> SampleController::execJsonSample(SampleDTO dto)
{
	//����һ������VO
	SampleVO vo;
	vo.setId(dto.getId());
	vo.setName(dto.getName());
	vo.setAge(dto.getAge());
	vo.setSex(dto.getSex());

	//��Ӧ���
	return JsonVO<SampleVO>(vo, RS_API_UN_IMPL);
}
