# OpenShift for Developers, Oreilly

## Tools
* __git__: We will also use a bit of git, since it is the main way OpenShift interacts with source code. 
* __WildFly__ is an application server that implements the Java Platform, Enterprise Edition specification

__build log__
```
Cloning "https://github.com/leventarican/cookbook-openshift.git " ...
	Commit:	4d4c50e29a6796c8939855b314359846039deaa9 (move project)
	Author:	leventarican <levent@protonmail.com>
	Date:	Sun Jun 2 19:22:40 2019 +0200
Found pom.xml... attempting to build with 'mvn package -Popenshift -DskipTests -B -s /opt/app-root/src/.m2/settings.xml'
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/apache-maven-3.3.9
Java version: 1.8.0_181, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.181-3.b13.el7_5.x86_64/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "3.10.0-862.6.3.el7.x86_64", arch: "amd64", family: "unix"
...
[INFO] Building openshift 0.0.1
...
[INFO] Packaging webapp
[INFO] Assembling webapp [openshift] in [/opt/app-root/src/target/openshift]
[INFO] Processing war project
[INFO] Copying webapp resources [/opt/app-root/src/src/main/webapp]
[INFO] Webapp assembled in [86 msecs]
[INFO] Building war: /opt/app-root/src/target/openshift.war
...
[INFO] BUILD SUCCESS
```

## Troubleshooting
__DNS Issues__

If you have trouble to reach / resolve the the exposed route then you may have issues with DNS. For me the two option worked:
1. whitelist domain xip.io or nip.io in your browser.
```
Domain whitelist under OpenWrt / LEDE:
Network > DHCP and DNS > Domain whitelist > add xip.io or nip.io
```
2. you can also forward the port to localhost. You app will then reachable through localhost:8080
```
oc project <project-name>
oc get pods
oc get endpoints
oc port-forward <pod> 8080:8080
```

__Replace nip.io with xip.io in CDK/Minishift__
* https://developers.redhat.com/blog/2017/12/01/steps-replace-nip-io-xip-io-cdkminishift/
* https://access.redhat.com/documentation/en-us/red_hat_container_development_kit/3.0/html/getting_started_guide/interacting-with-openshift
```
Get the IP address of the Minishift VM.

$ minishift ip


To set the routing suffix to xip.io, run the following command after the IP-ADDRESS with the actual IP address you found from the previous command.

$ minishift openshift config set --patch '{"routingConfig":{"subdomain":"192.168.99.106.xip.io"}}'

minishift openshift config set --patch "{\"routingConfig\": {\"subdomain\": \"192.168.99.106.xip.io\"}}"

"{\"routingConfig\": {\"subdomain\": \"192.168.99.106.nip.io\"}}"
```
