#pragma once
#ifndef _PAYMENTCD_H_
#define _PAYMENTCD_H_
#include"../../GlobalInclude.h"
class PaymentCdVO {
	CC_SYNTHESIZE(int, id, ID);
	CC_SYNTHESIZE(std::string, name, Name);

public:
	BIND_TO_JSON(PaymentCdVO, id, name);

	PaymentCdVO() {
		id = 0;
		name = u8"Ô¤¸¶·Ñ";
	}
};
#endif // !_PAYMENTCD_H_
