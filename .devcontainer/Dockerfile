# For development by VSCode

# Main stage -------------------------------------------------
FROM centos:8.1.1911
LABEL Name=FRONTEO Version=0.0.1

# Localize
RUN yum -y update && yum -y upgrade && \
    yum -y install glibc-locale-source glibc-langpack-ja && \
    localedef -i /usr/share/i18n/locales/ja_JP -f UTF-8 /usr/lib/locale/ja_JP.UTF-8
ENV TZ=Asia/Tokyo LANG=ja_JP.UTF-8 LANGUAGE=ja_JP:ja LC_ALL=ja_JP.UTF-8

# Install Tools
COPY ./conf/adoptopenjdk.repo /etc/yum.repos.d/adoptopenjdk.repo
RUN yum install -y lsof wget sudo git adoptopenjdk-11-hotspot
ENV JAVA_HOME=/usr/lib/jvm/adoptopenjdk-11-hotspot/

EXPOSE 80 8080
