# run OpenShift on local machine

__about__

* this description covers the setup with virtualbox under windows. but virtualbox runs also on Linux and Mac.

__precondition__
* ensure that you have installed VirtualBox on your (local) host machine

__steps to do__

0. our starting point: https://www.okd.io/minishift/
1. download minishift release
https://github.com/minishift/minishift/releases
2. add minishift dir to Path

3. set VirtualBox to minishift
```
minishift config set vm-driver virtualbox
```
* https://docs.okd.io/latest/minishift/getting-started/setting-up-virtualization-environment.html#setting-up-virtualbox-driver
4. start minishift
* i choose version 3.9.0 because versions above make trouble on my machine.
* if you leave memory flag then 4G is default value
```
minishift start --openshift-version v3.9.0 --memory 8G
```
* you can list available openshift versions with the following command
```
minishift openshift version list
```
5. set the oc path to environment 
```
minishift oc-env 
```
* output:
```
SET PATH=%userprofile%\.minishift\cache\oc\v3.9.0\windows;%PATH%
REM Run this command to configure your shell:
REM     @FOR /f "tokens=*" %i IN ('minishift oc-env') DO @call %i
```
* https://docs.okd.io/latest/minishift/getting-started/quickstart.html#starting-minishift

6. now you are ready do use oc cli
```
oc status
In project My Project (myproject) on server https://192.168.99.100:8443
```

7. further commands
* stop minishift
```
minishift stop
```
* delete minishift
```
minishift delete
```
