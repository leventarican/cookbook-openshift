# OpenShift for Developers, Oreilly

## Tools
* __git__: We will also use a bit of git, since it is the main way OpenShift interacts with source code. 
* __WildFly__ is an application server that implements the Java Platform, Enterprise Edition specification


__build log__
```
Cloning "https://github.com/leventarican/cookbook-openshift.git " ...
	Commit:	50987aa4232e4c750d3599756c1b1f09506aee14 (add a simple webapp)
	Author:	leventarican <levent@protonmail.com>
	Date:	Sun Jun 2 01:08:02 2019 +0200
Moving binaries in source directory into /wildfly/standalone/deployments for later deployment...
Moving all war artifacts from /opt/app-root/src/. directory into /wildfly/standalone/deployments for later deployment...
Moving all ear artifacts from /opt/app-root/src/. directory into /wildfly/standalone/deployments for later deployment...
Moving all rar artifacts from /opt/app-root/src/. directory into /wildfly/standalone/deployments for later deployment...
Moving all jar artifacts from /opt/app-root/src/. directory into /wildfly/standalone/deployments for later deployment...
...done
Pushing image 172.30.1.1:5000/wfproject/openshift-jee-sample:latest ...
Pushed 0/12 layers, 17% complete
Pushed 1/12 layers, 33% complete
Pushed 2/12 layers, 33% complete
Pushed 3/12 layers, 33% complete
Pushed 4/12 layers, 33% complete
Pushed 5/12 layers, 42% complete
Pushed 6/12 layers, 50% complete
Pushed 7/12 layers, 59% complete
Pushed 8/12 layers, 67% complete
Pushed 8/12 layers, 75% complete
Pushed 8/12 layers, 83% complete
Pushed 8/12 layers, 90% complete
Pushed 9/12 layers, 92% complete
Pushed 10/12 layers, 97% complete
Pushed 11/12 layers, 98% complete
Pushed 11/12 layers, 99% complete
Pushed 11/12 layers, 100% complete
Pushed 12/12 layers, 100% complete
Push successful
```

## troubleshooting, links
* https://docs.okd.io/latest/minishift/openshift/exposing-services.html
* https://github.com/minishift/minishift/blob/master/docs/source/openshift/exposing-services.adoc

__blog with same config (local opnshift)__
https://blog.dbi-services.com/openshift-on-my-windows-10-laptop-with-minishift/

__routes__
* routename.projectname.instanceIP.nip.io
* https://medium.com/@ismailyenigul/openshift-and-dead-simple-wildcard-dns-for-any-ip-address-nip-io-9d56bab2afe2

__endpoint, port forwarding__
* https://medium.com/@kamesh_sampath/can-world-talk-to-my-minishift-b2dfae12073a
```
oc projects
oc project foobar
oc get pods
oc get endpoints
oc port-forward <pod> 8080:8080
```

__blog minishift__
* https://dev.to/livioribeiro/my-journey-through-openshift-13f2

__jenkins on minishift__
* https://medium.com/devopsturkiye/minishift-%C3%BCzerinde-jenkins-kurulumu-341158271795

__minishift config__
* minishift command
```
minishift config view
```
* https://itnext.io/how-to-access-your-app-behind-an-openshift-router-87cbae3e7185

__dns 8.8.8.8__
* https://stackoverflow.com/questions/43834159/minishift-could-not-resolve-192-168-64-2-nip-io
* resolve xip.io or nip.io
* put 8.8.8.8 (public google dns) into /etc/resolv.conf
* minishift do also a reach-check
```
Checking if external host is reachable from the Minishift VM ...
   Pinging 8.8.8.8 ... OK
```

__nip and xip io__
* replace nip.io with xip.io in CDK/Minishift
* you would have been affected by the unavailability of nip.io.
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

__nip io and LEDE / openwrt ...__
* https://stackoverflow.com/questions/43834159/minishift-could-not-resolve-192-168-64-2-nip-io
* https://forum.openwrt.org/t/nip-io-doesnt-work-for-local-network-behind-lede-solved-dns-rebind-protection/7766
```
I understand that NIP.io is a DNS service which basically converts any host <WHATEVER>.<IP>.nip.io to <IP> address.
```

__further links__
* https://github.com/minishift/minishift/issues/201
* https://forum.openwrt.org/t/nip-io-doesnt-work-for-local-network-behind-lede-solved-dns-rebind-protection/7766
* https://stackoverflow.com/questions/37150895/why-is-xip-io-needed-when-i-can-access-the-ip-directly
* https://github.com/coredns/coredns/issues/2393
    * For Minishift we tried to develop a local DNS solution, but ran into issues with macOS. This is because mac
* https://docs.okd.io/latest/install/prerequisites.html#prereq-dns
    * DNS Requirements
    * CONFIGURING HOSTS TO USE DNS
```
netsh interface ipv4 show interfaces
```

```
minishift ssh -- cat /etc/resolv.conf
```