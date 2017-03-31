#!/bin/bash
if [ -d /root/boot/.git ]; then 
    cd /root/boot
    git pull
else 
    cd /root
    echo "git clone --progress ${GIT_REPO:-https://example.com/demo.git} boot"
    git clone --progress ${GIT_REPO:-https://example.com/demo.git} boot
    cd boot
fi

cp bootdocker/filebeat.yml /etc/filebeat/
cp bootdocker/filebeat.template.json /etc/filebeat/
cp bootdocker/filebeat.template-es2x.json /etc/filebeat/

cp bootdocker/packetbeat.yml /etc/packetbeat/
cp bootdocker/packetbeat.template.json /etc/packetbeat/
cp bootdocker/packetbeat.template-es2x.json /etc/packetbeat/

service packetbeat start
service filebeat start

cd ${BOOT_APP:-app}

mvn spring-boot:run ${BOOT_PARAMS}