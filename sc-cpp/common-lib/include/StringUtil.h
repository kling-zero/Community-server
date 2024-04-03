#ifndef _STRINGUTIL_H_
#define _STRINGUTIL_H_
#include <vector>
#include <string>
using namespace std;
class StringUtil
{
public:
	static vector<string> split(const string& str,const string& delim);
	static void trim(string& str);
	static void replace(string& base, string src, string dst);
};
#endif // _STRINGUTIL_H_
