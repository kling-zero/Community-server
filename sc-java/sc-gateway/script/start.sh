#!bin/bash
app_name='sc-gateway'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker run -p 12000:12000 --name ${app_name} \
-v /etc/localtime:/etc/localtime \
-v /home/app/${app_name}/logs:/tmp/logs \
-d 01star/${app_name}:1.0.0-SNAPSHOT
echo '----start container----'