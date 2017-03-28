#!/bin/bash
if [ -d /root/app/.git ]; then 
    cd /root/app
    git pull
else 
    cd /root
    git clone --progress ${GIT_REPO:-https://example.com/demo.git} boot
fi

cp bootdocker/filebeat.yml /etc/filebeat/
cp bootdocker/filebeat.template.json /etc/filebeat/
cp bootdocker/filebeat.template-es2x.json /etc/filebeat/

cp bootdocker/packetbeat.yml /etc/packetbeat/
cp bootdocker/packetbeat.template.json /etc/packetbeat/
cp bootdocker/packetbeat.template-es2x.json /etc/packetbeat/

service packetbeat start
service filebeat start

cd boot/${BOOT_APP:-app}

mvn spring-boot:run ${BOOT_PARAMS}