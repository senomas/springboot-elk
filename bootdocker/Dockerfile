FROM ubuntu:16.04
MAINTAINER Senomas <agus@senomas.com>

ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && \
   apt-get install -y software-properties-common python-software-properties vim net-tools git make curl wget apt-transport-https
RUN git config --global credential.helper cache
RUN add-apt-repository ppa:webupd8team/java && \
   wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | apt-key add - && \
   echo "deb https://artifacts.elastic.co/packages/5.x/apt stable main" | tee -a /etc/apt/sources.list.d/elastic-5.x.list && \
   apt-get update && \
   echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
   echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections && \
   apt-get install -y oracle-java8-installer maven packetbeat filebeat

WORKDIR /root
ADD springboot.sh /root/springboot.sh

ENTRYPOINT ["/root/springboot.sh"]