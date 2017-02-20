Repository Init Content
=======================

Project to test serialization of java.time.LocalDateTime variables.

In order to reproduce the error you should clone the repository in business-central, build it, create a container (e.g. keypartner:variable-serialization:1.0) and then using a rest client (e.g postman) create the following request, using the correct values for host and port:

Request URI
http://localhost:8080/kie-server/services/rest/server/containers/keypartner:variable-serialization:1.0/processes/variable-serialization.localdatetime-sample-process/instances

Request Method -> POST

Request Payload
{"request":{"keypartner.MyPojo":{"creationTime":"2017-02-18T16:10:37.063"}}}

The call should trigger the following error:

2017-02-20 13:29:23,940 ERROR [org.kie.server.remote.rest.jbpm.ProcessResource] (default task-10) Unexpected error during processing Error unmarshalling input: org.kie.server.api.marshalling.MarshallingException: Error unmarshalling input
	at org.kie.server.api.marshalling.json.JSONMarshaller.unmarshall(JSONMarshaller.java:351)
	at org.kie.server.services.impl.marshal.MarshallerHelper.unmarshal(MarshallerHelper.java:97)
	at org.kie.server.services.jbpm.ProcessServiceBase.startProcess(ProcessServiceBase.java:83)
	at org.kie.server.remote.rest.jbpm.ProcessResource.startProcess(ProcessResource.java:93)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:139)
	at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTarget(ResourceMethodInvoker.java:295)
	at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:249)
	at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:236)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:402)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:209)
	at org.jboss.resteasy.plugins.server.servlet.ServletContainerDispatcher.service(ServletContainerDispatcher.java:221)
	at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:56)
	at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:51)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:131)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.DisableCacheHandler.handleRequest(DisableCacheHandler.java:33)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AuthenticationConstraintHandler.handleRequest(AuthenticationConstraintHandler.java:51)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.servlet.handlers.security.ServletSecurityConstraintHandler.handleRequest(ServletSecurityConstraintHandler.java:59)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.NotificationReceiverHandler.handleRequest(NotificationReceiverHandler.java:50)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:285)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:264)
	at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:81)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:175)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:207)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:802)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: org.codehaus.jackson.map.JsonMappingException: Can not instantiate value of type [simple type, class java.time.LocalDateTime] from JSON String; no single-String constructor/factory method (through reference chain: keypartner.MyPojo["creationTime"])
	at org.codehaus.jackson.map.deser.std.StdValueInstantiator._createFromStringFallbacks(StdValueInstantiator.java:379)
	at org.codehaus.jackson.map.deser.std.StdValueInstantiator.createFromString(StdValueInstantiator.java:268)
	at org.codehaus.jackson.map.deser.BeanDeserializer.deserializeFromString(BeanDeserializer.java:765)
	at org.codehaus.jackson.map.deser.BeanDeserializer.deserialize(BeanDeserializer.java:585)
	at org.codehaus.jackson.map.deser.SettableBeanProperty.deserialize(SettableBeanProperty.java:299)
	at org.codehaus.jackson.map.deser.SettableBeanProperty$MethodProperty.deserializeAndSet(SettableBeanProperty.java:414)
	at org.codehaus.jackson.map.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:697)
	at org.codehaus.jackson.map.deser.BeanDeserializer.deserialize(BeanDeserializer.java:580)
	at org.kie.server.api.marshalling.json.JSONMarshaller$3$1.deserializeTypedFromObject(JSONMarshaller.java:218)
	at org.codehaus.jackson.map.deser.BeanDeserializer.deserializeWithType(BeanDeserializer.java:664)
	at org.codehaus.jackson.map.deser.StdDeserializerProvider$WrappedDeserializer.deserialize(StdDeserializerProvider.java:461)
	at org.codehaus.jackson.map.ObjectMapper._readValue(ObjectMapper.java:2704)
	at org.codehaus.jackson.map.ObjectMapper.readValue(ObjectMapper.java:1286)
	at org.kie.server.api.marshalling.json.JSONMarshaller$CustomObjectDeserializer.mapObject(JSONMarshaller.java:605)
	at org.codehaus.jackson.map.deser.std.UntypedObjectDeserializer.deserialize(UntypedObjectDeserializer.java:47)
	at org.codehaus.jackson.map.deser.std.MapDeserializer._readAndBind(MapDeserializer.java:319)
	at org.codehaus.jackson.map.deser.std.MapDeserializer.deserialize(MapDeserializer.java:249)
	at org.codehaus.jackson.map.deser.std.MapDeserializer.deserialize(MapDeserializer.java:33)
	at org.codehaus.jackson.map.ObjectMapper._readMapAndClose(ObjectMapper.java:2732)
	at org.codehaus.jackson.map.ObjectMapper.readValue(ObjectMapper.java:1863)
	at org.kie.server.api.marshalling.json.JSONMarshaller.unmarshall(JSONMarshaller.java:349)
	... 47 more