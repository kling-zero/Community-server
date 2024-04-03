#ifndef _CHARSETCONVERTHEPLER_H_
#define _CHARSETCONVERTHEPLER_H_
#include <string>
class CharsetConvertHepler
{
public:
	static std::string unicodeToUtf8(const std::wstring& wstr);
	static std::wstring utf8ToUnicode(const std::string& str);
	static std::string unicodeToAnsi(const std::wstring& wstr);
	static std::wstring ansiToUnicode(const std::string& str);
	static std::string utf8ToAnsi(const std::string& str);
	static std::string ansiToUtf8(const std::string& str);
};
#endif // _CHARSETCONVERTHEPLER_H_
