# Sentinel Dashboard 启动/运行

## 启动命令

```bash
java -Dserver.port=9006 -Dcsp.sentinel.dashboard.server=localhost:9006 -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=8719 -jar sentinel-dashboard-1.7.1.jar
```

## 参数说明

```text
-Dserver.port=9006 控制台端口，sentinel控制台是一个spring boot程序。客户端配置文件需要填对应的配置，如：spring.cloud.sentinel.transport.dashboard=192.168.1.102:8718
-Dcsp.sentinel.dashboard.server=localhost:9006 控制台的地址，指定控制台后, 客户端会自动向该地址发送心跳包
-Dproject.name=sentinel-dashboard  指定Sentinel控制台程序的名称
-Dcsp.sentinel.api.port=8719 (默认8719) 客户端提供给Dashboard访问或者查看Sentinel的运行访问的参数

注：csp.sentinel.dashboard.server这个配置是用在客户端，这里Sentinel控制台也使用是用于自己监控自己程序的api，否则无法显示控制台的api情况，当然这个也可以根据情况不显示。
注：csp.sentinel.api.port=8719是客户端的端口，需要把客户端设置的端口穿透防火墙，可在控制台的“机器列表”中查看到端口号，这里Sentinel控制台也使用是用于自己程序的api传输，由于是默认端口所以控制台也可以不设置。
注：客户端需向控制台提供端口，配置文件配置，如：spring.cloud.sentinel.transport.port=8720
```

* 更多启动参数配置参考:[https://github.com/alibaba/Sentinel/wiki/%E5%90%AF%E5%8A%A8%E9%85%8D%E7%BD%AE%E9%A1%B9](https://github.com/alibaba/Sentinel/wiki/%E5%90%AF%E5%8A%A8%E9%85%8D%E7%BD%AE%E9%A1%B9)
* Spring Cloud Alibaba Sentinel: [https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel](https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel)

## 守护进程

1. 创建守护进程
```bash
vim /lib/systemd/system/sentinel-dashboard.service
```
2. 填入脚本内容

```bash
[Unit]
Description=sentinel-dashboard
After=syslog.target network.target remote-fs.target nss-lookup.target

[Service]
Type=simple 
# 这个脚本路径根据实际情况修改
ExecStart=/opt/sentinel-dashboard/startup.sh 
Restart=always 
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

3. 授权

```bash
chmod 777 /lib/systemd/system/sentinel-dashboard.service
```

4. 启用服务

```bash
systemctl enable sentinel-dashboard.service
systemctl daemon-reload
```

5. 运行 查看状态

```bash
systemctl start sentinel-dashboard.service
systemctl status sentinel-dashboard.service
```

6. 查看进程 端口

```bash
ps -ef|grep sentinel-dashboard
netstat -anltp|grep 8718
```