#About

In a previous post I described how Jettison can be leveraged by a JAXB implementation to produce/consume JSON.  
A reader correctly pointed out that I did not describe how to handle namespaces.  
Since JSON does not support namespaces you would not normally include them in your mappings.  
However if you wanted to map your object model to both JSON and XML with namespaces, this post will demonstrate how it can be done.


#reference

* http://blog.bdoughan.com/2011/04/jaxb-and-json-via-jettison-namespace.html