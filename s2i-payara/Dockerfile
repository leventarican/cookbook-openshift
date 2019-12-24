# payara-builderimage

# base image
FROM azul/zulu-openjdk:8u222

LABEL maintainer="levent@protonmail.com"

# Set labels used in OpenShift to describe the builder image
LABEL io.k8s.description="Platform for serving java apps - powered by payara" \
      io.k8s.display-name="payara server full 5.194" \
      io.openshift.expose-services="8080:http" \
      io.openshift.tags="payara server full profile 5.194, java, microprofile"


RUN groupadd -g 1000 payara && \
    useradd -u 1000 -M -s /bin/bash -d /opt/payara5 payara -g payara && \
    echo payara:payara | chpasswd
    # user_name:password

# ##############################################################################
# https://github.com/payara/docker-payaraserver-full/blob/master/Dockerfile

# RUN apt-get install -y unzip && \
#     apt-get install -y wget && \
#     wget --no-verbose -O payara.zip ${PAYARA_PKG} && \
#     unzip -qq payara.zip -d ./ && \
#     mv payara*/ appserver && \

RUN apt-get update -y && \
    apt-get install -y unzip && \
    apt-get install -y wget && \
    wget https://search.maven.org/remotecontent?filepath=fish/payara/distributions/payara/5.194/payara-5.194.zip -O payara.zip && \
    unzip -d /opt payara.zip
    # ls /opt/payara5

# Default payara ports to expose
# 4848: admin console
# 9009: debug port (JPDA)
# 8080: http
# 8181: https
# EXPOSE 4848 9009 8080 8181

WORKDIR /opt/payara
USER payara

# CMD ["/usr/libexec/s2i/usage"]
