@rem �ر����������
@echo off
setlocal enabledelayedexpansion

@rem ===================���ƻ�����===================
echo --------------------------------
echo ���������ڸ���demo�б�����Դ������ģ����
echo ��Ҫ�������½�ģ������,(������ģ�����ڵ��ļ���·��)
set /p "newm=����ģ������(�磺sample)��"
echo --------------------------------
@rem ================================================

@rem ִ�и����߼�
xcopy http-server-demo !newm! /S /Y /EXCLUDE:exclude.txt
@rem ����һЩ��Ŀ¼��֤�ṹ����
md !newm!\dao !newm!\service
echo �ļ��������
pause