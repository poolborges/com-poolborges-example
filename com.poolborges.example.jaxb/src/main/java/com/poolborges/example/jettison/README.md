#About

JAXB implementations (Metro, EclipseLink MOXy, Apache JaxMe, etc) provide an easy means of converting objects to/from XML.  
There is a library called Jettison that exposes access to JSON messages via the StAX API that a JAXB implementation can use to convert objects to/from JSON.  
This library is being leveraged by a number of JAX-RS implementations.  
In this post I'll demonstrate its use in a standalone example.


#reference

* http://jettison.codehaus.org/Home
* http://blog.bdoughan.com/2011/04/jaxb-and-json-via-jettison.html