# Goods_CRUD

建立Maven项目，添加maven模块，将其中的server部分转换成web模块，

##在总的pom中添加
<code>
  <properties>
    <spring.version>3.2.9.RELEASE</spring.version>
    <mysql.version>5.1.10</mysql.version>
    <ojdbc.version>10.2.0.1.0</ojdbc.version>
    <c3p0.version>0.9.1.2</c3p0.version>
    <commons-dbcp.version>1.4</commons-dbcp.version>
    <quartz.version>1.6.1</quartz.version>
    <junit.version>4.10</junit.version>
    <slf4j.version>1.6.4</slf4j.version>
    <log4j.version>1.2.16</log4j.version>
    <commons-lang3.version>3.1</commons-lang3.version>
    <flexjson.version>3.3</flexjson.version>
    <commons-net.version>1.4.1</commons-net.version>
    <maven-resources-plugin.version>2.4.3</maven-resources-plugin.version>
  </properties>
  <dependencyManagement>
    <dependencies> 
<!-- commons -->
<!-- 
      为Java标准的Collections 
  API提供了相当好的补充。
      在此基础上对其常用的数据结构操作进行了很好的封装、抽象和补充。保证性能的同时大大简化代码
      整合spring-quartz时必须要有此包，否则报错
 -->
      <dependency>
        <groupId>commons-collections</groupId>
        <artifactId>commons-collections</artifactId>
        <version>3.2.1</version>
      </dependency>
<!--主要是一些工具类，涉及到数组工具类，字符串工具类，字符工具类，数学方面，时间日期工具类，异常，事件等工具类 -->
      <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>${commons-lang3.version}</version>
      </dependency>
<!-- 封装了各种网络协议的客户端，支持FTP、NNTP、SMTP、POP3、Telnet等协议。 -->
      <dependency>
        <groupId>commons-net</groupId>
        <artifactId>commons-net</artifactId>
        <version>${commons-net.version}</version>
      </dependency>
      <!-- Logger -->
      <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
      </dependency>
      <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j.version}</version>
      </dependency>
      <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>${slf4j.version}</version>
      </dependency>
      <dependency>
        <groupId>net.sf.flexjson</groupId>
        <artifactId>flexjson</artifactId>
        <version>${flexjson.version}</version>
      </dependency>
      <dependency>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-resources-plugin</artifactId>
        <version>${maven-resources-plugin.version}</version>
      </dependency>
    <!-- spring -->
    <!-- spring-core -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- spring-beans -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- spring-context -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context-support</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- spring-web -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- spring-webmvc -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- spring-jdbc -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- ORM -->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>${spring.version}</version>
      </dependency>
    <!-- 数据库驱动 -->
      <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc14</artifactId>
        <version>${ojdbc.version}</version>
      </dependency>
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
      </dependency>
    <!-- 连接池 -->
    <!-- c3p0 -->
      <dependency>
        <groupId>c3p0</groupId>
        <artifactId>c3p0</artifactId>
        <version>${c3p0.version}</version>
      </dependency>
    <!-- commons-dbcp数据库连接池  依赖包：Commons Logging、Commons Pool-->
      <dependency>
        <groupId>commons-dbcp</groupId>
        <artifactId>commons-dbcp</artifactId>
        <version>${commons-dbcp.version}</version>
      </dependency>
      <!-- quartz -->
      <dependency>
        <groupId>org.opensymphony.quartz</groupId>
        <artifactId>quartz-all</artifactId>
        <version>${quartz.version}</version>
      </dependency>
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
      </dependency>
    </dependencies>	
  </dependencyManagement>
</code>


##core层添加相应的依赖，
<code>
	 <dependencies>
    <!-- quartz-spring整合必须要此包 -->
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
    </dependency>
    <!-- spring -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <scope>runtime</scope>
    </dependency>
    <!-- quartz -->
    <dependency>
      <groupId>org.opensymphony.quartz</groupId>
      <artifactId>quartz-all</artifactId>
      <scope>runtime</scope>
    </dependency>
    <!-- junit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</code>

