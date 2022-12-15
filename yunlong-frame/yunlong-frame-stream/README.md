# 参考
[Spring Cloud Stream Kafka Binder 参考指南](https://cloud.spring.io/spring-cloud-stream-binder-kafka/spring-cloud-stream-binder-kafka.html)

# 配置
```yaml
spring:
  cloud:
    stream:
      kafka:
        binder:
          brokers: localhost:9092         #Kafka的消息中间件服务器
          zk-nodes: localhost:2181        #Zookeeper的节点，如果集群，后面加,号分隔
          auto-create-topics: true        #如果设置为false,就不会自动创建Topic 有可能你Topic还没创建就直接调用了。
      bindings:
        output:      #这里用stream给我们提供的默认output，后面会讲到自定义output        
            destination: stream-demo    #消息发往的目的地            
            content-type: text/plain    #消息发送的格式，接收端不用指定格式，但是发送端要
```