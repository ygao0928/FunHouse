# mysql 为安装mysql的docker
#!/bin/bash
docker_name=funhouse
data_dir="/data/backup/mysql/"
docker exec -it $docker_name mysqldump -uroot -p123456 --all-databases > "$data_dir/solo_`date +%Y%m%d%H%M%S`.sql"
# 删除7天以前的备份
find $data_dir -mtime +14 -name 'solo_*.sql' -exec rm -rf {} \;