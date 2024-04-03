#ifndef _COMMONMACROS_H_
#define _COMMONMACROS_H_

#ifdef LINUX
#include <unistd.h>
#include <sys/stat.h>
#else
#include <io.h>
#include <direct.h> 
#endif

#define MAX_DIR_LEN 512

#ifdef LINUX
#define ACCESS(fileName, accessMode) access(fileName, accessMode)
#define MKDIR(path) mkdir(path, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH)
#else
#define ACCESS(fileName, accessMode) _access(fileName, accessMode)
#define MKDIR(path) _mkdir(path)
#endif

#endif // _COMMONMACROS_H_