启动后可以看到
<code>
	2017-07-17 16:30:30,426 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
2017-07-17 16:30:30,426 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
2017-07-17 16:30:30,426 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
2017-07-17 16:30:30,426 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'goods-core.testJob'
2017-07-17 16:30:30,426 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating instance of bean 'goods-core.testJob'
beginTestJob
2017-07-17 16:30:30,429 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Eagerly caching bean 'goods-core.testJob' to allow for resolving potential circular references
2017-07-17 16:30:30,432 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Finished creating instance of bean 'goods-core.testJob'
2017-07-17 16:30:30,433 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,433 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating instance of bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,443 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Eagerly caching bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0' to allow for resolving potential circular references
2017-07-17 16:30:30,448 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating instance of bean 'org.springframework.scheduling.quartz.CronTriggerBean#4221f917'
2017-07-17 16:30:30,462 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating instance of bean 'org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858'
2017-07-17 16:30:30,471 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'goods-core.testJob'
2017-07-17 16:30:30,478 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Invoking afterPropertiesSet() on bean with name 'org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858'
2017-07-17 16:30:30,485 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Finished creating instance of bean 'org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858'
2017-07-17 16:30:30,487 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Invoking afterPropertiesSet() on bean with name 'org.springframework.scheduling.quartz.CronTriggerBean#4221f917'
2017-07-17 16:30:30,487 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Finished creating instance of bean 'org.springframework.scheduling.quartz.CronTriggerBean#4221f917'
2017-07-17 16:30:30,487 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Invoking afterPropertiesSet() on bean with name 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,515 [localhost-startStop-1] INFO org.quartz.core.SchedulerSignalerImpl - Initialized Scheduler Signaller of type: class org.quartz.core.SchedulerSignalerImpl
2017-07-17 16:30:30,515 [localhost-startStop-1] INFO org.quartz.core.QuartzScheduler - Quartz Scheduler v.1.6.1 created.
2017-07-17 16:30:30,516 [localhost-startStop-1] INFO org.quartz.simpl.RAMJobStore - RAMJobStore initialized.
2017-07-17 16:30:30,516 [localhost-startStop-1] INFO org.quartz.impl.StdSchedulerFactory - Quartz scheduler 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0' initialized from an externally provided properties instance.
2017-07-17 16:30:30,516 [localhost-startStop-1] INFO org.quartz.impl.StdSchedulerFactory - Quartz scheduler version: 1.6.1
2017-07-17 16:30:30,518 [localhost-startStop-1] INFO org.quartz.core.QuartzScheduler - JobFactory set to: org.springframework.scheduling.quartz.AdaptableJobFactory@61773723
2017-07-17 16:30:30,520 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Finished creating instance of bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,521 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#0'
2017-07-17 16:30:30,521 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
2017-07-17 16:30:30,522 [localhost-startStop-1] DEBUG org.springframework.web.context.support.XmlWebApplicationContext - Unable to locate LifecycleProcessor with name 'lifecycleProcessor': using default [org.springframework.context.support.DefaultLifecycleProcessor@c0b77a6]
2017-07-17 16:30:30,522 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,522 [localhost-startStop-1] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'lifecycleProcessor'
2017-07-17 16:30:30,523 [localhost-startStop-1] INFO org.springframework.context.support.DefaultLifecycleProcessor - Starting beans in phase 2147483647
2017-07-17 16:30:30,523 [localhost-startStop-1] DEBUG org.springframework.context.support.DefaultLifecycleProcessor - Starting bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0' of type [class org.springframework.scheduling.quartz.SchedulerFactoryBean]
2017-07-17 16:30:30,523 [localhost-startStop-1] INFO org.springframework.scheduling.quartz.SchedulerFactoryBean - Starting Quartz Scheduler now
2017-07-17 16:30:30,523 [localhost-startStop-1] INFO org.quartz.core.QuartzScheduler - Scheduler org.springframework.scheduling.quartz.SchedulerFactoryBean#0_$_NON_CLUSTERED started.
2017-07-17 16:30:30,523 [localhost-startStop-1] DEBUG org.springframework.context.support.DefaultLifecycleProcessor - Successfully started bean 'org.springframework.scheduling.quartz.SchedulerFactoryBean#0'
2017-07-17 16:30:30,525 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletConfigInitParams]
2017-07-17 16:30:30,525 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletContextInitParams]
2017-07-17 16:30:30,525 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Searching for key 'spring.liveBeansView.mbeanDomain' in [jndiProperties]
2017-07-17 16:30:30,525 [localhost-startStop-1] DEBUG org.springframework.jndi.JndiTemplate - Looking up JNDI object with name [java:comp/env/spring.liveBeansView.mbeanDomain]
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.jndi.JndiLocatorDelegate - Converted JNDI name [java:comp/env/spring.liveBeansView.mbeanDomain] not found - trying original name [spring.liveBeansView.mbeanDomain]. javax.naming.NameNotFoundException: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.jndi.JndiTemplate - Looking up JNDI object with name [spring.liveBeansView.mbeanDomain]
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.jndi.JndiPropertySource - JNDI lookup for name [spring.liveBeansView.mbeanDomain] threw NamingException with message: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].. Returning null.
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemProperties]
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemEnvironment]
2017-07-17 16:30:30,526 [localhost-startStop-1] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Could not find key 'spring.liveBeansView.mbeanDomain' in any property source. Returning [null]
2017-07-17 16:30:30,527 [localhost-startStop-1] DEBUG org.springframework.web.context.ContextLoader - Published root WebApplicationContext as ServletContext attribute with name [org.springframework.web.context.WebApplicationContext.ROOT]
2017-07-17 16:30:30,527 [localhost-startStop-1] INFO org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization completed in 456 ms
2017-07-17 16:30:30,529 [org.springframework.scheduling.quartz.SchedulerFactoryBean#0_Worker-1] DEBUG org.quartz.core.JobRunShell - Calling execute on job DEFAULT.org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858
Test quartz
七月 17, 2017 4:30:30 下午 org.apache.catalina.startup.HostConfig deployDirectory
信息: Deploying web application directory D:\WorkSpace\JAVAWorkSpace\HDTomcat\apache-tomcat-7.0.42\webapps\ROOT
七月 17, 2017 4:30:30 下午 org.apache.coyote.AbstractProtocol start
信息: Starting ProtocolHandler ["http-apr-8080"]
七月 17, 2017 4:30:30 下午 org.apache.coyote.AbstractProtocol start
信息: Starting ProtocolHandler ["ajp-apr-8009"]
七月 17, 2017 4:30:30 下午 org.apache.catalina.startup.Catalina start
信息: Server startup in 1678 ms
2017-07-17 16:30:35,002 [org.springframework.scheduling.quartz.SchedulerFactoryBean#0_Worker-2] DEBUG org.quartz.core.JobRunShell - Calling execute on job DEFAULT.org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858
Test quartz
2017-07-17 16:30:40,002 [org.springframework.scheduling.quartz.SchedulerFactoryBean#0_Worker-3] DEBUG org.quartz.core.JobRunShell - Calling execute on job DEFAULT.org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858
Test quartz
2017-07-17 16:30:45,002 [org.springframework.scheduling.quartz.SchedulerFactoryBean#0_Worker-4] DEBUG org.quartz.core.JobRunShell - Calling execute on job DEFAULT.org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858
Test quartz
2017-07-17 16:30:50,002 [org.springframework.scheduling.quartz.SchedulerFactoryBean#0_Worker-5] DEBUG org.quartz.core.JobRunShell - Calling execute on job DEFAULT.org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean#1e94e858
Test quartz
</code>
看到"Test quartz"证明定时任务启动
