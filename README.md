Test case: SPR-10903
================

This is a test case demonstrating the incorrect behavior described in [SPR-10903](https://jira.spring.io/browse/SPR-10903).
This example uses Spring Boot and can be launched as a plain Java jar.

The controller in this example has two request mappings intended to serve different versions of a JSON resource representation,
differentiated by a `version` media-type parameter. The mapping service correctly identifies that these are two separate
`produces` targets:

````
2014-07-07 10:52:15.543  INFO 1873 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/test/entity],methods=[],params=[],headers=[],consumes=[],produces=[application/x-spr-10903+json;version=1],custom=[]}" onto public com.chrylis.spr10903.Version1Entity com.chrylis.spr10903.MediaTypeParameterController.oldVersion()
2014-07-07 10:52:15.543  INFO 1873 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/test/entity],methods=[],params=[],headers=[],consumes=[],produces=[application/x-spr-10903+json;version=2],custom=[]}" onto public com.chrylis.spr10903.Version2Entity com.chrylis.spr10903.MediaTypeParameterController.newVersion()
````

However, any request to `/test/entity` with `Accept: application/x-spr-10903+json` is routed to `oldVersion()` instead of
being dispatched correctly according to the parameter.